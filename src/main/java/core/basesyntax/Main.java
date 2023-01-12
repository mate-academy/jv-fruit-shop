package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FileReadService;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.StorageUpdateService;
import core.basesyntax.service.amount.*;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FileReadServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.StorageUpdateServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final FileReadService dataReader = new FileReadServiceImpl();
    private static final Map<Operation, OperationHandler> OPERATION_MAP = new HashMap<>();
    private static final StorageUpdateService storageUpdateService
            = new StorageUpdateServiceImpl(OPERATION_MAP);
    private static final DataParserService listOfTransactions
            = new DataParserServiceImpl();
    private static final FileWriteService dataWriter = new FileWriteServiceImpl();
    private static final ReportCreator reportCreator = new ReportCreatorImpl();
    private static final String INPUT_PATH = "src/main/resources/data.csv";
    private static final String OUTPUT_PATH = "src/main/resources/report.csv";

    static {
        OPERATION_MAP.put(Operation.BALANCE, new BalanceHandlerImpl());
        OPERATION_MAP.put(Operation.SUPPLY, new SupplyHandlerImpl());
        OPERATION_MAP.put(Operation.PURCHASE, new PurchaseHandlerImpl());
        OPERATION_MAP.put(Operation.RETURN, new ReturnHandlerImpl());
    }

    public static void main(String[] args) {
        String data = dataReader.readFromFile(INPUT_PATH);
        List<FruitTransaction> fruitTransactions = listOfTransactions.getTransactions(data);
        storageUpdateService.update(fruitTransactions);
        String report = reportCreator.createReport();
        dataWriter.writeToFile(OUTPUT_PATH, report);
    }
}
