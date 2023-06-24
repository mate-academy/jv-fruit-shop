package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.FruitTransactionProcessorImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.strategy.OperationCalculator;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.CreditOperationHandler;
import core.basesyntax.strategy.impl.DebitOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/output.csv";
    private static final Map<FruitTransaction.Operation, OperationCalculator> operationsMap =
            Map.of(
            FruitTransaction.Operation.BALANCE, new CreditOperationHandler(),
            FruitTransaction.Operation.SUPPLY, new CreditOperationHandler(),
            FruitTransaction.Operation.PURCHASE, new DebitOperationHandler(),
            FruitTransaction.Operation.RETURN, new CreditOperationHandler()
    );
    private static final FileReaderService fileReadService = new FileReaderServiceImpl();
    private static final FruitTransactionParser fruitTransactionParser =
            new FruitTransactionParserImpl();
    private static final OperationStrategy operationStrategy =
            new OperationStrategyImpl(operationsMap);
    private static final FruitTransactionProcessor transactionsProcessor =
            new FruitTransactionProcessorImpl(operationStrategy);
    private static final ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private static final FileWriterService fileWriteService = new FileWriterServiceImpl();

    public static void main(String[] args) {
        List<String> data = fileReadService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = fruitTransactionParser.toTransactions(data);
        Map<String, Integer> fruitsMap = transactionsProcessor.process(fruitTransactions);
        fileWriteService.writeToFile(REPORT_FILE_PATH, reportGenerator.generateReport(fruitsMap));
    }

}
