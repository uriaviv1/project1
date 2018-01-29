package com.example.aviv.project1;

/**
 * Created by Aviv on 28/01/2018.
 */

public class Message
{

    private String message;
    private String name;

    public Message() {
        this(null, null);
    }

    public Message(String name, String msg) {
        this.name = name;
        this.message = msg;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}

