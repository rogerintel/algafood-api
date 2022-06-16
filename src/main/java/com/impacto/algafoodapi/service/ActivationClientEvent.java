package com.impacto.algafoodapi.service;

import com.impacto.algafoodapi.model.Client;

public class ActivationClientEvent {

    private final Client client;

    public ActivationClientEvent(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
