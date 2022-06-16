package com.impacto.algafoodapi.service;

import com.impacto.algafoodapi.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ActivationClientService {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void activate(Client client) {
        client.activate();
        publisher.publishEvent(new ActivationClientEvent(client));
    }
}
