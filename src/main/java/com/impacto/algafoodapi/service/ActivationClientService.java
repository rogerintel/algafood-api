package com.impacto.algafoodapi.service;

import com.impacto.algafoodapi.model.Client;
import com.impacto.algafoodapi.notifiers.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivationClientService {

    @Autowired
    private Notifier notifier;

    public void activate(Client client) {
        client.activate();
        notifier.notify(client, "Your account has been activated");
    }
}
