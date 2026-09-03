public class Customer {
    String name;
    String phone;

    Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    void displayCustomer() {
        System.out.println("Customer Name: " + name);
        System.out.println("Phone Number: " + phone);
    }
}
