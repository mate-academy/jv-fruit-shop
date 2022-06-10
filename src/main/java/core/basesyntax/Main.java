package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriteServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";
        FileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        List<String> transactions = fileReaderService.readFromFile(inputFilePath);
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        List<FruitTransaction> fruitTransactions =
                fruitTransactionService.getFruitTransactions(transactions);
        fruitTransactions.forEach(System.out::println);
        System.out.println();
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        List<Fruit> fruits = fruitService.getAll(fruitTransactions);
        FruitDao fruitDao = new FruitDaoImpl();
        fruitDao.addAll(fruits);
        Storage.fruits.forEach(System.out::println);
        System.out.println();
        String fruitsReport = fruitService.getFruitsReport();
        String outputFilePath = "src/main/resources/output.csv";
        FileWriterService fileWriterService = new CsvFileWriteServiceImpl();
        fileWriterService.writeToFile(fruitsReport, outputFilePath);
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
