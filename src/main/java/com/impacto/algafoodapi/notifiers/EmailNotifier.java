package com.impacto.algafoodapi.notifiers;

import com.impacto.algafoodapi.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NotifierType(UrgenceLevel.LOW)
@Component
public class EmailNotifier implements Notifier {

    @Autowired
    private NotifiersProperties notifiersProperties;

    @Override
    public void notify(Client client, String message) {
        System.out.printf("Host: %s%nPort: %d%n", notifiersProperties.getHost(), notifiersProperties.getPort());
        System.out.printf("Notifyed %s by e-mail to %s: %s%n", client.getName(), client.getEmail(), message);

    }
}
