// RentalAgency.java
public class RentalAgency {
    private final String agencyName;
    private final List<Vehicle> fleet;
    private final List<Customer> customers;
    private final List<RentalTransaction> transactions;

    public RentalAgency(String agencyName) {
        this.agencyName = agencyName;
        this.fleet = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public RentalTransaction rentVehicle(Customer customer, Vehicle vehicle, int days) 
            throws RentalException {
        if (!vehicle.isAvailableForRental()) {
            throw new RentalException("Vehicle is not available for rental");
        }

        double totalCost = vehicle.calculateRentalCost(days);
        String transactionId = generateTransactionId();
        
        vehicle.rent(customer, days);
        
        RentalTransaction transaction = new RentalTransaction(
            transactionId, customer, vehicle, days, totalCost
        );
        
        transactions.add(transaction);
        customer.addRentalTransaction(transaction);
        
        return transaction;
    }

    public void returnVehicle(RentalTransaction transaction) throws RentalException {
        Vehicle vehicle = transaction.getVehicle();
        vehicle.returnVehicle();
        transaction.completeReturn();
    }

    private String generateTransactionId() {
        return "TR" + System.currentTimeMillis();
    }

    // Fleet management methods
    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        fleet.remove(vehicle);
    }

    // Customer management methods
    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    // Reporting methods
    public List<RentalTransaction> getTransactionHistory() {
        return Collections.unmodifiableList(transactions);
    }

    public List<Vehicle> getAvailableVehicles() {
        return fleet.stream()
                   .filter(Vehicle::isAvailableForRental)
                   .collect(Collectors.toList());
    }
}

