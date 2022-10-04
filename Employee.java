package OnlineMarket;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Human {
    private String position;
    private int salary;
    private List<Order> ordersList;

    public Employee(String name, int age, String address, String position, int salary) {
        super(GenId.genUniqId(GenId.EMOLOYEE), name, age, address);
        this.position = position;
        this.salary = salary;
        this.ordersList = new ArrayList<>();
    }

    public void getEmployeeInfo() {
        System.out.println("------------------ * СОТРУДНИК * ----------------------------");
        System.out.println(" === Должность: " + this.getPosition());
        System.out.println(" === Имя : " + this.getName());
        System.out.println(" === Возраст: " + this.getAge());
    }

    public void addOrder(Order order){
        this.ordersList.add(order);

    }
    public List<Order> getOrderList(){
        return ordersList;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }


}


