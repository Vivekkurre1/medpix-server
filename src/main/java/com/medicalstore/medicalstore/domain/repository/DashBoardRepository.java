package com.medicalstore.medicalstore.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalstore.medicalstore.domain.model.entity.dashboard.Dashboard;

public interface DashBoardRepository extends JpaRepository<Dashboard, String> {
}
