// Vehicle.java
public abstract class Vehicle implements Rentable {
    private final String vehicleId;  // Using final for immutability
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;
    private Customer currentRenter;
    private int condition;  // 1-10 rating

    protected Vehicle(String vehicleId, String model, double baseRentalRate) {
        if (vehicleId == null || vehicleId.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty");
        }
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be positive");
        }
        
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
        this.condition = 10;  // New vehicle starts with perfect condition
    }

    // Abstract methods
    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();
    protected abstract double getInsuranceCost();

    // Implementation of Rentable interface
    @Override
    public boolean rent(Customer customer, int days) throws RentalException {
        if (!isAvailableForRental()) {
            throw new RentalException("Vehicle is not available for rent");
        }
        if (customer == null) {
            throw new RentalException("Customer cannot be null");
        }
        if (days <= 0) {
            throw new RentalException("Rental days must be positive");
        }

        this.currentRenter = customer;
        this.isAvailable = false;
        return true;
    }

    @Override
    public boolean returnVehicle() throws RentalException {
        if (this.isAvailable) {
            throw new RentalException("Vehicle is not currently rented");
        }
        
        this.currentRenter = null;
        this.isAvailable = true;
        return true;
    }

    // Getters and setters with validation
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }
        this.model = model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be positive");
        }
        this.baseRentalRate = baseRentalRate;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        if (condition < 1 || condition > 10) {
            throw new IllegalArgumentException("Condition must be between 1 and 10");
        }
        this.condition = condition;
    }
}

