import java.util.Scanner;

public class HotelReservationSystem {

    static Scanner sc = new Scanner(System.in);
    static Hotel hotel = new Hotel();

    public static void main(String[] args) {

        // Add hotel rooms
        hotel.addRoom(new Room(101, "Standard", 100));
        hotel.addRoom(new Room(102, "Standard", 100));
        hotel.addRoom(new Room(201, "Deluxe", 150));
        hotel.addRoom(new Room(202, "Deluxe", 150));
        hotel.addRoom(new Room(301, "Suite", 250));

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View All Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    hotel.displayAvailableRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    hotel.displayReservations();
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using Hotel Reservation System!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }

    static void bookRoom() {

        sc.nextLine();

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        Customer customer = new Customer(name, phone);

        System.out.print("Enter room number: ");
        int roomNumber = sc.nextInt();

        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();

        hotel.bookRoom(customer, roomNumber, nights);
    }

    static void cancelReservation() {

        System.out.print("Enter reservation ID: ");
        int reservationId = sc.nextInt();

        hotel.cancelReservation(reservationId);
    }
}
