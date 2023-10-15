package com.MMLP1.Maintenancerequestserver.maintenanceRequest.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaintenanceRequestTest {
    @Test
    public void constructorTest(){
        MaintenanceRequest maintenanceRequest = new MaintenanceRequest("Demo", "User", "demo@user.com", "1A", "House", 2023/11/10);
        maintenanceRequest.setId(1l);

        String expected = "1 Demo User demo@user.com 1A House 2023-11-10";
        String actual = maintenanceRequest.toString();

        Assertions.assertEquals(expected, actual);
    }
}
