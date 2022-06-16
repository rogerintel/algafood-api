package com.impacto.algafoodapi.listener;

import com.impacto.algafoodapi.service.ActivationClientEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AddInvoiceService {

    @EventListener
    public void activatedClientListener(ActivationClientEvent event) {
        System.out.println("Issuing invoice to customer " + event.getClient().getName());
    }
}
