package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.dao.impl.FruitTransactionDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriteServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.QuantityStrategy;
import core.basesyntax.strategy.impl.QuantityStrategyImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";
        FileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        List<FruitTransaction> fruitTransactions =
                fileReaderService.readTransactionsFromFile(inputFilePath);
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
        fruitTransactionDao.addAll(fruitTransactions);
        Storage.fruitTransactions.forEach(System.out::println);
        System.out.println();
        QuantityStrategy quantityStrategy = new QuantityStrategyImpl();
        FruitService fruitService = new FruitServiceImpl(quantityStrategy);
        List<Fruit> fruits = fruitService.getFruitBalance();
        FruitDao fruitDao = new FruitDaoImpl();
        fruitDao.addAll(fruits);
        Storage.fruits.forEach(System.out::println);
        System.out.println();
        String outputFilePath = "src/main/resources/output.csv";
        FileWriterService fileWriterService = new CsvFileWriteServiceImpl();
        fileWriterService.writeBalanceToFile(outputFilePath);
        String result = readFromFile("src/main/resources/output.csv");
        System.out.println(result);
    }

    private static String readFromFile(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read data from file: " + filePath, e);
        }
    }
}
