package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FormaterService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.FormaterServiceImpl;
import core.basesyntax.service.impl.ProcessServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String PATH_TO_INPUT_FILE = "src/main/java/resources/input.csv";
    public static final String PATH_TO_REPORT_FILE = "src/main/java/resources/report.csv";

    public static final Map<Operation, OperationHandler> HANDLER_MAP = new HashMap<>();

    static {
        HANDLER_MAP.put(Operation.BALANCE, new BalanceOperationHandler());
        HANDLER_MAP.put(Operation.PURCHASE, new PurchaseOperationHandler());
        HANDLER_MAP.put(Operation.RETURN, new ReturnOperationHandler());
        HANDLER_MAP.put(Operation.SUPPLY, new SupplyOperationHandler());
    }

    public static void main(String[] args) {
        ReaderService readerService = new CsvReaderServiceImpl();
        FormaterService formaterService = new FormaterServiceImpl();
        ProcessServiceImpl processService = new ProcessServiceImpl(HANDLER_MAP);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> inputFromFile = readerService.read(PATH_TO_INPUT_FILE);
        List<FruitTransaction> fruitTransactions = formaterService.form(inputFromFile);
        processService.manageTransactions(fruitTransactions);
        String report = reportService.generateReport();
        writerService.writeToFile(report, PATH_TO_REPORT_FILE);
    }
}
