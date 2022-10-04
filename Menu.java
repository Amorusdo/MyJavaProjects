package OnlineMarket;

import OnlineMarket.All_List_Of_Menu.All_Menu;
import OnlineMarket.All_List_Of_Menu.Info_About_Online_Store;
import OnlineMarket.All_Menu_Metods.Exit;
import OnlineMarket.All_Menu_Metods.Info_Store;
import OnlineMarket.All_Menu_Metods.SingIn;
import OnlineMarket.All_Menu_Metods.SingIn_Food_Menu;

import java.util.List;
import java.util.Scanner;


public abstract class Menu {

    private static List<Customer> customers;
    private static List<Employee> employees;
    public static Market market;
    public static final Scanner scanner = new Scanner(System.in);
    public static Customer loggedInCustomer;

    public static void start(Market m) {
        customers = m.getCustomers();
        employees = m.getEmployees();
        market = m;
        mainMenu();
    }

    public static void mainMenu() {
        All_Menu.mainMenu();
        int userChoice = scanner.nextInt();
        if (userChoice >= 1 && userChoice <= 5) {
            switch (userChoice) {
                case 1: {
                    menuWithoutRegistration();
                }
                case 2: {
                    SingIn.singIn();
                }
                case 3: {
                    logIn();
                }
                case 4: {
                    Exit.exit();
                }
                case 5: {
                    Info_About_Online_Store.info_Store();
                    Info_Store.infoStore();
                }
            }
        } else {
            System.err.println("------Введите корректное число!-------");
            mainMenu();
        }
    }

    private static void logIn() {
        System.out.println("_____________________ВВЕДИТЕ ЛОГИН______________________");
        String login = scanner.next();
        System.out.println("_____________________ВВЕДИТЕ ПАРОЛЬ_____________________");
        String password = scanner.next();
        if (market.checkCustomer(login, password) != null) {
            loggedInCustomer = market.checkCustomer(login, password);
            singInMenu();
        } else
            System.err.println("------Такого логина или пароля не существует!------ \n " + "------Проверьте правильность данных!------  ");
        mainMenu();
    }

    public static void singInMenu() {
        All_Menu.singIngMenu();
        int userChoice = scanner.nextInt();
        if (userChoice >= 1 && userChoice <= 11) {
            switch (userChoice) {
                case 1: {
                    SingIn_Food_Menu.singInFoodMenu();
                }
                case 2: {
                    loggedInCustomer.getCardInfo();
                    singInMenu();
                }
                case 3: {
                    makeOrder();
                }
                case 4: {
                    loggedInCustomer.lookOderCardHistory();
                    singInMenu();
                }
                case 5: {
                    oderDetails();
                }
                case 6: {
                    openBalanceMenu();
                }
                case 7: {
                    loggedInCustomer.getCustomerInfo();
                    settingsCustomer();
                }
                case 8: {
                    registration();
                }
                case 9: {
                    settingsCustomer();
                }
                case 10: {
                    mainMenu();
                }
                case 11: {
                    Exit.exitSingMenu();
                }
            }
        } else {
            System.err.println("--------Введите корректное число!---------");
            singInMenu();
        }
    }

    private static void oderDetails() {
        System.out.println("-----------Введите Id заказа:");
        System.out.println("-----------Введите 0 чтобы вернуться назад-----------");
        int userChoice = scanner.nextInt();
        if (userChoice == 0) {
            singInMenu();
        } else {
            loggedInCustomer.orderDetails(userChoice);
        }

    }

    private static void settingsCustomer() {
        All_Menu.settingsCustomer();
        int userChoice = scanner.nextInt();
        if (userChoice >= 1 && userChoice <= 10) {
            switch (userChoice) {
                case 1: {
                    changeName();
                    settingsCustomer();
                }
                case 2: {
                    changeAge();
                    settingsCustomer();
                }
                case 3: {
                    changeAddres();
                    settingsCustomer();
                }
                case 4: {
                    changeLogin();
                    settingsCustomer();
                }
                case 5: {
                    changePassword();
                    settingsCustomer();
                }
                case 6: {
                    singInMenu();
                }
            }
        } else {
            System.err.println("--------Введите корректное число!---------");
            settingsCustomer();
        }
    }

    private static void changeName() {
        System.out.println(" Введите новое имя:");
        String name = scanner.next();
        if (name != null) {
            loggedInCustomer.changeNameS(name);
            System.out.println("------------ Вы изменили имя -------------");
        } else System.out.println("----------Введите корректное имя-----------------");
    }

    private static void changeAge() {
        System.out.println(" Введите ваш возраст:");
        int age = scanner.nextInt();
        if (age <= 1) {
            loggedInCustomer.changeAgeCustomer(age);
            System.out.println("------------ Возврат изменен -------------");
        } else System.out.println("----------Введите корректное имя-----------------");

    }

    private static void changeAddres() {
        System.out.println(" Введите новый адрес:");
        String adress = scanner.next();
        if (adress != null) {
            loggedInCustomer.changeAdress(adress);
            System.out.println("------------ Возврат изменен -------------");
        } else System.out.println("----------Введите корректное имя-----------------");

    }


    private static void changeLogin() {

    }

    private static void changePassword() {

    }

    private static void makeOrder() {
        if (!loggedInCustomer.getOrderCard().isEmpty()) {
            loggedInCustomer.getCardInfo();
            loggedInCustomer.makeOrder(market);

        } else {
            System.out.println("-------- У вас нет заказов ---------\n");
        }
        singInMenu();
    }

    private static void openBalanceMenu() {
        All_Menu.openBalanceMenu();
        int userChose = scanner.nextInt();
        switch (userChose) {
            case 1:
                System.out.println("---------------------------------------------------------");
                System.out.println("*******************-|_ВКУС-МУСC_|-***********************");
                System.out.println("---------------------------------------------------------");
                System.out.println("******* На вашем счету : " + loggedInCustomer.getBalance() + "сом  *******");
                checkBalance();

            case 2:
                System.out.println(loggedInCustomer.getBalanceNumber());
                openBalanceMenu();

            case 3:
                topAppTheBalance();

            case 4:
                transferMoney();


            case 5:
                singInMenu();


            case 6: {
                mainMenu();
            }
        }
    }

    private static void transferMoney() {
        System.out.println("Введите номер счета куда хотите перевести:");
        System.out.println("0: назад");
        int balanceNumber = scanner.nextInt();
        int index = isHasCustomer(balanceNumber);
        if (balanceNumber == 0) {
            openBalanceMenu();
        } else {
            if (index >= 0) {
                System.out.println("Введите сумму которую вы хотите перевести");
                int transferSum = scanner.nextInt();
                if (transferSum > 0) {
                    loggedInCustomer.transferMoney(customers.get(index), transferSum);
                } else {
                    System.out.println("Переводимая сумма должна быть больше 0");
                    transferMoney();
                }
            } else {
                System.err.println("неправильный номер счета");
                transferMoney();
            }
        }
    }

    private static int isHasCustomer(int balanceNum) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getBalanceNumber() == balanceNum) {
                return i;
            }
        }
        return -1;
    }

    private static void checkBalance() {
        All_Menu.checkBalanceMenu();
        int userChoice = scanner.nextInt();
        if (userChoice >= 1 && userChoice <= 3) {
            switch (userChoice) {
                case 1: {
                    topAppTheBalance();
                }
                case 2: {
                    singInMenu();
                }
                case 3: {
                    openBalanceMenu();
                }
            }
        }
    }

    private static void addFoodMenu() {
        System.out.println("--------------------------------------------------------------------");
        All_Menu.addFoodMenu();
        int userChoice = scanner.nextInt();
        if (userChoice >= 1 && userChoice <= 6) {
            switch (userChoice) {
                case 1: {
                    SingIn_Food_Menu.singInFoodMenu();
                }
                case 2: {
                    makeOrder();
                }
                case 3: {
                    loggedInCustomer.getCardInfo();
                    deleteFood_menu();
                }
                case 4: {
                    singInMenu();
                }
                case 5: {
                    Exit.exit();
                }
            }
        } else {
            System.err.println("Введите корректное число!");
            addFoodMenu();
        }
    }

    public static void addToCard(Food food) {
        loggedInCustomer.getOrderCard().add(food);
        addFoodMenu();
    }

    private static void deleteFood_menu() {
        System.out.println("1.Назад");
        System.out.println("2.Удалить заказ");
        int userChoice = scanner.nextInt();
        if (userChoice >= 1 && userChoice <= 6) {
            switch (userChoice) {
                case 1: {
                    addFoodMenu();
                }
                case 2: {
                    deleteFood();
                    deleteFood_menu();
                }
            }
        } else {
            System.err.println("Введите корректное число!");
            deleteFood_menu();
        }
    }

    private static void deleteFood() {
        System.out.println("0.Назад");
        System.out.println("Введите Id заказа который хотите удалить: ");
        int userChoice = scanner.nextInt();
        if (userChoice == 0) {
            deleteFood_menu();

        } else {
            loggedInCustomer.deleteFood(userChoice);
            loggedInCustomer.getCardInfo();
            deleteFood_menu();
        }
    }

    private static void topAppTheBalance() {
        System.out.println("Введите сумму: ");
        System.out.println("0: Назад");
        int num = scanner.nextInt();
        System.out.println("Пополнить?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        int userChoice = scanner.nextInt();
        if (userChoice >= 1 && userChoice <= 2) {
            switch (userChoice) {
                case 1:
                    if (num > 0) {
                        loggedInCustomer.topAppTheBalance(num);
                        System.out.println("-------------------------------------------------------");
                        System.out.println("------------ Ваш баланс успешно пополнен! -------------");
                        System.out.println("-------------------------------------------------------");
                        openBalanceMenu();
                    } else {
                        System.out.println("============== Введите корректную сумму ================");
                        topAppTheBalance();
                    }
                case 2: {
                    openBalanceMenu();
                }
            }
        }
    }

    private static void registration() {
        All_Menu.registration();
        int userChoice = scanner.nextInt();
        if (userChoice >= 0 && userChoice <= 3) {
            switch (userChoice) {
                case 1:
                    SingIn.singIn();
                case 2:
                    logIn();
                case 3:
                    mainMenu();
            }
        }
    }

    private static void menuWithoutRegistration() {
        All_Menu.menu();
        System.out.println("------------------------------------------");
        System.out.println("Чтобы сделать заказ пройдите регистрацию!");
        registration();
    }

}
