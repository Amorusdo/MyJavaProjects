package OnlineMarket;

import java.util.List;

public class Order {
    private double finalPrice;
    private int orderId;
    private int orderPrice;
    private double orderDiscount;
    private Employee employee;
    private List<Food> foodList;

    public Order( List<Food> foodList) {
        this.orderId = GenId.genUniqId(GenId.GOODSID);
        this.foodList = foodList;
        setOderPrice(this, foodList);
        setDiscount(this);
        this.finalPrice = this.orderPrice - orderDiscount;
    }

    public Order(String foodName, int foodPrice, int userChoice) {

    }
    public void getOrderInfo() {
        System.out.println("Id: " + this.orderId);
        for (Food f : this.foodList) {
            f.foodInfo();
        }
        this.employee.getEmployeeInfo();
        System.out.println();
        System.out.println("Цена заказа: " + this.orderPrice);
        System.out.println("Скидка: " + this.orderDiscount);
        System.out.println();
    }

    private static void setOderPrice(Order order, List<Food> foodList) {
        for (Food f : foodList) {
            order.orderPrice += f.getTotalPrice();

        }
    }

    private void setDiscount(Order order) {
        for (Food f : foodList) {
            if (order.orderPrice >= 1500) {
                order.orderDiscount = order.orderPrice * 0.1;
            } else order.orderDiscount = 0;
        }
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public double getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(double orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
