import fruitstore.FruitShopServeImpl;
import fruitstore.ShopServe;

import java.io.IOException;

public class Main {
    private static final String FROM_THIS_FILE = "input.csv";
    private static final String TO_THIS_FILE = "report.csv";

    public static void main(String[] args) throws IOException {
        String fileFrom = FROM_THIS_FILE;
        String fileTo = TO_THIS_FILE;
        ShopServe fruitShop = new FruitShopServeImpl();
        fruitShop.serveShop(fileFrom, fileTo);
    }
}
