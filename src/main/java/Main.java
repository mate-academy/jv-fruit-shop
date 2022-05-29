import servise.FruitService;
import servise.FruitServiceImpl;

public class Main {
    public static void main(String[] args) {
        FruitService fruitService = new FruitServiceImpl();
        fruitService.createReport("DB.csv");
    }
}
