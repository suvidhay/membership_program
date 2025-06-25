package com.firstclub.membership.repository;

import java.util.*;
import java.util.UUID;
import com.firstclub.membership.entities.Subscription;

public class InMemorySubscriptionRepository implements SubscriptionRepository {

    private final Map<UUID, Subscription> store = new HashMap<>();

    public void save(Subscription sub) { store.put(sub.getId(), sub); }
    public Subscription findById(UUID id) { return store.get(id); }
    public Subscription findActiveByUserId(UUID userId) {
        return store.values().stream()
            .filter(s -> s.getUserId().equals(userId) && s.getStatus() == Subscription.Status.ACTIVE)
            .findFirst().orElse(null);
    }
}
