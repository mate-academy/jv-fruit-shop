package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportGenerationService;
import core.basesyntax.service.SaveToStorageService;
import core.basesyntax.service.implemantation.FileServiceImpl;
import core.basesyntax.service.implemantation.ReportGenerationServiceImpl;
import core.basesyntax.service.implemantation.SaveToStorageImpl;
import core.basesyntax.service.strategy.TransactionBalance;
import core.basesyntax.service.strategy.TransactionHandler;
import core.basesyntax.service.strategy.TransactionReturn;
import core.basesyntax.service.strategy.TransactionSell;
import core.basesyntax.service.strategy.TransactionStrategy;
import core.basesyntax.service.strategy.TransactionStrategyImpl;
import core.basesyntax.service.strategy.TransactionSupply;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String BALANCE = "b";
    public static final String PURCHASE = "p";
    public static final String RETURN = "r";
    public static final String SUPPLY = "s";
    public static final String PATH_TO_THE_FRUIT_TRANSACTIONS_FILE
            = "src/main/resources/fruits.csv";
    public static final String FILE_REPORT_DESTINATION = "src/main/resources/report.txt";

    public static void main(String[] args) {
        Map<String, TransactionHandler> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put(BALANCE, new TransactionBalance());
        transactionHandlerMap.put(PURCHASE, new TransactionSell());
        transactionHandlerMap.put(RETURN, new TransactionReturn());
        transactionHandlerMap.put(SUPPLY, new TransactionSupply());

        FileService fileService = new FileServiceImpl();
        List<String> linesFromFile = fileService
                .readFromFile(Path.of(PATH_TO_THE_FRUIT_TRANSACTIONS_FILE));
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(
                transactionHandlerMap);
        SaveToStorageService saveToStorageService = new SaveToStorageImpl(transactionStrategy);
        saveToStorageService.storeAll(linesFromFile);
        ReportGenerationService reportGenerationService = new ReportGenerationServiceImpl();
        String report = reportGenerationService.generateReport(Storage.storage);
        Path path = Paths.get(FILE_REPORT_DESTINATION);
        fileService.writeToFile(report, path);

    }
}
