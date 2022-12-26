package core.basesyntax;

import core.basesyntax.dao.TransactionParser;
import core.basesyntax.dao.TransactionParserImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import java.util.List;

public class Main {
    private static final String FILE_FROM_NAME = "src/main/resources/FruitShopInfo.csv";
    private static final String FILE_TO_NAME = "src/main/resources/FruitShopReport.csv";

    public static void main(String[] args) {
        TransactionParser transactionParser = new TransactionParserImpl();
        ShopService shopService = new ShopServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        FileService fileService = new FileServiceImpl();
        String dataFromFile = fileService.readFromFile(FILE_FROM_NAME);
        List<FruitTransaction> fruitTransactionList =
                transactionParser.parseTransactions(dataFromFile);
        for (FruitTransaction fruit : fruitTransactionList) {
            shopService.makeTransaction(fruit);
        }
        String report = reportService.createReport();
        fileService.writeToFile(FILE_TO_NAME, report);
    }
}
