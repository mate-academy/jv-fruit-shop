package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ConvertWriteDataService;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.impl.ConvertWriteDataServiceImpl;
import core.basesyntax.service.impl.FileReadServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;

import java.util.List;

public class FruitShop {

    private static final String STORAGE_FILE_NAME = "src/main/resources/storage.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader reader = new FileReadServiceImpl();
        List<String> dataFromFile = reader.readData(STORAGE_FILE_NAME);
        List<Transaction> transactions = new TransactionParserImpl()
                .getTransactions(dataFromFile);
        FruitShopService fruitShopService = new FruitShopServiceImpl(new OperationStrategyImpl());
        fruitShopService.runTransaction(transactions);
        ConvertWriteDataService convertWriteDataService = new ConvertWriteDataServiceImpl();
        String report
                = convertWriteDataService.getReport();
        FileWriter fileWriteService = new FileWriteServiceImpl();
        fileWriteService.writeData(report, REPORT_FILE_NAME);
    }
}
