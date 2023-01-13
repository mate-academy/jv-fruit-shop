package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.ReaderService;
import core.basesyntax.services.ReportMaker;
import core.basesyntax.services.WriterService;
import core.basesyntax.services.impl.ReaderServiceImpl;
import core.basesyntax.services.impl.ReportMakerImpl;
import core.basesyntax.services.impl.WriterServiceImpl;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.ProcessingService;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/java/resources/dataInput.csv";
    private static final String REPORT_FILE_PATH = "src/main/java/resources/dataReport.csv";

    public static void main(String[] args) {

        Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlersMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> dateFromFile = readerService.readFile(INPUT_FILE_PATH);

        new ProcessingService().process(dateFromFile, operationHandlersMap);

        ReportMaker reportMaker = new ReportMakerImpl();
        String report = reportMaker.makeReport();
        System.out.println(report);

        WriterService fileWriterService = new WriterServiceImpl();
        fileWriterService.writeToFile(report, REPORT_FILE_PATH);
        System.out.println(readerService.readFile(REPORT_FILE_PATH));
    }
}
