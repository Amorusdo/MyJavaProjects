package OnlineMarket;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Human {
    private int balance;
    private String login;
    private String password;
    private List<Order> orderHistory;
    private List<Food> orderCard;
    private int balanceNumber;

    public Customer(String name, int age, String address, String login, String password) {
        super(GenId.genUniqId(GenId.CUSTOMERS), name, age, address);
        this.login = login;
        this.password = password;
        this.orderCard = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
        this.balanceNumber = GenId.genUniqId(GenId.BALANSE);
        this.balance = 5000;
    }

    public void makeOrder(Market market) {
        Order order = new Order(this.orderCard);
        Employee employee = market.addOrderToEmployee(order);
        order.setEmployee(employee);
        if (isEnoughBalance(order)) {
            this.orderHistory.add(order);
            this.orderCard.clear();
            System.out.println("Успешно заказано");
            order.getOrderInfo();
        } else System.out.println("На вашем счету недостаточно средств!\nПополните баланс.");
    }

    public  void topAppTheBalance( int transSum) {
        this.balance += transSum;
    }


    public void transferMoney(Customer customer, int transferSum) {
        this.balance -= transferSum;
        customer.topAppTheBalance(transferSum);
    }

    private boolean isEnoughBalance(Order order) {
        if (order.getFinalPrice() <= this.balance) {
            this.balance -= order.getFinalPrice();
            return true;
        }
        return false;
    }

    private boolean isHas(int foodId) {
        for (Food food : this.orderCard) {
            if (food.getFoodId() == foodId) {
                return true;
            }
        }
        return false;
    }

    public void deleteFood(int foodId) {
        if (isHas(foodId)) {
            for (int i = 0; i < this.orderCard.size() ; i++) {
                if (this.orderCard.get(i).getFoodId() == foodId) {
                    this.orderCard.remove(this.orderCard.get(i));
                    System.out.println("---------ПРОДУКТ " + foodId + " БЫЛ УДАЛЕН!-----------");
                   }
            }
        } else {
            System.err.println("-------------НЕВЕРНЫЙ ID---------------");
        }
    }

    public void lookOderCardHistory() {
        if (!this.orderHistory.isEmpty()) {
            System.out.println("---------------------------------------");
            for (Order o : orderHistory) {
                System.out.println("--------------------------------------------------------");
                System.out.println("*******************-|_ВКУС-МУСC_|-**********************");
                System.out.println("--------------------------------------------------------");
                System.out.println(" ЗАКАЗ: #" + o.getOrderId());
            }
            System.out.println("---------------------------------------------------------");
        } else {
            System.out.println("------------ У ВАС НЕ БЫЛО СОВЕРШЕННЫХ ЗАКАЗОВ -----------");
        }
    }

    public void getCustomerInfo() {
        System.out.println("--------------------------------------------------------");
        System.out.println("*******************-|_ВКУС-МУСC_|-**********************");
        System.out.println("--------------------------------------------------------");
        System.out.println("-----------------  * МОЙ ПРОФИЛЬ *  -------------------");
        System.out.println(" === Имя заказчика: " + this.getName());
        System.out.println(" === Номер счета: " + this.getBalanceNumber());
        System.out.println(" === Возраст заказчика: " + this.getAge());
        System.out.println(" === Адрес заказчика: " + this.getAddress());
        System.out.println(" === Баланс заказчика: " + this.getBalance());
        System.out.println(" === Id заказчика: " + this.getId());
        System.out.println(" === Логин заказчика: " + this.getLogin());
        System.out.println(" === Пароль заказчика: " + this.getPassword());
    }


    private Order isHasOrder(int orderId) {
        for (Order o : this.orderHistory) {
            if (o.getOrderId() == orderId) {
                return o;
            }
        }
        return null;
    }

    public void orderDetails(int orderId) {
        Order order = isHasOrder(orderId);
        if (order != null) {
            order.getOrderInfo();
        } else {
            System.out.println("---------------- НЕВЕРНЫЙ ID ----------------");
        }
    }

    public void getCardInfo() {
        if (!this.orderCard.isEmpty()) {
            System.out.println("--------------------------------------------------------");
            System.out.println("*******************-|_ВКУС-МУСC_|-**********************");
            System.out.println("--------------------------------------------------------");
            System.out.println("----------------- * ВАША КОРЗИНА * ---------------------");
            for (Food f : orderCard) {
                f.foodInfo();
                System.out.println("  ==== | ИТОГО: " + f.getTotalPrice());
                System.out.println("----------------------------------------------------");
            }

        } else {
            System.out.println("--------------------------------------------------------------");
            System.out.println("----------------- * ВАША КОРЗИНА ПУСТА * ---------------------");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public int getBalanceNumber() {
        return balanceNumber;
    }

    public void setBalanceNumber(int balanceNumber) {
        this.balanceNumber = balanceNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public List<Food> getOrderCard() {
        return orderCard;
    }

    public void getOrderCard(List<Food> orderCard) {
        this.orderCard = orderCard;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setOrderCard(List<Food> orderCard) {
        this.orderCard = orderCard;
    }
}