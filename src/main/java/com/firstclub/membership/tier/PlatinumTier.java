package com.firstclub.membership.tier;

import java.util.Set;

public final class PlatinumTier implements Tier {

    private static final Set<String> BENEFITS = Set.of("FREE_SHIP", "EXTRA_10_PERCENT", "EARLY_ACCESS");

    @Override
    public TierCode getCode() {
        return TierCode.PLATINUM;
    }

    @Override
    public Set<String> getBenefits() {
        return BENEFITS;
    }
}
