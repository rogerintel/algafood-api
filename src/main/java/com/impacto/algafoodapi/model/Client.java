package com.impacto.algafoodapi.model;

public class Client {
    private final String email;
    private final String phone;
    private final String name;

    public Client(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void activate() {
        boolean active = true;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
