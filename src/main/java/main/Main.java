package main;

import service.FileReaderService;
import service.FileWriterService;
import service.FruitShopService;
import service.StorageService;
import strategy.OperationStrategy;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/java/resourses/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/java/resourses/output.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();
        StorageService storageService = new StorageService();
        OperationStrategy operationStrategy = new OperationStrategy();
        FileWriterService writerService = new FileWriterService();

        FruitShopService fruitShopService = new FruitShopService(
                fileReaderService,
                operationStrategy,
                writerService,
                storageService
        );

        fruitShopService.processTransactionsAndGenerateReport(INPUT_FILE_PATH, OUTPUT_FILE_PATH);
    }
}
