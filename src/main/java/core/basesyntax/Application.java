package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;
import core.basesyntax.service.CalculatorService;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CalculatorServiceImpl;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.Transaction;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.BalanceTransaction;
import core.basesyntax.strategy.impl.PurchaseTransaction;
import core.basesyntax.strategy.impl.ReturnTransaction;
import core.basesyntax.strategy.impl.SupplyTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String INPUT_PATH = "src/main/resources/input.cvs";
    private static final String OUTPUT_PATH = "src/main/resources/output.cvs";

    public static void main(String[] args) {
        Map<StorageTransaction.Operation, Transaction> operations = new HashMap<>();
        operations.put(StorageTransaction.Operation.BALANCE, new BalanceTransaction());
        operations.put(StorageTransaction.Operation.RETURN, new ReturnTransaction());
        operations.put(StorageTransaction.Operation.SUPPLY, new SupplyTransaction());
        operations.put(StorageTransaction.Operation.PURCHASE, new PurchaseTransaction());

        Strategy strategy = new TransactionStrategy(operations);
        ReaderService readerService = new ReaderServiceImpl();
        DataParserService parserService = new DataParserServiceImpl();
        CalculatorService calculatorService = new CalculatorServiceImpl(strategy);
        ReportMakerService reportMakerService = new ReportMakerServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> data = readerService.readData(INPUT_PATH);
        List<StorageTransaction> transactions = parserService.parse(data);
        calculatorService.calculate(transactions);
        String report = reportMakerService.makeReport(Storage.STORAGE);
        writerService.writeData(report, OUTPUT_PATH);
    }
}
