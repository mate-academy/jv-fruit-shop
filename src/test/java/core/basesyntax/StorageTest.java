package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import core.basesyntax.service.ReadOperationFromFileService;
import core.basesyntax.service.StorageContent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StorageTest {
    private static final String INTO_PATH = "storageContent.csv";
    private static final String FIRST_PATH = "src/fruitsTest.csv";
    private static final String FIFTH_PATH = "src/fruitsTest5.csv";


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
    public void storageOutputTest() {
        ReadOperationFromFileService readOperationFromFileService
                = new ReadOperationFromFileService();
        readOperationFromFileService.read(FIRST_PATH);

        StorageContent<FruitBox> storageService = new StorageContent<>();
        String storageContent = storageService.getStorage();

        assertEquals("banana,95\n", storageContent);
    }

    @Test
    public void noFruitsExceptionTest() {
        try {
            ReadOperationFromFileService readOperationFromFileService
                    = new ReadOperationFromFileService();
            readOperationFromFileService.read(FIFTH_PATH);

            StorageContent storageService = new StorageContent<>();
            storageService.getStorage();
            Assert.fail("We had to get an exception");
        } catch (NullPointerException e) {
            String errMsg = "No fruits in storage";
            assertEquals(errMsg, e.getMessage());
        }
    }

    @Test
    public void storageTest() {
        ReadOperationFromFileService readFromFileService = new ReadOperationFromFileService();
        readFromFileService.read(FIRST_PATH);
        StorageContent storageService = new StorageContent();
        assertEquals("banana,95\n", storageService.getStorage());
    }
}
