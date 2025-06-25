package com.firstclub.membership.plan;

import java.math.BigDecimal;
import java.time.Duration;

public final class QuarterlyPlan implements Plan {

    private static final BigDecimal PRICE = new BigDecimal("549");
    private static final Duration PERIOD = Duration.ofDays(90);

    @Override
    public PlanCode getCode() {
        return PlanCode.QUARTERLY;
    }

    @Override
    public BigDecimal getPrice() {
        return PRICE;
    }

    @Override
    public Duration getPeriod() {
        return PERIOD;
    }
}
