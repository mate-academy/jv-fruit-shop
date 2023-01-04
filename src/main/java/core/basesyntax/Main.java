package core.basesyntax;

import core.basesyntax.dao.ReportToFile;
import core.basesyntax.dao.impl.ReportToFileImpl;
import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.strategy.FileService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.Transaction;
import core.basesyntax.strategy.TransactionParse;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.FileServiseImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import core.basesyntax.strategy.impl.TransactionImpl;
import core.basesyntax.strategy.impl.TransactionParseImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FILE = "src/main/resources/inputFile.csv";
    private static final String WRITE_FILE = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        FileService fileService = new FileServiseImpl();
        List<String> stringList = fileService.readFile(READ_FILE);
        TransactionParse transactionParse = new TransactionParseImpl();
        List<FruitsTranslation> fruitsTranslations = transactionParse.parseData(stringList);
        Map<FruitsTranslation.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitsTranslation.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitsTranslation.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitsTranslation.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitsTranslation.Operation.RETURN, new ReturnHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        Transaction transaction = new TransactionImpl(operationStrategy);
        Map<String, Integer> result = transaction.process(fruitsTranslations);
        ReportToFile reportToFile = new ReportToFileImpl();
        String report = reportToFile.doReport(result);
        fileService.writeToFile(report, WRITE_FILE);
    }
}
