package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.DataWriterImpl;
import core.basesyntax.service.impl.ReportDataImpl;
import core.basesyntax.storage.StorageImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_FILE = "dataOfFruitShop.csv";
    private static final String REPORT_FILE = "reportOfFruitShop.csv";
    private static Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public static void main(String[] args) {
        StorageImpl dataBase = new StorageImpl();
        operationHandlerMap = newHashMap(dataBase);
        List<String> dataFromFile = new DataReaderImpl().readData(DATA_FILE);
        List<FruitTransaction> transactions = new DataParserImpl().parse(dataFromFile);
        processingData(transactions);
        String dataReport = new ReportDataImpl().createDataReport(dataBase.getEntrySet());
        DataWriter dataWriter = new DataWriterImpl();
        dataWriter.writeData(REPORT_FILE, dataReport);
    }

    private static Map<FruitTransaction.Operation,
            OperationHandler> newHashMap(StorageImpl dataBase) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandler = new HashMap<>();
        operationHandler.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(dataBase));
        operationHandler.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(dataBase));
        operationHandler.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(dataBase));
        operationHandler.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(dataBase));
        return operationHandler;
    }

    public static void processingData(List<FruitTransaction> transactions) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        transactions.forEach(f -> operationStrategy.get(f.getOperation())
                .processingOperation(f));
    }

}
