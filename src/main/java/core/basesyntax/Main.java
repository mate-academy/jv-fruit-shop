package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReporterServiceImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import core.basesyntax.strategy.operation.Operation;
import core.basesyntax.strategy.operation.impl.Balance;
import core.basesyntax.strategy.operation.impl.Purchase;
import core.basesyntax.strategy.operation.impl.Return;
import core.basesyntax.strategy.operation.impl.Supply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/TransactionsPerDay.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/DailyReport.csv";

    public static void main(String[] args) {
        Map<Transaction.Operation, Operation> map = new HashMap<>();
        map.put(Transaction.Operation.BALANCE, new Balance());
        map.put(Transaction.Operation.SUPPLY, new Supply());
        map.put(Transaction.Operation.RETURN, new Return());
        map.put(Transaction.Operation.PURCHASE, new Purchase());
        Strategy operationStrategy = new StrategyImpl(map);
        List<String> data = new FileReaderServiceImpl().readFromFile(INPUT_FILE_NAME);
        List<Transaction> transactions = new DataParserServiceImpl().parse(data);
        for (Transaction transaction : transactions) {
            Operation handler = operationStrategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }
        String report = new ReporterServiceImpl().getReport();
        new FileWriterServiceImpl().writeToFile(report, OUTPUT_FILE_NAME);
    }
}
