package com.example.aviv.project1;

/**
 * Created by Aviv on 28/01/2018.
 */

public class Msg
{
    private String msg;
    private String name;

    public Msg(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }






}

