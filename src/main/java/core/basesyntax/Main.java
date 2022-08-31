package core.basesyntax;

import java.io.File;
import service.FruitShopService;
import service.FruitShopServiceImpl;
import storage.FileReaderService;
import storage.FileReaderServiceImpl;
import storage.FileWriterService;
import storage.FileWriterServiceImpl;
import storage.FruitShopRepo;
import storage.FruitShopRepoImpl;

public class Main {
    public static void main(String[] args) {
        File fileInput = new File("src/main/resources/input.csv");
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        FruitShopRepo fruitShopRepo = new FruitShopRepoImpl(fileReaderService, fileWriterService);
        FruitShopService fruitShopService = new FruitShopServiceImpl(fruitShopRepo);
        File output = fruitShopService.processingData(fileInput);
        System.out.println(output);

    }
}




