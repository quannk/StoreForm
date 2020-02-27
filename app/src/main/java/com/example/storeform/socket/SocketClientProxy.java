package com.example.storeform.socket;

import com.example.storeform.mvc.IController;
import com.example.storeform.mvc.Mvc;
import com.tvd12.ezyfoxserver.client.EzyClient;
import com.tvd12.ezyfoxserver.client.EzyClients;
import com.tvd12.ezyfoxserver.client.config.EzyClientConfig;
import com.tvd12.ezyfoxserver.client.constant.EzyCommand;
import com.tvd12.ezyfoxserver.client.entity.EzyApp;
import com.tvd12.ezyfoxserver.client.entity.EzyArray;
import com.tvd12.ezyfoxserver.client.entity.EzyData;
import com.tvd12.ezyfoxserver.client.event.EzyDisconnectionEvent;
import com.tvd12.ezyfoxserver.client.event.EzyEventType;
import com.tvd12.ezyfoxserver.client.event.EzyLostPingEvent;
import com.tvd12.ezyfoxserver.client.event.EzyTryConnectEvent;
import com.tvd12.ezyfoxserver.client.handler.EzyAppAccessHandler;
import com.tvd12.ezyfoxserver.client.handler.EzyConnectionFailureHandler;
import com.tvd12.ezyfoxserver.client.handler.EzyConnectionSuccessHandler;
import com.tvd12.ezyfoxserver.client.handler.EzyDisconnectionHandler;
import com.tvd12.ezyfoxserver.client.handler.EzyEventHandler;
import com.tvd12.ezyfoxserver.client.handler.EzyLoginErrorHandler;
import com.tvd12.ezyfoxserver.client.handler.EzyLoginSuccessHandler;
import com.tvd12.ezyfoxserver.client.request.EzyAppAccessRequest;
import com.tvd12.ezyfoxserver.client.request.EzyRequest;
import com.tvd12.ezyfoxserver.client.setup.EzyAppSetup;
import com.tvd12.ezyfoxserver.client.setup.EzySetup;

public class SocketClientProxy {
    private final Mvc mvc = Mvc.getInstance();
    private static final SocketClientProxy INSTANCE = new SocketClientProxy();

    public static SocketClientProxy getInstance() {
        return INSTANCE;
    }
    public void setup() {
        final IController loginController = mvc.getController("login");
        final IController connectionController = mvc.getController("connection");
        final IController contactController = mvc.getController("contact");
        final IController messageController = mvc.getController("message");
        final EzyClientConfig config = EzyClientConfig.builder()
                .zoneName("freechat")
                .build();
        final EzyClients clients = EzyClients.getInstance();
        EzyClient oldClient = clients.getDefaultClient();
        final EzyClient client = oldClient != null ? oldClient : clients.newDefaultClient(config);
        final EzySetup setup = client.setup();
        setup.addEventHandler(EzyEventType.CONNECTION_SUCCESS, new EzyConnectionSuccessHandler() {
            @Override
            protected void postHandle() {
                connectionController.updateView("hide-loading");
            }
        });
        setup.addEventHandler(EzyEventType.CONNECTION_FAILURE, new EzyConnectionFailureHandler());
        setup.addEventHandler(EzyEventType.DISCONNECTION, new EzyDisconnectionHandler() {
            @Override
            protected void preHandle(EzyDisconnectionEvent event) {
                connectionController.updateView("show-loading");
            }

            @Override
            protected void control(EzyDisconnectionEvent event) {
                connectionController.updateView("hide-loading");
            }

            @Override
            protected boolean shouldReconnect(EzyDisconnectionEvent event) {
                if(event.getReason() == 401)
                    return false;
                return super.shouldReconnect(event);
            }
        });

        setup.addDataHandler(EzyCommand.LOGIN, new EzyLoginSuccessHandler() {

            @Override
            protected void handleLoginSuccess(EzyData responseData) {
                EzyRequest request = new EzyAppAccessRequest("freechat");
                client.send(request);
            }
        });
        setup.addDataHandler(EzyCommand.LOGIN_ERROR, new EzyLoginErrorHandler() {
            @Override
            protected void handleLoginError(EzyArray data) {
                loginController.updateView("show-failure", data.get(1, String.class));
            }
        });
        setup.addDataHandler(EzyCommand.APP_ACCESS, new EzyAppAccessHandler() {
            @Override
            protected void postHandle(EzyApp app, EzyArray data) {
                connectionController.updateView("show-contacts");
            }
        });
        setup.addEventHandler(EzyEventType.LOST_PING, new EzyEventHandler<EzyLostPingEvent>() {
            @Override
            public void handle(EzyLostPingEvent event) {
                connectionController.updateView("show-lost-ping", event.getCount());
            }
        });

        setup.addEventHandler(EzyEventType.TRY_CONNECT, new EzyEventHandler<EzyTryConnectEvent>() {
            @Override
            public void handle(EzyTryConnectEvent event) {
                connectionController.updateView("show-try-connect", event.getCount());
            }
        });

        EzyAppSetup appSetup = setup.setupApp("freechat");

    }

    public void connect() {
        EzyClient client = getClient();
        client.connect("ws.tvd12.com", 3005);
    }

    public EzyClient getClient() {
        EzyClients clients = EzyClients.getInstance();
        return clients.getDefaultClient();
    }

}
