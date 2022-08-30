package core.basesyntax;

import java.util.List;
import model.FruitDto;
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
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        FruitShopRepo fruitShopRepo = new FruitShopRepoImpl(fileReaderService, fileWriterService);
        FruitShopService fruitShopService = new FruitShopServiceImpl(fruitShopRepo);
        List<FruitDto> fruitDtoList = fruitShopService.processingData();
        fruitDtoList.forEach(System.out::println);

    }
}




