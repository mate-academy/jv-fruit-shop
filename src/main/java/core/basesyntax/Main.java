package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        FruitShop fruitShop = new FruitShop("src/test/resources/file.csv");
        fruitShop.start();
    }
}
