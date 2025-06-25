package com.firstclub.membership.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.UUID;

import com.firstclub.membership.service.*;
import com.firstclub.membership.plan.*;
import com.firstclub.membership.tier.*;
import com.firstclub.membership.entities.Subscription;

@RestController
@RequestMapping("/api/v1")
public class MembershipController {

    private final MembershipService service;

    public MembershipController(MembershipService service) {
        this.service = service;
    }

    @GetMapping("/plans")
    public List<Plan> plans() { return service.listPlans(); }

    @GetMapping("/tiers")
    public List<Tier> tiers() { return service.listTiers(); }

    @PostMapping("/subscriptions")
    public ResponseEntity<UUID> subscribe(@RequestBody SubscribeRequest req) {
        UUID id = service.subscribe(req.getUserId(), req.getPlan());
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PatchMapping("/subscriptions/{id}/plan")
    public void changePlan(@PathVariable UUID id, @RequestBody ChangePlanRequest req) {
        service.changePlan(id, req.getNewPlan());
    }

    @PatchMapping("/subscriptions/{id}/tier")
    public void changeTier(@PathVariable UUID id, @RequestBody ChangeTierRequest req) {
        service.changeTier(id, req.getNewTier());
    }

    @PatchMapping("/subscriptions/{id}/cancel")
    public void cancel(@PathVariable UUID id) { service.cancel(id); }

    @GetMapping("/users/{uid}/subscription")
    public Subscription current(@PathVariable UUID uid) { return service.currentSubscription(uid); }

    public static class SubscribeRequest {
        private UUID userId;
        private PlanCode plan;
        public UUID getUserId() { return userId; }
        public PlanCode getPlan() { return plan; }
        public void setUserId(UUID userId) { this.userId = userId; }
        public void setPlan(PlanCode plan) { this.plan = plan; }
    }

    public static class ChangePlanRequest {
        private PlanCode newPlan;
        public PlanCode getNewPlan() { return newPlan; }
        public void setNewPlan(PlanCode newPlan) { this.newPlan = newPlan; }
    }

    public static class ChangeTierRequest {
        private TierCode newTier;
        public TierCode getNewTier() { return newTier; }
        public void setNewTier(TierCode newTier) { this.newTier = newTier; }
    }
}
