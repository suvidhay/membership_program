package com.firstclub.membership.repository;

import java.util.List;
import com.firstclub.membership.plan.Plan;
import com.firstclub.membership.plan.PlanCode;

public interface PlanRepository {
    void save(Plan plan);
    List<Plan> findAll();
    Plan findByCode(PlanCode code);
}
