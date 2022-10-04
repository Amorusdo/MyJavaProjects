package OnlineMarket.All_Menu_Metods;

import static OnlineMarket.Menu.mainMenu;
import static OnlineMarket.Menu.scanner;

public class Info_Store {
    public static void infoStore() {
        System.out.println("--------------------------------------------------------");
        System.out.println("*******************-|_ВКУС-МУСC_|-**********************");
        System.out.println("--------------------------------------------------------");
        System.out.println("------ 1. Позвонить");
        System.out.println("------ 2. Перейти на Web сайт");
        System.out.println("------ 3. Назад");
        int userChoice = scanner.nextInt();
        if (userChoice >= 1 && userChoice <= 5) {
            switch (userChoice) {
                case 1: {
                    call_a_Manager();
                }
                case 2: {
                    visitWebSite();
                }
                case 3: {
                 mainMenu();
                }
            }
        } else {
            System.err.println("----------- Введите корректное число!---------------");
            infoStore();
        }
    }

    private static void visitWebSite() {
    }

    private static void call_a_Manager() {
    }
}
