package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationService;
import core.basesyntax.operation.impl.OperationServiceBalanceImpl;
import core.basesyntax.operation.impl.OperationServicePurchaseImpl;
import core.basesyntax.operation.impl.OperationServiceReturnImpl;
import core.basesyntax.operation.impl.OperationServiceSupplyImpl;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.StrategyOperation;
import core.basesyntax.strategy.impl.StrategyOperationImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationService> operation = new HashMap<>();
        operation.put(FruitTransaction.Operation.BALANCE, new OperationServiceBalanceImpl());
        operation.put(FruitTransaction.Operation.PURCHASE, new OperationServicePurchaseImpl());
        operation.put(FruitTransaction.Operation.RETURN, new OperationServiceReturnImpl());
        operation.put(FruitTransaction.Operation.SUPPLY, new OperationServiceSupplyImpl());

        List<String> lineInfo = new CsvReaderServiceImpl().read(INPUT_FILE_PATH);
        List<FruitTransaction> fruits = new FruitTransactionParserServiceImpl().parse(lineInfo);

        StrategyOperation strategyOperation = new StrategyOperationImpl(operation);
        for (FruitTransaction transaction : fruits) {
            strategyOperation.getOperationService(transaction.getOperation()).apply(transaction);
        }

        String report = new ReportServiceImpl().createReport();
        new CsvWriterServiceImpl().write(REPORT_FILE_PATH, report);
    }

}
