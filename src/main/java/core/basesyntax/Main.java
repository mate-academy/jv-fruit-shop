package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.ShopOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.model.Apple;
import core.basesyntax.model.Banana;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvReaderService;
import core.basesyntax.service.CsvWriterService;
import core.basesyntax.service.DataProcessorService;
import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.FruitShopDataProcessorService;
import core.basesyntax.strategy.ShopOperationStrategy;
import core.basesyntax.strategy.ShopOperationStrategyImpl;
import core.basesyntax.utility.FruitQuantityChecker;
import core.basesyntax.utility.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_CSV = "src/main/resources/input.csv";
    public static final String REPORT_CSV = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, ShopOperationHandler> shopOperationHandlerMap = new HashMap<>();
        shopOperationHandlerMap.put(Operation.BALANCE,
                new BalanceOperationHandler());
        shopOperationHandlerMap.put(Operation.RETURN,
                new ReturnOperationHandler());
        shopOperationHandlerMap.put(Operation.SUPPLY,
                new SupplyOperationHandler());
        shopOperationHandlerMap.put(Operation.PURCHASE,
                new PurchaseOperationHandler());

        Storage.FRUIT_STORAGE.put("banana", new Banana());
        Storage.FRUIT_STORAGE.put("apple", new Apple());

        DataReaderService dataReaderService = new CsvReaderService(INPUT_CSV);
        List<String> strings = dataReaderService.readData();

        ShopOperationStrategy operationStrategy =
                new ShopOperationStrategyImpl(shopOperationHandlerMap);
        DataProcessorService dataProcessorService =
                new FruitShopDataProcessorService(operationStrategy, Storage.FRUIT_STORAGE);
        dataProcessorService.processData(strings);

        new FruitQuantityChecker().checkFruitQuantity(Storage.FRUIT_STORAGE);

        DataWriterService csvWriter = new CsvWriterService(Storage.FRUIT_STORAGE, REPORT_CSV);
        csvWriter.writeData();
    }
}
