package com.firstclub.membership.repository;

import java.util.*;
import com.firstclub.membership.plan.Plan;
import com.firstclub.membership.plan.PlanCode;

public class InMemoryPlanRepository implements PlanRepository {

    private final Map<PlanCode, Plan> store = new HashMap<>();

    public void save(Plan plan) { store.put(plan.getCode(), plan); }
    public List<Plan> findAll() { return List.copyOf(store.values()); }
    public Plan findByCode(PlanCode code) { return store.get(code); }
}
