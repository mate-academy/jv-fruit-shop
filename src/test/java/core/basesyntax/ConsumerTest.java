package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Storage;
import core.basesyntax.service.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;


public class ConsumerTest {
    private static final String INTO_PATH = "storageContent.csv";
    private static final String FOURTH_PATH = "src/fruitsTest4.csv";

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
    public void consumerNSETest() {
        try {
            ReadOperationFromFileService readOperationFromFileService
                    = new ReadOperationFromFileService();
            readOperationFromFileService.read(FOURTH_PATH);
            Assert.fail("We had to get an exception");
        } catch (NoSuchElementException e) {
            String errMsg = "Not enough fruits in storage";
            assertEquals(errMsg, e.getMessage());
        }
    }

    @Test
    public void consumerNPETest() {
        try {
            ReadOperationFromFileService readOperationFromFileService
                    = new ReadOperationFromFileService();
            readOperationFromFileService.read("");

            StorageContent storageService = new StorageContent<>();
            String storageContent = storageService.getStorage();

            Assert.fail("We had to get an exception");
        } catch (RuntimeException e) {
            String errMsg = "Wrong path";
            assertEquals(errMsg, e.getMessage());
        }
    }
}
