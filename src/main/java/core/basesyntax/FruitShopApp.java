package core.basesyntax;

import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import java.io.File;

public class FruitShopApp {
    private static final String FILE_SEPARATOR = File.separator;
    private static final String RESOURCES_PATH = "src" + FILE_SEPARATOR
            + "main" + FILE_SEPARATOR
            + "resources" + FILE_SEPARATOR;
    private static final String CSV_PATH = RESOURCES_PATH + "CSV.csv";
    private static final String WRONG_CSV_PATH = RESOURCES_PATH + "WRONG_CSV.csv";
    private static final String WRONG_VALUE_CSV_PATH = RESOURCES_PATH + "WRONG_VALUE_CSV.csv";

    public static void main(String[] args) {
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        System.out.println(fruitShopService.getReport(CSV_PATH));
        System.out.println(fruitShopService.getReport(WRONG_CSV_PATH));
        System.out.println(fruitShopService.getReport(WRONG_VALUE_CSV_PATH));
    }
}
