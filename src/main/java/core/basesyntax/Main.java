package core.basesyntax;

import core.db.FruitTransaction;
import core.db.StorageServiceImpl;
import core.service.FruitService;
import core.service.impl.CsvFileReaderServiceImpl;
import core.service.impl.FileWriterServiceImpl;
import core.service.impl.FruitServiceImpl;
import core.service.impl.TransactionServiceImpl;
import java.io.File;
import java.util.List;

public class Main {
    private static final String PATH_DB = "src/resources/transactions.txt";
    private static final String PATH_REPORT = "src/resources/report.txt";

    public static void main(String[] args) {
        List<String> listTransaction = new CsvFileReaderServiceImpl().read(new File(PATH_DB));
        List<FruitTransaction> transactions = new TransactionServiceImpl()
                .createFromList(listTransaction);
        StorageServiceImpl storageService = new StorageServiceImpl();
        storageService.setAll(transactions);

        FruitService fruitService = new FruitServiceImpl();
        String balance = fruitService.getBalanceReport(storageService.getAll());
        new FileWriterServiceImpl().write(new File(PATH_REPORT), balance);
    }
}
