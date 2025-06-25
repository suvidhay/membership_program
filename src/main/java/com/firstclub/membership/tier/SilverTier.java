package com.firstclub.membership.tier;

import java.util.Set;

public final class SilverTier implements Tier {

    private static final Set<String> BENEFITS = Set.of("FREE_SHIP");

    @Override
    public TierCode getCode() {
        return TierCode.SILVER;
    }

    @Override
    public Set<String> getBenefits() {
        return BENEFITS;
    }
}
