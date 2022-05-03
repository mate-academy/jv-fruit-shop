package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.BalanceOperationHandlerImpl;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.ReturnOperationHandlerImpl;
import core.basesyntax.service.impl.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_DATA_FILE_PATH = "src/main/resources/InputData";

    public static void main(String[] args) {
        Map<String, OperationHandler> strategy = new HashMap<>();
        strategy.put("b", new BalanceOperationHandlerImpl());
        strategy.put("s", new SupplyOperationHandlerImpl());
        strategy.put("r", new ReturnOperationHandlerImpl());
        strategy.put("p", new PurchaseOperationHandlerImpl());
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> readedFromFile = fileReaderService
                .readDataFromFiletoList(INPUT_DATA_FILE_PATH);
        DataParserService dataParserService = new DataParserServiceImpl();
        List<FruitTransaction> fruitTransactionList = dataParserService.parseData(readedFromFile);
        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler operationHandler = strategy.get(transaction.getTypeOfTransaction());
            operationHandler.process(transaction);
        }
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        String report = reportCreatorService.createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile("DailyReport", report);
    }
}



