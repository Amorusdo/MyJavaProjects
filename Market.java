package OnlineMarket;

import java.util.List;

public class Market {
    private List<Customer> customers;
    private List<Employee> employees;


    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public Market(List<Customer> customers, List<Employee> employees) {
        this.customers = customers;
        this.employees = employees;
    }
    public boolean isHasDuplicate(String login) {
        for (Customer customers :this.getCustomers()) {
            if (customers.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
    public Customer checkCustomer(String login, String password) {
        for (Customer customer : this.getCustomers()) {
            if (customer.getLogin().equals(login) &&
                    customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    public Employee addOrderToEmployee(Order order) {
        int ordersSize = this.employees.get(0).getOrdersList().size();
        int index = 0;
        for (int i = 0; i < this.employees.size(); ++i) {
            if (this.employees.get(i).getOrdersList().size() <= ordersSize) {
                ordersSize = this.employees.get(i).getOrdersList().size();
                index =i;
            }
        }
        this.employees.get(index).addOrder(order);
        return this.employees.get(index);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
