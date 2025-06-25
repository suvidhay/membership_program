package com.firstclub.membership.tier;

import java.util.Set;

public final class GoldTier implements Tier {

    private static final Set<String> BENEFITS = Set.of("FREE_SHIP", "EXTRA_5_PERCENT");

    @Override
    public TierCode getCode() {
        return TierCode.GOLD;
    }

    @Override
    public Set<String> getBenefits() {
        return BENEFITS;
    }
}
