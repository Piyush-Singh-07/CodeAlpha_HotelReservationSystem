public class Room {
    int roomNumber;
    String category;
    double price;
    boolean available;

    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    void displayRoom() {
        System.out.println(
            "Room " + roomNumber +
            " | Category: " + category +
            " | Price: $" + price +
            " | " + (available ? "Available" : "Booked")
        );
    }
}
