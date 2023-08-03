package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FileReader;
import core.basesyntax.services.FileWriter;
import core.basesyntax.services.FruitShopUpdateService;
import core.basesyntax.services.ProcessData;
import core.basesyntax.services.ReportCreator;
import core.basesyntax.services.impl.CsvReaderImpl;
import core.basesyntax.services.impl.CsvWriterImpl;
import core.basesyntax.services.impl.FruitShopUpdateServiceImpl;
import core.basesyntax.services.impl.OperationStrategyImpl;
import core.basesyntax.services.impl.ProcessDataImpl;
import core.basesyntax.services.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handlers.BalanceHandler;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseHandler;
import core.basesyntax.strategy.handlers.ReturnHandler;
import core.basesyntax.strategy.handlers.SupplyHandler;
import java.util.Map;

public class Main {
    private static final Map<FruitTransaction.OperationType, OperationHandler> MAP = Map.of(
            FruitTransaction.OperationType.BALANCE, new BalanceHandler(),
            FruitTransaction.OperationType.RETURN, new ReturnHandler(),
            FruitTransaction.OperationType.PURCHASE, new PurchaseHandler(),
            FruitTransaction.OperationType.SUPPLY, new SupplyHandler());
    private static final String FROM_FILE_PATH = "src/main/resources/CsvInput.csv";
    private static final String TO_FILE_PATH = "src/main/resources/CsvOutput.csv";

    public static void main(String[] args) {
        FileReader fileCsvReader = new CsvReaderImpl();
        ProcessData processDataService = new ProcessDataImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();
        FileWriter fileCsvWriter = new CsvWriterImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        FruitShopUpdateService<FruitTransaction> fruitShopUpdateService =
                new FruitShopUpdateServiceImpl(operationStrategy);
        String transactions = fileCsvReader.read(FROM_FILE_PATH);
        fruitShopUpdateService.update(processDataService.process(transactions), MAP);
        fileCsvWriter.write(TO_FILE_PATH, reportCreator.createReport());

    }
}
