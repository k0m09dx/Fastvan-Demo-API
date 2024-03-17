package com.fastvan.fastvandemoapi.service;


import co.novu.api.common.SubscriberRequest;
import co.novu.api.events.pojos.BulkTriggerEventRequest;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberRequest;
import co.novu.common.base.Novu;
import co.novu.common.base.NovuConfig;
import com.fastvan.fastvandemoapi.model.CreateNotificationRequest;
import com.fastvan.fastvandemoapi.model.NotificationPayload;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendEmailNotification(NotificationPayload payload){

        NovuConfig novuConfig = new NovuConfig("84ec569ea714ab0e901e3a5dcccd1bcf");
        novuConfig.setBaseUrl("https://api.novu.co/v1/");
        Novu novu = new Novu(novuConfig);

        SubscriberRequest subscriberRequest = getSubscriberRequest(payload);

        TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
        triggerEventRequest.setName("javaspringnovu");
        triggerEventRequest.setTo(subscriberRequest);

        if(!Objects.isNull(payload.getAdditionalData())  && !payload.getAdditionalData().isEmpty()) {
            triggerEventRequest.setPayload(payload.getAdditionalData());
        }
        try {
             novu.triggerEvent(triggerEventRequest);
        }catch (Exception ex){
            log.error("Error triggering event", ex);
        }
    }

    @NotNull
    private static SubscriberRequest getSubscriberRequest(NotificationPayload payload) {
        SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setSubscriberId("65f682dd7aae5181b72b9816");
        subscriberRequest.setEmail(payload.getEmailId());
        subscriberRequest.setFirstName(payload.getFirstName());
        subscriberRequest.setLastName(payload.getLastName());
        if(!Strings.isEmpty(payload.getPhoneNo()) && !payload.getPhoneNo().equals("string")) {
            subscriberRequest.setPhone(payload.getPhoneNo());
        }
        return subscriberRequest;
    }

    @Override
    public void sendEmailNotificationBulk(CreateNotificationRequest payload) {
        NovuConfig novuConfig = new NovuConfig("84ec569ea714ab0e901e3a5dcccd1bcf");
        novuConfig.setBaseUrl("https://api.novu.co/v1/");
        Novu novu = new Novu(novuConfig);
        List<TriggerEventRequest> creteTriggerEvents = new ArrayList<>();

        if(!Objects.isNull(payload.getNotificationPayload()) && !payload.getNotificationPayload().isEmpty()) {
            for(NotificationPayload notificationPayload : payload.getNotificationPayload()) {
                SubscriberRequest subscriberRequest = getSubscriberRequest(notificationPayload);

                TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
                triggerEventRequest.setName("javaspringnovu");
                triggerEventRequest.setTo(subscriberRequest);

                if(!Objects.isNull(notificationPayload.getAdditionalData())  && !notificationPayload.getAdditionalData().isEmpty()) {
                    triggerEventRequest.setPayload(notificationPayload.getAdditionalData());
                }

                creteTriggerEvents.add(triggerEventRequest);
            }
        }
        BulkTriggerEventRequest request = new BulkTriggerEventRequest();
        request.setEvents(creteTriggerEvents);
        try{
            novu.bulkTriggerEvent(request);
        }catch (Exception ex){
            log.error("Error triggering event", ex);
        }
    }

    @Override
    public void createWorkflow() {

    }

    public void updateSubscriber() {
        String apiKey = "84ec569ea714ab0e901e3a5dcccd1bcf";
        Novu novu = new Novu(apiKey);

        UpdateSubscriberRequest updateSubscriberRequest = new UpdateSubscriberRequest();
        updateSubscriberRequest.setEmail("koushik.mondal@fastvan.ai");
        updateSubscriberRequest.setFirstName("koushik");
        updateSubscriberRequest.setLastName("mondal");
        updateSubscriberRequest.setPhone("+919000755025");
        updateSubscriberRequest.setAvatar("avatar");

        String subscriberId = "65f682dd7aae5181b72b9816";

        try {
            novu.updateSubscriber(updateSubscriberRequest, subscriberId);
        }catch (Exception e){
            log.error("Error updating Subscriber", e);
        }
    }

}
