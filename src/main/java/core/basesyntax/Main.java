package core.basesyntax;

import dao.StorageDao;
import dao.StorageDaoImpl;
import model.FruitTransaction;
import service.FruitTransactionService;
import service.FruitTransactionServiceImpl;
import service.InputOutputDataService;
import service.InputOutputDataServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        //Test
        //Create file for test
        String[] strings = new String[] {"type,fruit,quantity", "b,banana,20", "b,apple,100",
                "s,banana,100", "p,banana,13", "r,apple,10", "p,apple,20", "p,banana,5",
                "s,banana,50"};
        File file = new File("input.csv");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Cant create file " + file.getName(), e);
        }
        for (String line : strings) {
            try {
                Files.write(file.toPath(), line.getBytes(), StandardOpenOption.APPEND);
                if (!line.equals("s,banana,50")) {
                    Files.write(file.toPath(), System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't write to file " + file.getName(), e);
            }
        }
        //Read date from file to DB
        System.out.println("Write to database from file:");
        StorageDao storageDao = new StorageDaoImpl();
        System.out.println("DB before: " + storageDao.getAllTransaction().toString());
        InputOutputDataService inputOutputDataService = new InputOutputDataServiceImpl();
        inputOutputDataService.readDataFromFile("input.csv");
        System.out.println("DB after: " + System.lineSeparator()
                + storageDao.getAllTransaction().toString());
        //Create report to file from DB
        inputOutputDataService.createReportInFile("reportOne.csv");
        //Return 10 bananas and perches 5 apples
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        FruitTransaction transaction1 = fruitTransactionService
                .createFruitTransaction("r,banana,10");
        fruitTransactionService.doTransaction(transaction1);
        FruitTransaction transaction2 = fruitTransactionService
                .createFruitTransaction("p", "apple", 5);
        fruitTransactionService.doTransaction(transaction2);
        System.out.println(System.lineSeparator()
                + "DB after adding 10 bananas and subtraction 5 apples: " + System.lineSeparator()
                + storageDao.getAllTransaction().toString());
        //Create new report to file from DB
        inputOutputDataService.createReportInFile("retortTwo.csv");








    }
}
