package OnlineMarket;

public class Food {
    private int foodId;
    private  String foodName;
    private  int foodPrice;
    private int count;
    private int totalPrice;

    public Food(String foodName, int foodPrice, int count) {
        this.foodId = GenId.genUniqId(GenId.FOOD);
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.count = count;
        this.totalPrice = this.foodPrice * this.count;
    }
    public void foodInfo(){
        System.out.println(" === Id продукта : "+ getFoodId());
        System.out.println(" === Наименование продукта: " + getFoodName());
        System.out.println(" === Количество: " + getCount());
        System.out.println(" === Цена: " + getFoodPrice());
        System.out.println(" === Итого: " + getTotalPrice());
    }

    public  String getFoodName() {
        return foodName;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
