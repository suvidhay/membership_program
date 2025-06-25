package com.firstclub.membership.entities;

import java.time.LocalDate;
import java.util.UUID;

import com.firstclub.membership.plan.Plan;
import com.firstclub.membership.tier.Tier;

public class Subscription {

    private final UUID id = UUID.randomUUID();
    private final UUID userId;
    private Plan plan;
    private Tier tier;
    private LocalDate startAt;
    private LocalDate endAt;
    private Status status = Status.ACTIVE;

    public enum Status { ACTIVE, CANCELLED, EXPIRED }

    public Subscription(UUID userId, Plan plan, Tier tier) {
        this.userId = userId;
        this.plan = plan;
        this.tier = tier;
        renew();
    }

    private void renew() {
        this.startAt = LocalDate.now();
        this.endAt = startAt.plusDays(plan.getPeriod().toDays());
    }

    public void changePlan(Plan plan) {
        if (status == Status.ACTIVE) {
            this.plan = plan;
            renew();
        }
    }

    public void changeTier(Tier tier) {
        if (status == Status.ACTIVE) {
            this.tier = tier;
        }
    }

    public void cancel() {
        this.status = Status.CANCELLED;
        this.endAt = LocalDate.now();
    }

    public UUID getId() { return id; }
    public UUID getUserId() { return userId; }
    public Plan getPlan() { return plan; }
    public Tier getTier() { return tier; }
    public Status getStatus() { return status; }
    public LocalDate getStartAt() { return startAt; }
    public LocalDate getEndAt() { return endAt; }
}
