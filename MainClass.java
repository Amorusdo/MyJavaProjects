package OnlineMarket;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        Employee employee = new Employee(
                "Adilet", 26, "Osh", "Curer",2600);
        Employee employee1 = new Employee(
                "Baha", 20, "Osh", "Curer",5600);
        Customer customer = new Customer(
                "Ruslan", 30, "Osh", "rus", "123");
        Customer customer1 = new Customer(
                "Adilet", 22, "Osh", "adilet", "123456");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer1);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        Market market = new Market(customers, employees);
        Menu.start(market);


    }
}
