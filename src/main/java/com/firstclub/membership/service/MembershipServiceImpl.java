package com.firstclub.membership.service;

import java.util.List;
import java.util.UUID;

import com.firstclub.membership.plan.*;
import com.firstclub.membership.tier.*;
import com.firstclub.membership.entities.Subscription;
import com.firstclub.membership.repository.*;
import com.firstclub.membership.exceptions.*;

public class MembershipServiceImpl implements MembershipService {

    private final PlanRepository planRepo;
    private final TierRepository tierRepo;
    private final SubscriptionRepository subRepo;

    public MembershipServiceImpl(PlanRepository planRepo, TierRepository tierRepo, SubscriptionRepository subRepo) {
        this.planRepo = planRepo;
        this.tierRepo = tierRepo;
        this.subRepo = subRepo;
    }

    public List<Plan> listPlans() { return planRepo.findAll(); }
    public List<Tier> listTiers() { return tierRepo.findAll(); }

    public UUID subscribe(UUID userId, PlanCode planCode) {
        Plan plan = planRepo.findByCode(planCode);
        if (plan == null) throw new PlanNotFoundException("Plan " + planCode);

        Tier base = tierRepo.findByCode(TierCode.SILVER);
        if (base == null) throw new TierNotFoundException("Base SILVER missing");

        Subscription sub = new Subscription(userId, plan, base);
        subRepo.save(sub);
        return sub.getId();
    }

    public void changePlan(UUID subId, PlanCode planCode) {
        Subscription sub = subRepo.findById(subId);
        if (sub == null) throw new SubscriptionNotFoundException("Subscription " + subId);

        Plan plan = planRepo.findByCode(planCode);
        if (plan == null) throw new PlanNotFoundException("Plan " + planCode);
        sub.changePlan(plan);
    }

    public void changeTier(UUID subId, TierCode tierCode) {
        Subscription sub = subRepo.findById(subId);
        if (sub == null) throw new SubscriptionNotFoundException("Subscription " + subId);

        Tier tier = tierRepo.findByCode(tierCode);
        if (tier == null) throw new TierNotFoundException("Tier " + tierCode);
        sub.changeTier(tier);
    }

    public void cancel(UUID subId) {
        Subscription sub = subRepo.findById(subId);
        if (sub == null) throw new SubscriptionNotFoundException("Subscription " + subId);
        sub.cancel();
    }

    public Subscription currentSubscription(UUID userId) {
        return subRepo.findActiveByUserId(userId);
    }
}
