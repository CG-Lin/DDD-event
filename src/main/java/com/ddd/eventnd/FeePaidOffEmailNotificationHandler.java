package com.ddd.eventnd;

public class FeePaidOffEmailNotificationHandler implements DomainEventHandler<FeePaidOff>{
    @Override
    public void handle(FeePaidOff args) {
        // 应用发送邮件
        System.out.println("Sending notification email,Notify the user that the bill has been settled");
    }
}
