package core.basesyntax;

import core.basesyntax.db.HandlerStorage;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.strategy.DecreaseBalanceOperationImpl;
import core.basesyntax.service.strategy.IncreaseBalanceOperationImpl;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.SetBalanceOperationImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> storage = new HashMap<>();
        storage.put(Operation.BALANCE, new SetBalanceOperationImpl());
        storage.put(Operation.SUPPLY, new IncreaseBalanceOperationImpl());
        storage.put(Operation.PURCHASE, new DecreaseBalanceOperationImpl());
        storage.put(Operation.RETURN, new IncreaseBalanceOperationImpl());
        HandlerStorage handlerStorage = new HandlerStorage(storage);

        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFile(INPUT_FILE);

        FruitShopService fruitShopService = new FruitShopServiceImpl(handlerStorage);
        fruitShopService.addToStorage(data);

        ReportService fruitReporter = new ReportServiceImpl();
        String result = fruitReporter.getReport(Storage.getStorage());

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.writeToAFile(result, OUTPUT_FILE);
    }
}
