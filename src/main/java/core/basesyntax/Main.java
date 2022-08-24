package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.FruitShopService;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFile = "transactions.csv";
        String targetFile = "report.csv";
        FileReader fileReader = new CsvFileReader();
        List<String> inputData = fileReader.readFile(inputFile);
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> transactions = transactionParser.getTransactions(inputData);
        ShopService shopService = new FruitShopService();
        Map<String, Integer> endBalances = shopService.getEndBalance(transactions);
        StorageDao storageDao = new StorageDaoImpl();
        storageDao.saveAll(endBalances);
        endBalances = storageDao.getAll();
        ReportCreator reportCreator = new ReportCreatorImpl();
        List<String> report = reportCreator.createReport(endBalances);
        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.writeReport(targetFile, report);
    }
}
