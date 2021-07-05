package core.basesyntax;

import core.basesyntax.dto.Transaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.strategy.AdditionOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.SubtractionOperatorHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Transaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Transaction.Operation.B, new BalanceOperationHandler());
        handlers.put(Transaction.Operation.P, new SubtractionOperatorHandler());
        handlers.put(Transaction.Operation.R, new AdditionOperationHandler());
        handlers.put(Transaction.Operation.S, new AdditionOperationHandler());

        ReaderService reader = new ReaderServiceImpl();
        List<String> stringsList = reader.readFromFile("src/main/toRead.txt");
        Parser parser = new ParserImpl();
        List<Transaction> list = parser.parseToTransactionList(stringsList);
        for (Transaction transaction : list) {
            OperationHandler operationHandler = handlers.get(transaction.getOperation());
            operationHandler.apply(transaction);
        }
        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile("src/main/toWrite.txt", report);
    }
}
