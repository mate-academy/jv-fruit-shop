package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;
import core.basesyntax.service.Reader;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.service.parsing.TransactionParserImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String RECORDS_FILE_NAME = "src/main/resources/records.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";
    private static final String HEADER = "type,fruit,quantity";

    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        List<String> recordsFromFile = reader.read(RECORDS_FILE_NAME);
        recordsFromFile.remove(HEADER);
        List<FruitTransaction> transactions = new TransactionParserImpl()
                .parse(recordsFromFile);

        OperationStrategy strategy = new OperationStrategy(getOperations());
        for (FruitTransaction transaction : transactions) {
            strategy.process(transaction);
        }

        String report = new ReportGeneratorImpl().makeReport();
        new WriterImpl().writeToFile(report, REPORT_FILE_NAME);
    }

    private static Map<FruitTransaction.Operation, OperationHandler> getOperations() {
        Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
        map.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        map.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        return map;
    }
}
