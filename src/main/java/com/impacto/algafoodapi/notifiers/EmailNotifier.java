package com.impacto.algafoodapi.notifiers;

import com.impacto.algafoodapi.model.Client;
import org.springframework.stereotype.Component;

@NotifierType(UrgenceLevel.LOW)
@Component
public class EmailNotifier implements Notifier {
    @Override
    public void notify(Client client, String message) {
        System.out.printf("Notifyed %s by e-mail to %s: %s%n", client.getName(), client.getEmail(), message);

    }
}
