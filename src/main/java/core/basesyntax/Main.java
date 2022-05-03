package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.BalanceOperationHandler;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.PurchaseOperationHandler;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.ReturnOperationHandler;
import core.basesyntax.service.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_DATA_FILE_PATH = "src/main/resources/InputData";

    public static void main(String[] args) {
        Map<String, OperationHandler> strategy = new HashMap<>();
        strategy.put("b", new BalanceOperationHandler());
        strategy.put("s", new SupplyOperationHandler());
        strategy.put("r", new ReturnOperationHandler());
        strategy.put("p", new PurchaseOperationHandler());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> readFromFile = fileReaderService
                .readFromFile(INPUT_DATA_FILE_PATH);

        DataParserService dataParserService = new DataParserServiceImpl();
        List<FruitTransaction> fruitTransactionList = dataParserService.parseData(readFromFile);
        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler operationHandler = strategy.get(transaction.getOperationType());
            operationHandler.process(transaction);
        }

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        String report = reportCreatorService.createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile("DailyReport", report);
    }
}
