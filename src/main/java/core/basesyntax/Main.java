package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.BalanceOperationHandler;
import core.basesyntax.service.CsvFruitTransactionParserImpl;
import core.basesyntax.service.CsvReportCreatorImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.PurchaseOperationHandler;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.RetureOperationHandler;
import core.basesyntax.service.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> morningBalance = new ArrayList<>();
        Collections.addAll(morningBalance, "b,banana,200", "b,apple,100",
                "s,banana,100", "p,banana,50", "r,apple,10", "p,apple,70",
                "p,banana,50", "s,banana,50", "b,ananas,150", "s,ananas,50",
                "p,ananas,100", "r,ananas,20");
        FileReader fileReader = new FileReaderImpl();
        List<String> dataFromFile = fileReader.readFromFile("file.csv");
        FruitTransactionParser transactionParser = new CsvFruitTransactionParserImpl();
        final List<FruitTransaction> transactions = transactionParser.parse(dataFromFile);
        Map<String, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put("b", new BalanceOperationHandler());
        operationStrategyMap.put("s", new SupplyOperationHandler());
        operationStrategyMap.put("p", new PurchaseOperationHandler());
        operationStrategyMap.put("r", new RetureOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);
        transactions.forEach(transaction -> {
            operationStrategy.get(transaction.getOperation().getOperationString())
                    .apply(transaction);
        });
        Storage storage = new Storage();
        Map<String, Integer> map = storage.getStorage();
        ReportCreator reportCreator = new CsvReportCreatorImpl();
        String report = reportCreator.createReport(map);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeDataToFile(report, "result.csv");
    }
}
