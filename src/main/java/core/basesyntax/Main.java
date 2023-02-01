package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReportsServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import java.util.List;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/database.csv";
    public static final String OUTPUT_FILE = "src/main/resources/result.csv";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        FruitShopService storageService = new FruitShopServiceImpl();
        ReportService reportService = new ReportsServiceImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        List<String> dateFromFile = fileService.readFromFile(INPUT_FILE);
        List<FruitTransaction> fruitTransactions = transactionParser.parseInputDate(dateFromFile);
        storageService.process(fruitTransactions);
        String report = reportService.createReport();
        fileService.writeToFile(OUTPUT_FILE, report);
    }
}
