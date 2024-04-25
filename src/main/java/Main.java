import service.FruitShopService;
import service.impl.FruitShopServiceImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final FruitShopService fruitShopService = new FruitShopServiceImpl();

    public static void main(String[] args) {
        fruitShopService.processData("inputDateFile.csv",
                    "file.csv");
    }
}
