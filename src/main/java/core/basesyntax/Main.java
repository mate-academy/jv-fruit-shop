package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        FruitShop fruitShop = new FruitShop();
        fruitShop.createReport("src/main/resources/Report.csv",
                fruitShop.taskReader("src/main/resources/InputFile.csv"));
    }
}
