package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReport;
import core.basesyntax.service.Parse;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.CreateReportImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReadImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILEPATH_DAILY_RECORD = "src/main/resources/DataDuringDay.csv";
    private static final String FILEPATH_DAILY_REPORT = "src/main/resources/ReportAfterDay.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandlerImpl(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandlerImpl(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandlerImpl(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandlerImpl(storageDao));

        Reader reader = new ReadImpl();
        List<String> dataFromFile = reader.fileReader(FILEPATH_DAILY_RECORD);
        Parse parser = new ParserImpl();
        List<FruitTransaction> fruitTransactionList = parser.parseData(dataFromFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        fruitTransactionList.forEach(fruitTransaction -> operationStrategy
                .getOperationType(fruitTransaction.getOperation())
                .changeQuantity(fruitTransaction));

        CreateReport createReport = new CreateReportImpl(storageDao);
        Writer writer = new WriterImpl();
        writer.writerReportFile(createReport.reportCreate(), FILEPATH_DAILY_REPORT);

    }
}
