package core.basesyntax;

import dao.ShopOperationsDao;
import dao.ShopOperationsDaoCsvImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        ShopOperationsDao shopOperationsDao = new ShopOperationsDaoCsvImpl("fruit-shop.csv",
                "fruit-shop-report.csv");
        shopOperationsDao.generateReport();
    }
}
