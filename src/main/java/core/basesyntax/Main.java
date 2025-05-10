package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.strategy.OperationHandlerStrategyImpl;
import core.basesyntax.strategy.operation.BalanceHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseHandler;
import core.basesyntax.strategy.operation.ReturnHandler;
import core.basesyntax.strategy.operation.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FILE = "src/main/resources/input.csv";
    private static final String WRITE_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlerOperaionMap = new HashMap<>();
        handlerOperaionMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        handlerOperaionMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        handlerOperaionMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        handlerOperaionMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        OperationHandlerStrategy strategy = new OperationHandlerStrategyImpl(handlerOperaionMap);

        FileReader reader = new FileReaderImpl();
        List<String> transactions = reader.readData(READ_FILE);
        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> parsedData = parser.process(transactions);

        for (FruitTransaction data : parsedData) {
            OperationHandler operationHandler = strategy.get(data.getOperation());
            operationHandler.operate(data);
        }

        String report = new ReportServiceImpl().createReport();
        FileWriter writer = new FileWriterImpl();
        writer.writeData(report, WRITE_FILE);
    }
}
