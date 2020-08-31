package core.basesyntax;

import core.basesyntax.model.Storage;
import core.basesyntax.service.ReadOperationFromFileService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ReadFromFileTest {
    private static final String INTO_PATH = "storageContent.csv";
    private static final String WRONG_PATH = "src/wrongTest.csv";

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
    public void readFromFileExceptionTest() {
        try {
            ReadOperationFromFileService readOperationFromFileService
                    = new ReadOperationFromFileService();
            readOperationFromFileService.read("");
            Assert.fail("We had to get an exception here");
        } catch (RuntimeException e) {
            String errMsg = "Wrong path";
            assertEquals(errMsg, e.getMessage());
        }
    }
}
