package com.example.storeform.data.Message;

import com.example.storeform.base.MessageType;
import com.tvd12.ezyfoxserver.client.constant.EzyConstant;


/**
 * Created by tavandung12 on 10/7/18.
 */

public class MessageSent extends Message {

    public MessageSent(long channelId, String message) {
        super( channelId, message);
    }

    @Override
    public EzyConstant getType() {
        return MessageType.SENT;
    }
}
