package com.example.shopee_s25378;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientStorage {

    private List<Client> clientList = new ArrayList<>();


    public void addClient(Client client) {
        clientList.add(client);
    }

    public Optional<Client> findClientById(int clientId) {
        return getAll().stream()
                .filter(client -> client.getId().equals(clientId))
                .findFirst();
    }

    public List<Client> getAll() {
        return clientList;
    }

    public void purgeList() {
        clientList.clear();
    }
}
