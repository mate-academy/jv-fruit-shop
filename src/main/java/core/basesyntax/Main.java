package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.CalculateStrategy;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.CalculateStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE_NAME = "src/main/java/core/basesyntax/"
            + "resources/input.csv";
    public static final String TO_FILE_NAME = "src/main/java/core/basesyntax/"
            + "resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        OperationHandler balanceHandler = new BalanceHandler();
        OperationHandler purchaseHandler = new PurchaseHandler();
        OperationHandler returnHandler = new ReturnHandler();
        OperationHandler supplyHandler = new SupplyHandler();
        handlers.put(FruitTransaction.Operation.BALANCE, balanceHandler);
        handlers.put(FruitTransaction.Operation.PURCHASE, purchaseHandler);
        handlers.put(FruitTransaction.Operation.RETURN, returnHandler);
        handlers.put(FruitTransaction.Operation.SUPPLY, supplyHandler);
        CalculateStrategy calculateStrategy = new CalculateStrategyImpl(new HashMap<>());
        ReaderService readerService = new ReaderServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        FruitService fruitService = new FruitServiceImpl(calculateStrategy);
        DataParserService dataParserService = new DataParserServiceImpl();
        ReportMakerService reportMakerService = new ReportMakerServiceImpl();
        File file = new File(INPUT_FILE_NAME);
        List<String> dataFromFile = readerService.readDataFromFile(file);
        List<FruitTransaction> parsedDataFromFile = dataParserService
                .parseDataToFruitTransaction(dataFromFile);
        fruitService
                .calculateTotalQuantity(parsedDataFromFile);
        String report = reportMakerService.generateReport(FruitStorage.calculationStorage);
        writerService.writeDataToFile(report, TO_FILE_NAME);
    }
}
