package com.immersion.useraudit.audit.util;

import com.immersion.useraudit.audit.domain.enums.EventCode;

public class EventCodeImpl {

    public static void main(String args[]) {
       /* EventCode eventCode = EventCode.completed;
        System.out.println(eventCode);*/
        for (EventCode eventCode : EventCode.values())
            System.out.println(eventCode);


    }
}
