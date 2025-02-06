package com.medicalstore.medicalstore.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.medicalstore.medicalstore.domain.model.entity.dashboard.DashboardResponse;
import com.medicalstore.medicalstore.services.MedicialstoreService;

@Controller
public class DashboardGraphQLController {

    @Autowired
    private MedicialstoreService medicialstoreService;

    @QueryMapping
    public DashboardResponse dashboard(@Argument String id) {
        return medicialstoreService.getDashboard(id)
                .map(DashboardResponse::new)
                .orElse(null);
    }
}