package com.firstclub.membership.tier;

import java.util.Set;

public interface Tier {
    TierCode getCode();
    Set<String> getBenefits();
}
