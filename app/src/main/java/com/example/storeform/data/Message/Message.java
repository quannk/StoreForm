package com.example.storeform.data.Message;


import com.tvd12.ezyfoxserver.client.codec.EzyObjectDeserializable;
import com.tvd12.ezyfoxserver.client.constant.EzyConstant;
import com.tvd12.ezyfoxserver.client.entity.EzyObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Message implements EzyObjectDeserializable {

    protected Long channelId;
    protected String message;
    protected Date sentTime;

    public Message() {
    }

    public Message(long channelId, String message) {
        this(channelId, message, new Date());
    }

    public Message(long channelId, String message, Date sentTime) {
        this.channelId = channelId;
        this.message = message;
        this.sentTime = sentTime;
    }

    @Override
    public void deserialize(EzyObject data) {
        this.message = data.get("message");
        this.channelId = data.get("channelId", Long.class);
    }

    public Long getChannelId() {
        return channelId;
    }

    public String getMessage() {
        return message;
    }

    public abstract EzyConstant getType();

    public String getSentTimeString() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
        String answer = format.format(sentTime);
        return answer;
    }
}
