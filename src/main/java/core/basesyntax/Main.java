package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataSplitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataSplitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.StorageService;
import core.basesyntax.strategy.StorageStrategy;

import java.util.List;

public class Main {
    public static final String READ_FROM_FILE = "src/main/resources/data.csv";
    public static final String WRITE_TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        DataSplitService dataSplit = new DataSplitServiceImpl();
        WriterService writer = new WriterServiceImpl();
        StorageStrategy strategy = new StorageStrategy();
        StorageService storageService;

        String readData = reader.read(READ_FROM_FILE);
        List<FruitTransaction> transactions = dataSplit.splitData(readData);
        for (FruitTransaction transaction : transactions) {
            storageService = strategy.getStorageService(transaction);
            storageService.updateStorage(transaction);
        }
        writer.writeDataToFile(WRITE_TO_FILE);
    }
}
