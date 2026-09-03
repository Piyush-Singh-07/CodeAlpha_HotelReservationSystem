import java.util.ArrayList;

public class Hotel {

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();

    void addRoom(Room room) {
        rooms.add(room);
    }

    void displayAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");

        boolean found = false;

        for (Room room : rooms) {
            if (room.available) {
                room.displayRoom();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No rooms available.");
        }
    }

    Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                return room;
            }
        }

        return null;
    }

    void bookRoom(Customer customer, int roomNumber, int nights) {

        Room room = findRoom(roomNumber);

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        if (!room.available) {
            System.out.println("Room is already booked.");
            return;
        }

        if (nights <= 0) {
            System.out.println("Invalid number of nights.");
            return;
        }

        int reservationId = reservations.size() + 1;

        Reservation reservation =
                new Reservation(reservationId, customer, room, nights);

        room.available = false;
        reservations.add(reservation);

        System.out.println("\nRoom booked successfully!");
        reservation.displayReservation();

        System.out.print("\nMake payment now? (yes/no): ");
        String paymentChoice =
                HotelReservationSystem.sc.next();

        if (paymentChoice.equalsIgnoreCase("yes")) {
            reservation.makePayment();
            System.out.println("Payment successful!");
        } else {
            System.out.println("Payment pending.");
        }
    }

    void cancelReservation(int reservationId) {

        for (Reservation reservation : reservations) {

            if (reservation.reservationId == reservationId) {

                if (reservation.room.available) {
                    System.out.println("Reservation already cancelled.");
                    return;
                }

                reservation.room.available = true;
                reservations.remove(reservation);

                System.out.println("Reservation cancelled successfully!");
                return;
            }
        }

        System.out.println("Reservation not found.");
    }

    void displayReservations() {

        System.out.println("\n--- All Reservations ---");

        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }

        for (Reservation reservation : reservations) {
            reservation.displayReservation();
        }
    }
}