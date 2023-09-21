package core.basesyntax;

import core.basesyntax.data.FruitData;
import core.basesyntax.data.OperationType;
import core.basesyntax.impl.BalanceOperationHandler;
import core.basesyntax.impl.OperationHandler;
import core.basesyntax.impl.PurchaseOperationHandler;
import core.basesyntax.impl.ReturnOperationHandler;
import core.basesyntax.impl.SupplyOperationHandler;
import core.basesyntax.service.DataHandler;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.DataParserImpl;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataReaderImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.storage.Storage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DataReader dataReader = new DataReaderImpl();
        List<String> dataFromFile = dataReader.readFromFile("src\\main\\resources\\data.csv");

        DataParser dataParser = new DataParserImpl();
        final List<FruitData> parsed = dataParser.parser(dataFromFile);

        Map<OperationType, OperationHandler> operation = new HashMap<>();
        operation.put(OperationType.BALANCE, new BalanceOperationHandler());
        operation.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operation.put(OperationType.RETURN, new ReturnOperationHandler());
        operation.put(OperationType.SUPPLY, new SupplyOperationHandler());

        DataHandler dataHandler = new DataHandler(operation);
        dataHandler.handler(parsed);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(Storage.REPORT);

        WriterService writerService = new WriterServiceImpl();
        File reportFile = new File("src\\main\\resources\\report.csv");
        reportFile = writerService.writetoFile(report);
    }
}
