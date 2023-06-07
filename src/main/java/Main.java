import fruit.shop.FruitShopServeImpl;
import fruit.shop.ShopServe;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileFrom = "src/main/resources/test1";
        String fileTo = "src/main/resources/test2";
        ShopServe fruitShop = new FruitShopServeImpl();
        fruitShop.serveShop(fileFrom, fileTo);
    }
}
