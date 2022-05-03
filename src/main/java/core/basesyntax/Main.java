package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.impl.BalanceOperationHandler;
import core.basesyntax.service.impl.DataParserService;
import core.basesyntax.service.impl.FileReaderService;
import core.basesyntax.service.impl.FileWriterService;
import core.basesyntax.service.impl.PurchaseOperationHandler;
import core.basesyntax.service.impl.ReportCreatorService;
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

        FileReaderService fileReaderService = new FileReaderService();
        List<String> readFromFile = fileReaderService
                .readFromFile(INPUT_DATA_FILE_PATH);

        DataParserService dataParserService = new DataParserService();
        List<FruitTransaction> fruitTransactionList = dataParserService.parseData(readFromFile);
        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler operationHandler = strategy.get(transaction.getOperationType());
            operationHandler.process(transaction);
        }

        ReportCreatorService reportCreatorService = new ReportCreatorService();
        String report = reportCreatorService.createReport();
        core.basesyntax.service.FileWriterService fileWriterService = new FileWriterService();
        fileWriterService.writeToFile("DailyReport", report);
    }
}
