package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH_NAME = "src/main/resources/InputFile.csv";
    private static final String OUTPUT_FILE_PATH_NAME = "src/main/resources/DailyReport.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();

        {
            operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                    new BalanceOperationHandler());
            operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                    new SupplyOperationHandler());
            operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                    new PurchaseOperationHandler());
            operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                    new ReturnOperationHandler());
        }

        List<String> dataFromFile = new FileReaderServiceImpl().readFromFile(INPUT_FILE_PATH_NAME);
        List<FruitTransaction> transactions = new FruitTransactionParserImpl()
                .transformToTransaction(dataFromFile);
        new TransactionProcessorImpl().process(transactions, operationHandlerMap);
        String report = new ReportGeneratorImpl().generate();
        new FileWriterServiceImpl().writeToFile(OUTPUT_FILE_PATH_NAME, report);
    }
}
