package OnlineMarket;

import java.util.ArrayList;
import java.util.List;

public abstract class GenId {
    public static final int EMOLOYEE = 1;
    public static final int CUSTOMERS = 2;
    public static final int GOODSID = 3;
    public static final int FOOD = 4;
    public static final int BALANSE = 5;

    private static final List<Integer> employeesId = new ArrayList<>();
    private static final List<Integer> customers = new ArrayList<>();
    private static final List<Integer> goodsId = new ArrayList<>();
    private static final List<Integer> foodId = new ArrayList<>();
    private static final List<Integer> balanceNumbers = new ArrayList<>();

    public static int genUniqId(int param) {
        int id = (int) (Math.random() * 899) + 100;
        switch (param) {
            case EMOLOYEE:
                if (isHas(id, employeesId)) genUniqId(param);
                employeesId.add(id);
            case CUSTOMERS:
                if (isHas(id, customers)) genUniqId(param);
                customers.add(id);
            case GOODSID:
                if (isHas(id, goodsId)) genUniqId(param);
                goodsId.add(id);
            case FOOD:
                if (isHas(id, foodId)) genUniqId(param);
                foodId.add(id);
            case BALANSE:
                if (isHas(id, balanceNumbers)) genUniqId(param);
                balanceNumbers.add(id);
        }
        return id;
    }

    private static boolean isHas(int id, List<Integer> list) {
        for (int num : list) {
            if (num == id) {
                return true;
            }
        }
        return false;
    }
}
