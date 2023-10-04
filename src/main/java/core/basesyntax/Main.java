package core.basesyntax;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FruitShopApplication fruitShopApplication = new FruitShopApplication();
        fruitShopApplication.run(PATH_TO_INPUT_FILE, PATH_TO_OUTPUT_FILE);
    }
}
