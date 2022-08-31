package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OperationStrategy.operationMap
                .put(Transaction.Operation.BALANCE, new BalanceOperationHandlerImpl());
        OperationStrategy.operationMap
                .put(Transaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        OperationStrategy.operationMap
                .put(Transaction.Operation.SUPPLY, new SupplyOperationHandlerImpl());
        OperationStrategy.operationMap
                .put(Transaction.Operation.RETURN, new ReturnOperationHandlerImpl());
        File input = new File("src/main/resources/input.csv");
        FileReader reader = new FileReaderImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        List<Transaction> list = transactionParser.parse(reader.read(input));
        for (Transaction transaction : list) {
            OperationStrategy.operationMap
                    .get(transaction.getOperation())
                    .apply(transaction);
        }
        File file = new File("src/main/resources/report.csv");
        new ReportWriterImpl().write(new ReportGeneratorImpl()
                 .generateReport(), file);
    }

}
