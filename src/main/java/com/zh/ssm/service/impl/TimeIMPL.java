package com.zh.ssm.service.impl;

import com.zh.ssm.service.Timer;

public class TimeIMPL implements Timer {
    @Override
    public void doAuditing(String name) {
        System.out.println("正在审核");
    }
}
