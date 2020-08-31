import core.basesyntax.model.FruitBox;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.ReadOperationFromFileService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.WriteIntoFileService;

public class Main {
    public static void main(String[] args) {
        ReadOperationFromFileService readOperationFromFileService
                = new ReadOperationFromFileService();
        readOperationFromFileService.read("src/fruitsTest.csv");

        StorageService<FruitBox> storageService = new StorageService<>();
        String storageContent = storageService.getStorage();

        WriteIntoFileService writeIntoFileService = new WriteIntoFileService();
        writeIntoFileService.write(storageContent);

        ReadFromFileService readFromFileService = new ReadFromFileService();
        readFromFileService.readFromFile("storageContent.csv");
    }
}
