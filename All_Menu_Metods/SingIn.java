package OnlineMarket.All_Menu_Metods;

import OnlineMarket.Customer;

import static OnlineMarket.Menu.*;

public class SingIn {
    public static void singIn() {
        System.out.println(" Придумайте логин: ");
        String login = scanner.next();
        if (!market.isHasDuplicate(login)) {
            System.out.println("Введите свое имя: ");
            String name = scanner.next();
            System.out.println("Возраст: ");
            int age = scanner.nextInt();
            System.out.println("Введите ваш адрес: ");
            String address = scanner.next();
            System.out.println("Придумайте пароль: ");
            String password = scanner.next();
            loggedInCustomer = new Customer(name, age, address, login, password);
            market.addCustomer(loggedInCustomer);
            System.out.println("*********************************************");
            System.out.println("**               Поздравляем!              **");
            System.out.println("**        Регистрация прошла успешно!      **");
            System.out.println("*********************************************");
            singInMenu();
        } else {
            System.err.println("Пользователь с таким логином уже существует. \n Придумайте новый");
            singIn();
        }
    }
}
