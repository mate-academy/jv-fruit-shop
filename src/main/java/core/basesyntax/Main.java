package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReportMakerImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = 
            "src/main/resources/inputFile.csv";
    private static final String REPORT_FILE_PATH = 
            "src/main/resources/reportFile.csv";  
    private static final Map<Operation, OperationHandler> strategyMap = new HashMap<>();
    
    static {
        strategyMap.put(Operation.BALANCE, new BalanceOperationHandler());
        strategyMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        strategyMap.put(Operation.RETURN, new ReturnOperationHandler());
        strategyMap.put(Operation.SUPPLY, new SupplyOperationHandler());
    }

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        ReportMaker reportMaker = new ReportMakerImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        FruitTransactionService transactionService = new FruitTransactionServiceImpl();

        List<String> inputFileContent = fileService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> transactions = transactionParser.parse(inputFileContent);
        transactionService.execute(transactions, strategyMap);
        List<String> report = reportMaker.makeReport();
        fileService.writeToFile(report, REPORT_FILE_PATH);
    }
}
