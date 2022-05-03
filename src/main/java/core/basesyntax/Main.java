package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ValidationService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ValidationServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String WAREHOUSE_DATABASE = "src/main/resources/warehouse.csv";
    private static final String DAILY_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put("b", new BalanceOperationHandler());
        handlerMap.put("s", new SupplyOperationHandler());
        handlerMap.put("p", new PurchaseOperationHandler());
        handlerMap.put("r", new ReturnOperationHandler());

        FileReaderService readerService = new FileReaderServiceImpl();
        List<String> readData = readerService.read(WAREHOUSE_DATABASE);

        ValidationService validationService = new ValidationServiceImpl();
        List<String> validatedData = validationService.validate(readData);

        ParserService parserService = new ParserServiceImpl();

        for (String line : validatedData) {
            FruitTransaction fruitTransaction = parserService.parse(line);
            OperationHandler operationHandler = handlerMap.get(fruitTransaction
                    .getOperation().getOperationType());
            operationHandler.process(new Fruit(fruitTransaction.getFruitName()),
                    fruitTransaction.getQuantity());
        }

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(Storage.storage);

        FileWriterService writerService = new FileWriterServiceImpl();
        writerService.write(DAILY_REPORT, report);
    }
}
