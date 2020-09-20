package core.basesyntax;

import core.parser.FileServiceImpl;
import core.parser.FruitDto;
import core.storage.FruitOperations;
import core.storage.StorageService;

import java.util.List;

public class Application {

    public void applicate(String fullPath) {
        FruitDto fruitDto = new FruitDto();
        FileServiceImpl fileService = new FileServiceImpl();
        List<String> text = fileService.readFile(fullPath);
        StorageService storageService = fruitDto.operateStorage(text);
        String path = "src/test/resources/fruitOut.csv";
        fruitDto.storageOut(storageService, path);
    }
}
