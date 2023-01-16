package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReadService;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionsProcessor;
import core.basesyntax.service.impl.FileReadServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionsProcessorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.CreditOperationProcessor;
import core.basesyntax.strategy.impl.DebitOperationProcessor;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String REPORT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationsMap = Map.of(
                FruitTransaction.Operation.BALANCE, new CreditOperationProcessor(),
                FruitTransaction.Operation.SUPPLY, new CreditOperationProcessor(),
                FruitTransaction.Operation.PURCHASE, new DebitOperationProcessor(),
                FruitTransaction.Operation.RETURN, new CreditOperationProcessor()
        );
        FileReadService fileReadService = new FileReadServiceImpl();
        List<String> data = fileReadService.readFromFile(Path.of(INPUT_FILE));

        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitRecords = fruitTransactionParser.toTransactions(data);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsMap);
        TransactionsProcessor transactionsProcessor =
                new TransactionsProcessorImpl(operationStrategy);
        Map<String, Integer> map = transactionsProcessor.process(fruitRecords);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        FileWriteService fileWriteService = new FileWriteServiceImpl();
        fileWriteService.writeToFile(Path.of(REPORT_FILE), reportGenerator.generateReport(map));
    }

}
