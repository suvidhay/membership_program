package com.firstclub.membership.service;

import java.util.List;
import java.util.UUID;

import com.firstclub.membership.plan.Plan;
import com.firstclub.membership.plan.PlanCode;
import com.firstclub.membership.tier.Tier;
import com.firstclub.membership.tier.TierCode;
import com.firstclub.membership.entities.Subscription;

public interface MembershipService {
    List<Plan> listPlans();
    List<Tier> listTiers();
    UUID subscribe(UUID userId, PlanCode plan);
    void changePlan(UUID subscriptionId, PlanCode plan);
    void changeTier(UUID subscriptionId, TierCode tier);
    void cancel(UUID subscriptionId);
    Subscription currentSubscription(UUID userId);
}
