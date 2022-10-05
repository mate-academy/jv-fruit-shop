package core.basesyntax;

import static core.basesyntax.db.Storage.getStorage;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.BalanceOperationHandler;
import core.basesyntax.service.CsvFruitTransactionParserImpl;
import core.basesyntax.service.CsvReportCreatorImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWrite;
import core.basesyntax.service.FileWriteImpl;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.PurchaseOperationHandler;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.RetureOperationHandler;
import core.basesyntax.service.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
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
        Map<String, Integer> map = getStorage();
        ReportCreator reportCreator = new CsvReportCreatorImpl();
        String report = reportCreator.createReport(map);
        FileWrite fileWriter = new FileWriteImpl();
        fileWriter.writeDataToFile(report, "result.csv");
    }
}
