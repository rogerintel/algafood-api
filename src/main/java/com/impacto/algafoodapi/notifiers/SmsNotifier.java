package com.impacto.algafoodapi.notifiers;

import com.impacto.algafoodapi.model.Client;
import org.springframework.stereotype.Component;

@NotifierType(UrgenceLevel.HIGH)
@Component
public class SmsNotifier implements Notifier {
    @Override
    public void notify(Client client, String message) {
        System.out.printf("Notifyed %s by SMS %s: %s%n", client.getName(), client.getPhone(), message);
    }
}
