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

import java.io.*;

public class OutputTest {
    private static final String INTO_PATH = "storageContent.csv";
    private static final String FIRST_PATH = "src/fruitsTest.csv";

    private String readFromFile(String filePath) {
        StringBuilder resultBuilder = new StringBuilder();
        try (BufferedReader resultReader
                     = new BufferedReader(new FileReader(filePath))) {
            while (resultReader.readLine() != null) {
                resultBuilder.append(resultReader.readLine()).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Wrong path");
        }
        return resultBuilder.toString();
    }

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
    public void outputResultTest() {
        try {
            ReadOperationFromFileService readOperationFromFileService
                    = new ReadOperationFromFileService();
            readOperationFromFileService.read(FIRST_PATH);

            StorageService<FruitBox> storageService = new StorageService<>();
            String storageContent = storageService.getStorage();

            WriteIntoFileService writeIntoFileService = new WriteIntoFileService();
            writeIntoFileService.write(storageContent);

            readFromFile("");
            Assert.fail("We had to get an exception here");
        } catch (RuntimeException e) {
            String errMsg = "Wrong path";
            assertEquals(errMsg, e.getMessage());
        }
    }
}
