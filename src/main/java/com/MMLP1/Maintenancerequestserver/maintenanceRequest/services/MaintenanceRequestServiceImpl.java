package com.MMLP1.Maintenancerequestserver.maintenanceRequest.services;

import com.MMLP1.Maintenancerequestserver.domain.core.exception.ResourceCreationException;
import com.MMLP1.Maintenancerequestserver.domain.core.exception.ResourceNotFoundException;
import com.MMLP1.Maintenancerequestserver.maintenanceRequest.models.MaintenanceRequest;
import com.MMLP1.Maintenancerequestserver.maintenanceRequest.repos.MaintenanceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService {
    private MaintenanceRequestRepository maintenanceRequestRepository;

    @Autowired
    public void MaintenanceRequestImpl(MaintenanceRequestRepository maintenanceRequestRepository) {
        this.maintenanceRequestRepository = maintenanceRequestRepository;
    }
    @Override
    public MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException {
        Optional<MaintenanceRequest> optional = maintenanceRequestRepository.findByEmail(maintenanceRequest.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Employee with Email exists: " + maintenanceRequest.getEmail());
        maintenanceRequest = maintenanceRequestRepository.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Employee found with this ID: " + id));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("No Employee with email: " + email));
        return maintenanceRequest;
    }

    @Override
    public List<MaintenanceRequest> getAll() {
        return maintenanceRequestRepository.findAll();
    }

    @Override
    public MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequest.setFirstName(maintenanceRequestDetail.getFirstName());
        maintenanceRequest.setLastName(maintenanceRequestDetail.getLastName());
        maintenanceRequest.setEmail(maintenanceRequestDetail.getEmail());
        maintenanceRequest = maintenanceRequestRepository.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public void delete(Long id) {
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequestRepository.delete(maintenanceRequest);
    }
}