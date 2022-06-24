package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.TransactionMapper;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionMapperImpl;
import core.basesyntax.service.impl.TransactionStrategyImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.handler.BalanceHandler;
import core.basesyntax.strategy.handler.PurchaseHandler;
import core.basesyntax.strategy.handler.ReturnHandler;
import core.basesyntax.strategy.handler.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Transaction.Operation, TransactionHandler> operationStrategies = new HashMap<>();
        operationStrategies.put(Transaction.Operation.BALANCE, new BalanceHandler());
        operationStrategies.put(Transaction.Operation.PURCHASE, new PurchaseHandler());
        operationStrategies.put(Transaction.Operation.SUPPLY, new SupplyHandler());
        operationStrategies.put(Transaction.Operation.RETURN, new ReturnHandler());
        ReaderService reader = new ReaderServiceImpl();
        List<String> records = reader.read("src/main/resources/test1");
        TransactionMapper mapper = new TransactionMapperImpl();
        List<Transaction> transactions = mapper.map(records);
        TransactionStrategy processor = new TransactionStrategyImpl(operationStrategies);
        processor.process(transactions);
        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.create();
        WriterService writer = new WriterServiceImpl();
        writer.write(report, "src/main/resources/test1_report");
    }
}
