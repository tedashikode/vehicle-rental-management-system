// Customer.java
public class Customer {
    private final String customerId;
    private String name;
    private String licenseNumber;
    private List<RentalTransaction> rentalHistory;
    private int loyaltyPoints;

    public Customer(String customerId, String name, String licenseNumber) {
        this.customerId = customerId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rentalHistory = new ArrayList<>();
        this.loyaltyPoints = 0;
    }

    public void addRentalTransaction(RentalTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
        rentalHistory.add(transaction);
        loyaltyPoints += calculateLoyaltyPoints(transaction);
    }

    private int calculateLoyaltyPoints(RentalTransaction transaction) {
        return (int) (transaction.getTotalCost() * 0.1);  // 10% of cost as points
    }

    // Getters and setters with validation
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public List<RentalTransaction> getRentalHistory() {
        return Collections.unmodifiableList(rentalHistory);  // Return immutable list
    }
}
