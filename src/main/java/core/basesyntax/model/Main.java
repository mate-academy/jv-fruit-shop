package core.basesyntax.model;

import core.basesyntax.model.service.DataWriter;
import core.basesyntax.model.serviceimpl.DataBaseImpl;
import core.basesyntax.model.serviceimpl.DataParserImpl;
import core.basesyntax.model.serviceimpl.DataReaderImpl;
import core.basesyntax.model.serviceimpl.DataWriterImpl;
import core.basesyntax.model.serviceimpl.ReportDataImpl;
import core.basesyntax.model.strategy.OperationStrategy;
import core.basesyntax.model.strategy.OperationStrategyImpl;
import core.basesyntax.model.strategy.handler.BalanceOperationHandler;
import core.basesyntax.model.strategy.handler.OperationHandler;
import core.basesyntax.model.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.model.strategy.handler.ReturnOperationHandler;
import core.basesyntax.model.strategy.handler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_FILE = "dataOfFruitShop.csv";
    private static final String REPORT_FILE = "reportOfFruitShop.csv";
    private static Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public static void main(String[] args) {
        DataBaseImpl dataBase = new DataBaseImpl();
        operationHandlerMap = newHashMap(dataBase);
        List<String> dataFromFile = new DataReaderImpl().readData(DATA_FILE);
        List<FruitTransaction> transactions = new DataParserImpl().parse(dataFromFile);
        processingData(transactions);
        String dataReport = new ReportDataImpl().createDataReport(dataBase.getAll());
        DataWriter dataWriter = new DataWriterImpl();
        dataWriter.writeData(REPORT_FILE, dataReport);
    }

    private static Map<FruitTransaction.Operation,
            OperationHandler> newHashMap(DataBaseImpl dataBase) {
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
