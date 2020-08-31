package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import core.basesyntax.service.ReadOperationFromFileService;
import core.basesyntax.service.StorageService;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SupplierTest {
    private static final String INTO_PATH = "storageContent.csv";
    private static final String SECOND_PATH = "src/fruitsTest2.csv";
    private static final String THIRD_PATH = "src/fruitsTest3.csv";

    @Before
    public void setup() {
        try {
            FileWriter fileWriter = new FileWriter(INTO_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Storage.storage.clear();
    }

    @Test
    public void supplierTest() {
        ReadOperationFromFileService readOperationFromFileService
                = new ReadOperationFromFileService();
        readOperationFromFileService.read(SECOND_PATH);

        StorageService<FruitBox> storageService = new StorageService<>();
        String storageContent = storageService.getStorage();

        assertEquals("banana,5\n", storageContent);
        Storage.storage.clear();

        readOperationFromFileService = new ReadOperationFromFileService();
        readOperationFromFileService.read(THIRD_PATH);

        storageService = new StorageService<>();
        storageContent = storageService.getStorage();

        assertEquals("banana,90\n", storageContent);
    }
}
