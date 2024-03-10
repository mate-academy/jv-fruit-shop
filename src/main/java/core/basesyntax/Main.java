package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        FruitShopService fruitShopService = new FruitShopService();
        fruitShopService
                .findRestOfFruitsInTheShop("FileWithInputData.csv", "FileWithRestOfFruits.csv");
    }
}
