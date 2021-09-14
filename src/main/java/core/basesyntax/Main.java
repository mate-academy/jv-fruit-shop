package core.basesyntax;

import core.basesyntax.db.HandlerStorage;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.DecreaseAmountOperationHandlerImpl;
import core.basesyntax.strategy.IncreaseAmountOperationHandlerImpl;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/fruits.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitRecord.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitRecord.Operation.PURCHASE, new DecreaseAmountOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.SUPPLY, new IncreaseAmountOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.BALANCE, new BalanceOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.RETURN, new IncreaseAmountOperationHandlerImpl());
        HandlerStorage handlerStorage = new HandlerStorage(handlerMap);

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> rowsList = fileReaderService.readRowsFromFile(INPUT_FILE_NAME);

        FruitShopService fruitShopService = new FruitShopServiceImpl(handlerStorage);
        fruitShopService.addInfoToStorage(rowsList);

        ReportMakerService fruitReporter = new ReportMakerServiceImpl();
        String report = fruitReporter.getReport(Storage.getStorage());

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.writeToFile(report, OUTPUT_FILE_NAME);
    }
}
