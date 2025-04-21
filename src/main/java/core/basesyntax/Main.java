package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConverterFruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.TransactionProcess;
import core.basesyntax.service.impl.ConverterFruitTransactionImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.service.impl.TransactionProcessImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String TRANSACTIONS_FILE_PATH
            = "src/main/resources/read.csv";
    private static final String REPORT_FILE_PATH
            = "src/main/resources/report.csv";

    public static void main(String[] args) {

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> inputReport = fileReaderService.readFile(TRANSACTIONS_FILE_PATH);

        ConverterFruitTransaction converterFruitTransaction = new ConverterFruitTransactionImpl();
        List<FruitTransaction> transactions = converterFruitTransaction
                .converterFruitTransaction(inputReport);

        Storage storage = new Storage();

        Map<FruitTransaction.Operation, OperationHandler> operations = Map.of(
                FruitTransaction.Operation.SUPPLY, new SupplyOperation(storage),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(storage),
                FruitTransaction.Operation.RETURN, new ReturnOperation(storage),
                FruitTransaction.Operation.BALANCE, new BalanceOperation(storage)
        );

        OperationStrategy operationStrategy = new OperationStrategyImpl(operations);
        TransactionProcess transactionProcess =
                new TransactionProcessImpl(operationStrategy, storage);
        transactions.forEach(transactionProcess::process);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String report = reportGenerator.generateReport();

        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeIntoFile(REPORT_FILE_PATH, report);
    }
}
