package core.basesyntax;

import core.basesyntax.dao.ReportDao;
import core.basesyntax.dao.ReportDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.BalanceSetter;
import core.basesyntax.service.ConverterFruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ReportCreate;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcess;
import core.basesyntax.service.impl.BalanceSetterImpl;
import core.basesyntax.service.impl.ConverterFruitTransactionImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreateImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionProcessImpl;
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
    private static final Map<Operation, OperationHandler> operations =
            Map.of(Operation.SUPPLY, new SupplyOperation(),
                    Operation.PURCHASE, new PurchaseOperation(),
                    Operation.RETURN, new ReturnOperation());

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> reader = fileReaderService.readFile(TRANSACTIONS_FILE_PATH);

        ConverterFruitTransaction converterFruitTransaction = new ConverterFruitTransactionImpl();
        List<FruitTransaction> transactions = converterFruitTransaction
                .converterFruitTransaction(reader);

        ReportDao reportDao = new ReportDaoImpl();

        BalanceSetter balanceSetter = new BalanceSetterImpl(reportDao);
        balanceSetter.setBalance(transactions);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operations);
        TransactionProcess transactionProcess =
                new TransactionProcessImpl(operationStrategy, reportDao);

        ReportCreate reportCreate = new ReportCreateImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl(reportDao);

        transactions.forEach(transactionProcess::process);
        String report = reportGenerator.generate();
        reportCreate.send(REPORT_FILE_PATH, report);
    }
}
