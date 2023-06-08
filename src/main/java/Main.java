import fruit.shop.FruitShopServeImpl;
import fruit.shop.ShopServe;
import java.io.IOException;

public class Main {
    private static final String EXAMPLE_PATH_FROM = "src/main/resources/test1";
    private static final String EXAMPLE_PATH_TO = "src/main/resources/test2";

    public static void main(String[] args) throws IOException {
        ShopServe fruitShop = new FruitShopServeImpl();
        fruitShop.serveShop(EXAMPLE_PATH_FROM, EXAMPLE_PATH_TO);
    }
}
