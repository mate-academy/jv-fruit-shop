import core.basesyntax.model.FruitBox;
import core.basesyntax.service.ReadOperationFromFileService;
import core.basesyntax.service.StorageContent;
import core.basesyntax.service.WriteIntoFileService;

public class Main {
    public static void main(String[] args) {
        ReadOperationFromFileService readOperationFromFileService
                = new ReadOperationFromFileService();
        readOperationFromFileService.read("src/fruitsTest.csv");

        StorageContent<FruitBox> storageService = new StorageContent<>();
        String storageContent = storageService.getStorage();

        WriteIntoFileService writeIntoFileService = new WriteIntoFileService();
        writeIntoFileService.write(storageContent);
    }
}
