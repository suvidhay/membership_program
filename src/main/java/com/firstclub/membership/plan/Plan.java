package com.firstclub.membership.plan;

import java.math.BigDecimal;
import java.time.Duration;

public interface Plan {
    PlanCode getCode();
    BigDecimal getPrice();
    Duration getPeriod();
}
