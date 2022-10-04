package OnlineMarket.All_Menu_Metods;

import static OnlineMarket.Menu.*;

public class Exit {
    public static void exit() {
        System.out.println("-_-_-_-_-_-_-_-_-ВЫ ТОЧНО ХОТИТЕ ВЫЙТИ?-_-_-_-_-_-_-_-_-");
        System.out.println(" ========= 1 - ДА ");
        System.out.println(" ========= 2 - НЕТ ");
        int userChoice = scanner.nextInt();
        if (userChoice >= 1 && userChoice <= 2) {
            switch (userChoice) {
                case 1 -> {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("*******************-|_ВКУС-МУС_|-***********************");
                    System.out.println("*************- ОНЛАЙН ДОСТАВКА НА ДОМ -*****************");
                    System.out.println("--------------------------------------------------------");
                    System.out.println("************ НАДЕЕМСЯ УВИДЕТЬ ВАС СНОВА! ***************");
                    System.exit(0);
                }
                case 2 ->
                    mainMenu();
            }
        } else {
            System.err.println("------Введите корректное число!-------");
            exit();
        }
    } public static void exitSingMenu() {
        System.out.println("-_-_-_-_-_-_-_-_-ВЫ ТОЧНО ХОТИТЕ ВЫЙТИ?-_-_-_-_-_-_-_-_-");
        System.out.println(" ========= 1 - ДА ");
        System.out.println(" ========= 2 - НЕТ ");
        int userChoice = scanner.nextInt();
        if (userChoice >= 1 && userChoice <= 2) {
            switch (userChoice) {
                case 1 -> {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("*******************-|_ВКУС-МУС_|-***********************");
                    System.out.println("*************- ОНЛАЙН ДОСТАВКА НА ДОМ -*****************");
                    System.out.println("--------------------------------------------------------");
                    System.out.println("************ НАДЕЕМСЯ УВИДЕТЬ ВАС СНОВА! ***************");
                    System.exit(0);
                }
                case 2 ->
                    singInMenu();
            }
        } else {
            System.err.println("------Введите корректное число!-------");
            exit();
        }
    }

}

