package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static final String FILENAME = "src/main/resources/input.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Storage storage = new Storage();
        HashMap<FruitTransaction.Operation, OperationStrategy> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        TransactionProcessor transactionProcessor = new TransactionProcessor(storage, operationMap);
        TransactionParser transactionParser = new TransactionParser();
        FileReader inputReader = new FileReader();
        ReportCreator reportCreator = new ReportCreator();
        FileWriter fileWriter = new FileWriter();
        ArrayList<String> linesFromFile = inputReader.read(FILENAME);
        for (String line : linesFromFile) {
            transactionProcessor.processTransaction(transactionParser.parseTransaction(line));
        }
        fileWriter.write(REPORT_FILE_NAME, reportCreator.createReport(storage));
    }
}
