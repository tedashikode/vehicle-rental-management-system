// Car.java
public class Car extends Vehicle {
    private String transmission;
    private int seatingCapacity;
    private boolean hasGPS;

    public Car(String vehicleId, String model, double baseRentalRate, 
               String transmission, int seatingCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.transmission = transmission;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseCost = getBaseRentalRate() * days;
        double insuranceCost = getInsuranceCost() * days;
        double gpsSurcharge = hasGPS ? 10 * days : 0;
        
        return baseCost + insuranceCost + gpsSurcharge;
    }

    @Override
    public boolean isAvailableForRental() {
        return super.getCondition() >= 7;  // Cars need to be in good condition
    }

    @Override
    protected double getInsuranceCost() {
        return 20.0;  // Daily insurance cost for cars
    }

    // Additional getters and setters
    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        if (transmission == null || transmission.trim().isEmpty()) {
            throw new IllegalArgumentException("Transmission cannot be null or empty");
        }
        this.transmission = transmission;
    }

    public boolean hasGPS() {
        return hasGPS;
    }

    public void setGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
    }
}
