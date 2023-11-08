package core.basesyntax;

import core.basesyntax.db.FileReader;
import core.basesyntax.db.FileReaderImpl;
import core.basesyntax.db.FileWriter;
import core.basesyntax.db.FileWriterImpl;
import core.basesyntax.db.StorageDao;
import core.basesyntax.service.accountingreport.Accounting;
import core.basesyntax.service.accountingreport.AccountingImpl;
import core.basesyntax.service.accountingreport.TransactionProcessor;
import core.basesyntax.service.accountingreport.TransactionProcessorImpl;
import core.basesyntax.service.calculator.BalanceCalculatorImpl;
import core.basesyntax.service.calculator.OperationCalculator;
import core.basesyntax.service.calculator.PurchaseCalculatorImpl;
import core.basesyntax.service.calculator.ReturnCalculatorImpl;
import core.basesyntax.service.calculator.SupplyCalculatorImpl;
import core.basesyntax.service.operation.FruitOperation;
import core.basesyntax.service.operation.OperationParser;
import core.basesyntax.service.operation.OperationParserImpl;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/InputFile.csv";
    private static final String REPORT_FILE = "src/main/resources/Report.csv";
    private Map<FruitOperation.Operation, OperationCalculator> operationStrategyMap;

    public Main() {
        operationStrategyMap = Map.of(
                FruitOperation.Operation.BALANCE, new BalanceCalculatorImpl(),
                FruitOperation.Operation.PURCHASE, new PurchaseCalculatorImpl(),
                FruitOperation.Operation.RETURN, new ReturnCalculatorImpl(),
                FruitOperation.Operation.SUPPLY, new SupplyCalculatorImpl()
        );
    }

    public static void main(String[] args) {
        Main main = new Main();

        FileReader readService = new FileReaderImpl();
        List<String> dataFromReport = readService.readFile(INPUT_FILE);

        OperationParser operationParserParser = new OperationParserImpl();
        List<FruitOperation> fruitTransaction = operationParserParser
                .getFruitTransaction(dataFromReport);
        TransactionProcessor operationProcessor = new TransactionProcessorImpl(
                new OperationStrategyImpl(main.operationStrategyMap)
        );
        operationProcessor.process(fruitTransaction);

        Accounting accounting = new AccountingImpl();
        String report = accounting.makeReport(StorageDao.FRUIT_KINDS_AND_QUANTITY);

        FileWriter writeDataToFile = new FileWriterImpl();
        writeDataToFile.writeDataToFile(report, REPORT_FILE);
    }
}
