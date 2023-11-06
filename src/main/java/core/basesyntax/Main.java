package core.basesyntax;

import core.basesyntax.db.FileReadService;
import core.basesyntax.db.FileReadServiceImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.db.WriteDataToFile;
import core.basesyntax.db.WriteDataToFileImpl;
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

    public static void main(String[] args) {
        Map<FruitOperation.Operation, OperationCalculator> operationStrategyMap = Map.of(
                FruitOperation.Operation.BALANCE, new BalanceCalculatorImpl(),
                FruitOperation.Operation.PURCHASE, new PurchaseCalculatorImpl(),
                FruitOperation.Operation.RETURN, new ReturnCalculatorImpl(),
                FruitOperation.Operation.SUPPLY, new SupplyCalculatorImpl()
        );

        FileReadService readService = new FileReadServiceImpl();
        List<String> dataFromReport = readService.readDataFromReport(INPUT_FILE);

        OperationParser operationParserParser = new OperationParserImpl();
        List<FruitOperation> fruitTransaction = operationParserParser
                .getFruitTransaction(dataFromReport);
        TransactionProcessor operationProcessor = new TransactionProcessorImpl(
                new OperationStrategyImpl(operationStrategyMap)
        );
        operationProcessor.process(fruitTransaction);

        Accounting accounting = new AccountingImpl();
        String report = accounting.accountingReport(Storage.getFruitKindsAndQuantity());

        WriteDataToFile writeDataToFile = new WriteDataToFileImpl();
        writeDataToFile.writeDataToFile(report, REPORT_FILE);
    }
}
