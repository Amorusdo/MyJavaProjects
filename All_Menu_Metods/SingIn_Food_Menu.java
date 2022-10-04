package OnlineMarket.All_Menu_Metods;

import OnlineMarket.All_List_Of_Menu.All_Menu;
import OnlineMarket.Food;
import OnlineMarket.Food_models.*;

import static OnlineMarket.Menu.*;

public class SingIn_Food_Menu {
    private static final String BURGER = "Бургер";
    private static final String SHAURMA = "Шаурма";
    private static final String PEPERONI = "Пепперони";
    private static final String SAMSA = "Самса";
    private static final String SHASHLIC = "Шашлык";
    public static int foodCount;


    public static void singInFoodMenu() {
        All_Menu.menu();
        System.out.println("           | 0 - Назад в главное меню ");

        System.out.println("\n________________ ДОБАВИТЬ В КОРЗИНУ _________________ ");
        int userChoice = scanner.nextInt();
        if (userChoice >= 0 && userChoice <= 5) {
            switch (userChoice) {
                case 1: {
                    collectOrder(BURGER);
                }
                case 2:
                    collectOrder(SHAURMA);
                case 3:
                    collectOrder(PEPERONI);
                case 4:
                    collectOrder(SAMSA);
                case 5:
                    collectOrder(SHASHLIC);
                case 0:
                    singInMenu();
            }
        } else {
            System.err.println("------------Введите корректное число!--------------");
            singInFoodMenu();
        }
    }
    public static void collectOrder(String foodName) {
        System.out.println("________________ ВВЕДИТЕ КОЛИЧЕСТВО  __________________");
        foodCount = scanner.nextInt();
        if (foodCount > 0) {
            Food food;
            switch (foodName) {
                case BURGER: {
                    food = new Burger(foodCount);
                    addToCard(food);
                }
                case SHAURMA: {
                    food = new Shaurma(foodCount);
                    addToCard(food);
                }
                case PEPERONI: {
                    food = new Peperoni(foodCount);
                    addToCard(food);
                }
                case SAMSA: {
                    food = new Samsa(foodCount);
                    addToCard(food);
                }
                case SHASHLIC: {
                    food = new Shashlik(foodCount);
                    addToCard(food);
                }

            }
        } else {
            System.out.println("------- Введите число -------");
            collectOrder(foodName);
        }
    }
}
