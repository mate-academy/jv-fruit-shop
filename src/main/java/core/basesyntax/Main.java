package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.BalanceOperationService;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.PurchaseOperationService;
import core.basesyntax.strategy.ReturnOperationService;
import core.basesyntax.strategy.SupplyOperationService;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/database.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationService> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationService(storageDao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationService(storageDao));
        handlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationService(storageDao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationService(storageDao));

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> data = fileReaderService.read(Path.of(INPUT_FILE_PATH));

        ParserService parserDataService = new ParserServiceImpl();
        List<FruitTransaction> parsedData = parserDataService.parse(data);

        for (FruitTransaction transaction : parsedData) {
            handlerMap.get(transaction.getOperation()).process(transaction);
        }

        ReportService reportGeneratorService = new ReportServiceImpl(storageDao);
        String report = reportGeneratorService.report();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(Path.of(REPORT_FILE_PATH), report);
    }
}
