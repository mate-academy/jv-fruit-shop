package core.basesyntax.service;

import core.basesyntax.util.Injector;

public class FruitShopController {
    private static final String INPUT_FILE_PATH = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/finalReport.csv";

    private final FruitShopService fruitShopService;

    public FruitShopController() {
        this.fruitShopService = Injector.getFruitShopService();
    }

    public void run() {
        fruitShopService.processTransactions(INPUT_FILE_PATH, OUTPUT_FILE_PATH);
    }
}
