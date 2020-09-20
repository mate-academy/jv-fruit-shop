package core.parser;

import core.storage.FruitOperationsImpl;
import core.storage.FruitPackageDTO;
import core.storage.StorageService;
import java.time.LocalDate;
import java.util.List;

public class FruitDto {
    String defaultSeparator = ",";


    public void applicate(String fullPath) {
        FileServiceImpl fileService = new FileServiceImpl();
        List<String> text = fileService.readFile(fullPath);
        StorageService storageService = operateStorage(text);
        String path = "src/test/resources/fruitOut.csv";
        storageOut(storageService, path);
    }

    public StorageService operateStorage(List<String> text) {
        StorageService storageService = new StorageService();
        FruitOperationsImpl fruitOperations = new FruitOperationsImpl();
        for (String line : text) {
            String[] info = line.split(defaultSeparator);
            String fruitOperator = info[0];
            String fruitType = info[1];
            int quantity = Integer.parseInt(info[2]);
            LocalDate expDate = LocalDate.parse(info[3]);
            FruitPackageDTO fruitPackageDTO = new FruitPackageDTO(fruitType, expDate);
            try {
                fruitOperations.apply(fruitPackageDTO, quantity, fruitOperator);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return storageService;
    }

    public boolean storageOut(StorageService storageService, String path) {
        FileServiceImpl fileService = new FileServiceImpl();
        fileService.writeFile(storageService.getRemainingFruit(), path);
        return true;
    }
}
