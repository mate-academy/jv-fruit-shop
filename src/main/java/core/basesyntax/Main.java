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
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/output.csv";
    private static final Map<FruitTransaction.Operation, OperationHandler> operationsMap = Map.of(
            FruitTransaction.Operation.BALANCE, new CreditOperationProcessor(),
            FruitTransaction.Operation.SUPPLY, new CreditOperationProcessor(),
            FruitTransaction.Operation.PURCHASE, new DebitOperationProcessor(),
            FruitTransaction.Operation.RETURN, new CreditOperationProcessor()
    );
    private static final FileReadService fileReadService = new FileReadServiceImpl();
    private static final FruitTransactionParser fruitTransactionParser =
            new FruitTransactionParserImpl();
    private static final OperationStrategy operationStrategy =
            new OperationStrategyImpl(operationsMap);
    private static final TransactionsProcessor transactionsProcessor =
            new TransactionsProcessorImpl(operationStrategy);
    private static final ReportGenerator reportGenerator = new ReportGeneratorImpl();

    public static void main(String[] args) {
        List<String> data = fileReadService.readFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = fruitTransactionParser.toTransactions(data);
        Map<String, Integer> fruitsMap = transactionsProcessor.process(fruitTransactions);

        FileWriteService fileWriteService = new FileWriteServiceImpl();
        fileWriteService.writeToFile(Path.of(REPORT_FILE_PATH),
                reportGenerator.generateReport(fruitsMap));
    }

}
