package com.impacto.algafoodapi.listener;

import com.impacto.algafoodapi.notifiers.Notifier;
import com.impacto.algafoodapi.notifiers.NotifierType;
import com.impacto.algafoodapi.notifiers.UrgenceLevel;
import com.impacto.algafoodapi.service.ActivationClientEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    @NotifierType(UrgenceLevel.LOW)
    @Autowired
    private Notifier notifier;

    @EventListener
    public void activateClientListener(ActivationClientEvent event) {
        notifier.notify(event.getClient(), "Your account is now active");
    }
}
