package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FileReadService;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.StorageUpdateService;
import core.basesyntax.service.amount.BalanceHandlerImpl;
import core.basesyntax.service.amount.OperationHandler;
import core.basesyntax.service.amount.PurchaseHandlerImpl;
import core.basesyntax.service.amount.ReturnHandlerImpl;
import core.basesyntax.service.amount.SupplyHandlerImpl;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FileReadServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.StorageUpdateServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final FileReadService fileReadService = new FileReadServiceImpl();
    private static final Map<Operation, OperationHandler> operationsMap = new HashMap<>();
    private static final StorageUpdateService storageUpdateService
            = new StorageUpdateServiceImpl(operationsMap);
    private static final DataParserService dataParserService
            = new DataParserServiceImpl();
    private static final FileWriteService fileWriteService = new FileWriteServiceImpl();
    private static final ReportCreator reportCreator = new ReportCreatorImpl();
    private static final String INPUT_PATH = "src/main/resources/data.csv";
    private static final String OUTPUT_PATH = "src/main/resources/report.csv";

    static {
        operationsMap.put(Operation.BALANCE, new BalanceHandlerImpl());
        operationsMap.put(Operation.SUPPLY, new SupplyHandlerImpl());
        operationsMap.put(Operation.PURCHASE, new PurchaseHandlerImpl());
        operationsMap.put(Operation.RETURN, new ReturnHandlerImpl());
    }

    public static void main(String[] args) {
        String data = fileReadService.readFromFile(INPUT_PATH);
        List<FruitTransaction> fruitTransactions = dataParserService.getTransactions(data);
        storageUpdateService.update(fruitTransactions);
        String report = reportCreator.createReport();
        fileWriteService.writeToFile(OUTPUT_PATH, report);
    }
}
