package com.impacto.algafoodapi.notifiers;

import com.impacto.algafoodapi.model.Client;

public interface Notifier {
    void notify(Client client, String message);
}
