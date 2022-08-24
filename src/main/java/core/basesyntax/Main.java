package core.basesyntax;

import dao.StorageDao;
import dao.impl.StorageDaoImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import model.FruitTransaction;
import service.FruitTransactionService;
import service.ReaderService;
import service.StringValidatorService;
import service.WriterService;
import service.impl.FruitTransactionServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.StringValidatorServiceImpl;
import service.impl.WriterServiceImpl;

public class Main {
    public static void main(String[] args) {
        final String inputFile = "src/main/resources/input.csv";
        final String firstReport = "src/main/resources/report1.csv";
        final String secondReport = "src/main/resources/report2.csv";
        final String title = "type,fruit,quantity";
        //Test
        //Create file for test
        String[] strings = new String[] {"type,fruit,quantity", "b,banana,20", "b,apple,100",
                "s,banana,100", "p,banana,13", "r,apple,10", "p,apple,20", "p,banana,5",
                "s,banana,50"};
        File file = new File(inputFile);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Cant create file " + file.getName(), e);
        }
        for (String line : strings) {
            try {
                Files.write(file.toPath(), line.getBytes(), StandardOpenOption.APPEND);
                if (!line.equals("s,banana,50")) {
                    Files.write(file.toPath(), System.lineSeparator().getBytes(),
                            StandardOpenOption.APPEND);
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't write to file " + file.getName(), e);
            }
        }
        //Read date from file
        ReaderService readerService = new ReaderServiceImpl();
        List<String> listFromFile = readerService.readFromFile(inputFile);
        //Validate strings and fill in a database
        StorageDao storageDao = new StorageDaoImpl();
        StringValidatorService stringValidatorService = new StringValidatorServiceImpl();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        storageDao.clearDataBase();
        System.out.println("DB before: " + storageDao.getAllTransaction().toString());
        if (stringValidatorService.isStringValid(listFromFile, title)) {
            for (String oneLine : listFromFile) {
                FruitTransaction transaction = fruitTransactionService
                        .createFruitTransaction(oneLine);
                storageDao.addTransaction(transaction);
            }
        }
        System.out.println("DB after: " + System.lineSeparator()
                + storageDao.getAllTransaction().toString());
        //Create report to file from DB
        WriterService writerService = new WriterServiceImpl();
        writerService.createReport(storageDao.getAllTransaction(), firstReport);
        //Return 10 bananas and perches 5 apples
        storageDao.addTransaction(fruitTransactionService.createFruitTransaction("b",
                "banana", 10));
        storageDao.addTransaction(fruitTransactionService.createFruitTransaction("p", "apple", 5));
        //Create new report to new file
        writerService.createReport(storageDao.getAllTransaction(), secondReport);
        System.out.println("DB after changes: " + System.lineSeparator()
                + storageDao.getAllTransaction().toString());
    }
}
