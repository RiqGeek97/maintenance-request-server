package com.MMLP1.Maintenancerequestserver.maintenanceRequest.services;

import com.MMLP1.Maintenancerequestserver.domain.core.exception.ResourceCreationException;
import com.MMLP1.Maintenancerequestserver.domain.core.exception.ResourceNotFoundException;
import com.MMLP1.Maintenancerequestserver.maintenanceRequest.models.MaintenanceRequest;

import java.util.List;

public interface MaintenanceRequestService {
    MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException;
    MaintenanceRequest getById(Long id) throws ResourceNotFoundException;
    MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException;
    List<MaintenanceRequest> getAll();
    MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
