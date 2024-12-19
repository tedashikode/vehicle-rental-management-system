// RentalTransaction.java
public class RentalTransaction {
    private final String transactionId;
    private final Customer customer;
    private final Vehicle vehicle;
    private final LocalDateTime rentalDate;
    private final int days;
    private final double totalCost;
    private LocalDateTime returnDate;

    public RentalTransaction(String transactionId, Customer customer, 
                           Vehicle vehicle, int days, double totalCost) {
        this.transactionId = transactionId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDate = LocalDateTime.now();
        this.days = days;
        this.totalCost = totalCost;
    }

    public void completeReturn() {
        this.returnDate = LocalDateTime.now();
    }

    // Getters (no setters as this is an immutable record of a transaction)
    public String getTransactionId() {
        return transactionId;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
