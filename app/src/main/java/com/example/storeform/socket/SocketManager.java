package com.example.storeform.socket;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import com.google.gson.Gson;


public class SocketManager {
    private Socket socket;
    private Gson gson;

    private String address, port, sessionId;
    private boolean isConnecting;
    private boolean isConnect;

    public void initSocket(String address, String port, String sessionId) {
        this.address = address;
        this.port = port;
        this.sessionId = sessionId;
        initSocket();

        if (socket==null){
            //
            return;
        }

        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                isConnect = true;
                isConnecting = false;
            }
        });
        socket.on(Socket.EVENT_RECONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {

            }
        });

        socket.on(Socket.EVENT_CONNECTING, new Emitter.Listener() {
            @Override
            public void call(Object... args) {

            }
        });

        socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {

            }
        });


    }

    private void initSocket() {
    }
}
