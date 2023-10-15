package com.MMLP1.Maintenancerequestserver.maintenanceRequest.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class MaintenanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String aptNumber;
    @NonNull
    private String description;
    @NonNull
    private Date createdAt;

    public String toString(){
        return String.format("%d %s %s %s %s %s %s" ,id, firstName,lastName,email,aptNumber,description,createdAt);
    }
}
