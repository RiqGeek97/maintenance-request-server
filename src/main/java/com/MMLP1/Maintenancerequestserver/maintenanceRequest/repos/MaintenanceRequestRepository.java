package com.MMLP1.Maintenancerequestserver.maintenanceRequest.repos;

import com.MMLP1.Maintenancerequestserver.maintenanceRequest.models.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {
    Optional<MaintenanceRequest> findByEmail(String email);
}
