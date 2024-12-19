// Rentable.java
public interface Rentable {
    boolean rent(Customer customer, int days) throws RentalException;
    boolean returnVehicle() throws RentalException;
}