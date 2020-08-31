package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import core.basesyntax.service.ReadOperationFromFileService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.WriteIntoFileService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class WriteIntoFileTest {
    private static final String INTO_PATH = "storageContent.csv";
    private static final String FIRST_PATH = "src/fruitsTest.csv";

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
    public void writeIntoFileExceptionTest() {
        final String localPath = "";
        try {
            ReadOperationFromFileService readOperationFromFileService
                    = new ReadOperationFromFileService();
            readOperationFromFileService.read(FIRST_PATH);

            StorageService<FruitBox> storageService = new StorageService<>();
            String storageContent = storageService.getStorage();

            WriteIntoFileService writeIntoFileService = new WriteIntoFileService();
            writeIntoFileService.setFilePath(localPath);
            writeIntoFileService.write(storageContent);
            Assert.fail("We had to get an exception");
        } catch (RuntimeException e) {
            String errMsg = "Wrong path";
            assertEquals(errMsg, e.getMessage());
        }
    }

    @Test
    public void writeIntoFileTest() {
        ReadOperationFromFileService readFromFileService = new ReadOperationFromFileService();
        readFromFileService.read(FIRST_PATH);

        StorageService<FruitBox> storageService = new StorageService<>();
        String storageContent = storageService.getStorage();

        WriteIntoFileService writeIntoFileService = new WriteIntoFileService();
        writeIntoFileService.write(storageContent);

        String currentString = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INTO_PATH))) {
            currentString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("banana,95", currentString);
    }
}
