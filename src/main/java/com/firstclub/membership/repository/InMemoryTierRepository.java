package com.firstclub.membership.repository;

import java.util.*;
import com.firstclub.membership.tier.Tier;
import com.firstclub.membership.tier.TierCode;

public class InMemoryTierRepository implements TierRepository {

    private final Map<TierCode, Tier> store = new HashMap<>();

    public void save(Tier tier) { store.put(tier.getCode(), tier); }
    public List<Tier> findAll() { return List.copyOf(store.values()); }
    public Tier findByCode(TierCode code) { return store.get(code); }
}
