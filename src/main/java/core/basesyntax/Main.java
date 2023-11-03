package core.basesyntax;

import core.basesyntax.model.FruitTransactions;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.FoodStoreService;
import core.basesyntax.service.FoodStoreServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/allData.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";
    private static final FoodStoreService foodStoreService = new FoodStoreServiceImpl();
    private static final FileService fileService = new FileServiceImpl();
    private static final TransactionParser transactionParser = new TransactionParserImpl();
    private static final ReportService reportService = new ReportServiceImpl();

    public static void main(String[] args) {
        List<String> dailyData = fileService.read(INPUT_FILE_NAME);
        List<FruitTransactions> fruitTransactions = transactionParser.parseTransactions(dailyData);
        foodStoreService.proccessOperaton(fruitTransactions);
        List<String> report = reportService.createReport();
        fileService.write(report,OUTPUT_FILE_NAME);
    }
}
