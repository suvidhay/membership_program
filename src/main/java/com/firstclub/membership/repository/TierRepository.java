package com.firstclub.membership.repository;

import java.util.List;
import com.firstclub.membership.tier.Tier;
import com.firstclub.membership.tier.TierCode;

public interface TierRepository {
    void save(Tier tier);
    List<Tier> findAll();
    Tier findByCode(TierCode code);
}
