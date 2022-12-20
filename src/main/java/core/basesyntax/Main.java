package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoCsvImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Shop;
import core.basesyntax.service.ShopFruits;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import java.util.List;

public class Main {
    private static final String FROM_FILE_NAME = "fromFruits.csv";
    private static final FruitsDao FRUITS_DAO = new FruitsDaoCsvImpl();
    private static final Shop<FruitTransaction> SHOP = new ShopFruits();
    private static ShopService shopService;

    public static void main(String[] args) {
        List<FruitTransaction> fruitTransactions = FRUITS_DAO.readDataFromFruitsCsv(FROM_FILE_NAME);
        SHOP.processTransactions(fruitTransactions);
        shopService = new ShopServiceImpl(SHOP, FRUITS_DAO);
        FRUITS_DAO.writeReportToCsvFile(SHOP.getReportData());
    }
}
