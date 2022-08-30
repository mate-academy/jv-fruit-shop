package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/fruits_shop.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/fruits_report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();


        OperationStrategy strategy = new OperationStrategy(map);

        ReaderService readerService = new ReaderServiceImpl();

        List<String> lines = readerService
                .readerFromFile(INPUT_FILE_NAME);

        List<Transaction> transactions = new ParserServiceImpl().parse(lines);

        for (Transaction transaction: transactions){
            OperationHandler handler = strategy
                    .getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }

        String report = new ReportServiceImpl().getReport();

        new WriterServiceImpl().writeToFile(report, OUTPUT_FILE_NAME);
        map.put("b", new BalanceOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("s", new SupplyOperationHandler());
        map.put("r", new ReturnOperationHandler());
    }
}
