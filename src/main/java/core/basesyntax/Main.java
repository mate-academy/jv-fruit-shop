package core.basesyntax;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.data.OperationType;
import core.basesyntax.service.DataHandlerImpl;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ParserServiceImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String DATA_PATH = "src\\main\\resources\\data.csv";
    private static final String REPORT_PATH = "src\\main\\resources\\report.csv";
    private static final String FILE_NAME = "Report.csv";

    public static void main(String[] args) {
        ReaderService dataReader = new ReaderServiceImpl();
        List<String> dataFromFile = dataReader.readFromFile(DATA_PATH);

        ParserService dataParser = new ParserServiceImpl();
        final List<FruitTransaction> parsed = dataParser.parser(dataFromFile);

        Map<OperationType, OperationHandler> operation = new HashMap<>();
        operation.put(OperationType.BALANCE, new BalanceOperationHandler());
        operation.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operation.put(OperationType.RETURN, new ReturnOperationHandler());
        operation.put(OperationType.SUPPLY, new SupplyOperationHandler());

        DataHandlerImpl dataHandler = new DataHandlerImpl(operation);
        dataHandler.handler(parsed);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(Storage.REPORT);

        WriterService writerService = new WriterServiceImpl();
        new File(REPORT_PATH);
        writerService.writetoFile(report, FILE_NAME);
    }
}
