package core.basesyntax;

import core.basesyntax.model.FruitType;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INTPUT_FILE_NAME = "input.csv";
    private static final String OUTPUT_FILE_NAME = "output-report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperation());
        map.put("p", new PurchaseOperation());
        map.put("s", new SupplyOperation());
        map.put("r", new SupplyOperation());

        OperationStrategy strategy = new OperationStrategy(map);

        ReaderService readerService = new ReaderServiceImpl();
        List<String> lines = readerService.readByFile(INTPUT_FILE_NAME);

        List<Transaction> transactions = new ParserServiceImpl().parse(lines);

        for (Transaction transaktion : transactions) {
            OperationHandler operationHandler = strategy.getByOperation(transaktion.getOperation());
            operationHandler.apply(transaktion);
        }
        String report = new ReportServiceImpl().getReport();
        new WriterServiceImpl().writeToFile(report, OUTPUT_FILE_NAME);
    }
}
