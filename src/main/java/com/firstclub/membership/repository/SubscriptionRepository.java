package com.firstclub.membership.repository;

import java.util.UUID;
import com.firstclub.membership.entities.Subscription;

public interface SubscriptionRepository {
    void save(Subscription sub);
    Subscription findById(UUID id);
    Subscription findActiveByUserId(UUID userId);
}
