package com.firstclub.membership;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import com.firstclub.membership.plan.*;
import com.firstclub.membership.tier.*;
import com.firstclub.membership.repository.*;
import com.firstclub.membership.service.*;

@SpringBootApplication(scanBasePackages = "com.firstclub.membership")
public class MembershipApplication {

    @Bean
    public MembershipService membershipService() {
        PlanRepository planRepo = new InMemoryPlanRepository();
        planRepo.save(new MonthlyPlan());
        planRepo.save(new QuarterlyPlan());
        planRepo.save(new YearlyPlan());

        TierRepository tierRepo = new InMemoryTierRepository();
        tierRepo.save(new SilverTier());
        tierRepo.save(new GoldTier());
        tierRepo.save(new PlatinumTier());

        SubscriptionRepository subRepo = new InMemorySubscriptionRepository();
        return new MembershipServiceImpl(planRepo, tierRepo, subRepo);
    }

    public static void main(String[] args) {
        SpringApplication.run(MembershipApplication.class, args);
    }
}
