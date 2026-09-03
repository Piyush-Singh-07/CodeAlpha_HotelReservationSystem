public class Reservation {
    int reservationId;
    Customer customer;
    Room room;
    int nights;
    double totalAmount;
    boolean paid;

    Reservation(int reservationId, Customer customer, Room room, int nights) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.nights = nights;
        this.totalAmount = room.price * nights;
        this.paid = false;
    }

    void makePayment() {
        paid = true;
    }

    void displayReservation() {
        System.out.println("\n--- Booking Details ---");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Customer: " + customer.name);
        System.out.println("Phone: " + customer.phone);
        System.out.println("Room Number: " + room.roomNumber);
        System.out.println("Category: " + room.category);
        System.out.println("Nights: " + nights);
        System.out.println("Total Amount: $" + totalAmount);
        System.out.println("Payment: " + (paid ? "Paid" : "Pending"));
    }
}
