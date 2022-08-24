package service;

import dao.StorageDao;
import dao.StorageDaoImpl;
import model.FruitTransaction;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class InputOutputDataServiceImpl implements InputOutputDataService {
    private static final int LINES_IN_REPORT = 3;
    private static final int TITLE = 0;
    private static final int BANANA = 1;
    private static final int APPLE = 2;
    private static final String TITLE_FOR_REPORT = "fruit,quantity";
    FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
    StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void readDataFromFile(String fileName) {
        File file = new File(fileName);
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        for (String stringFromFile : dataFromFile) {
            storageDao.putTransfer(fruitTransactionService.createFruitTransaction(stringFromFile));
        }
    }

    @Override
    public void createReportInFile(String fileName) {
        Stream<FruitTransaction> fruits = storageDao.getAllTransaction().stream()
                .map(f -> {
                    if (f.getOperation() == FruitTransaction.Operation.RETURN) {
                        f.setQuantity(f.getQuantity() * (-1));
                    }
                    return f;
                });
        int amountOfBananas = fruits
                .filter(f -> f.getFruit() == "banana")
                .mapToInt(FruitTransaction::getQuantity)
                .sum();
        int amountOfApples = fruits
                .filter(f -> f.getFruit() == "apple")
                .mapToInt(FruitTransaction::getQuantity)
                .sum();
        String[] report = new String[LINES_IN_REPORT];
        report[TITLE] = TITLE_FOR_REPORT;
        report[BANANA] = new StringBuilder().append("banana,").append(amountOfBananas).toString();
        report[APPLE] = new StringBuilder().append("apple,").append(amountOfApples).toString();
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        }
        for (String oneLine : report) {
            try {
                Files.write(file.toPath(), oneLine.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file", e);
            }
        }
    }
}
