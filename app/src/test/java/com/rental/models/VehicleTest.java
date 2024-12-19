// src/test/java/com/rental/models/VehicleTest.java
package com.rental.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    void testVehicleCreation() {
        Car car = new Car("C001", "Toyota Camry", 50.0, "Automatic", 5);
        assertNotNull(car);
        assertEquals("C001", car.getVehicleId());
    }
}