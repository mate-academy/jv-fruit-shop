package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Storage;
import core.basesyntax.model.FruitBox;
import core.basesyntax.service.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;


public class FruitStoreTest {
    private static final String INTO_PATH = "storageContent.csv";
    private static final String FIRST_PATH = "src/fruitsTest.csv";
    private static final String SECOND_PATH = "src/fruitsTest2.csv";
    private static final String THIRD_PATH = "src/fruitsTest3.csv";
    private static final String FOURTH_PATH = "src/fruitsTest4.csv";
    private static final String FIFTH_PATH = "src/fruitsTest5.csv";
    private static final String WRONG_PATH = "src/wrongTest.csv";
    private static final String WRONG_DATE_PATH = "src/wrongDateTest.csv";
    private static final String EXPIRED_DATE_PATH = "src/expiredFruitsReturn.csv";
    private static final String LAST_TEST_PATH = "src/lastTest.csv";

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
    public void lastTest() {
        try {
            ReadOperationFromFileService readOperationFromFileService
                    = new ReadOperationFromFileService();
            readOperationFromFileService.read(LAST_TEST_PATH);

            StorageService<FruitBox> storageService = new StorageService<>();
            String storageContent = storageService.getStorage();

            assertEquals("banana,500", storageContent);

            WriteIntoFileService writeIntoFileService = new WriteIntoFileService();
            writeIntoFileService.write(storageContent);

            ReadFromFileService readFromFileService = new ReadFromFileService();
            readFromFileService.readFromFile(readFromFileService.getLocalPath());
        } catch (RuntimeException e) {

        }
    }



    @Test
    public void dataParseExceptionTest() {
        try {
            ReadOperationFromFileService readFromFileService
                    = new ReadOperationFromFileService();
            readFromFileService.read(WRONG_DATE_PATH);

            Assert.fail("We had to get an exception");
        } catch (DateTimeParseException e) {
            String errMsg = "Text '20-10-2020' could not be parsed at index 0";
            assertEquals(errMsg, e.getMessage());
        }
    }

    @Test
    public void storageTest() {
        ReadOperationFromFileService readFromFileService = new ReadOperationFromFileService();
        readFromFileService.read(FIRST_PATH);
        StorageService storageService = new StorageService();
        assertEquals("banana,95\n", storageService.getStorage());
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

            StorageService storageService = new StorageService<>();
            String storageContent = storageService.getStorage();

            Assert.fail("We had to get an exception");
        } catch (RuntimeException e) {
            String errMsg = "Wrong path";
            assertEquals(errMsg, e.getMessage());
        }
    }

    @Test
    public void resultFileServiceExceptionTest() {
        try {
            ReadOperationFromFileService readOperationFromFileService
                    = new ReadOperationFromFileService();
            readOperationFromFileService.read(FIFTH_PATH);

            StorageService storageService = new StorageService<>();
            String storageContent = storageService.getStorage();
            Assert.fail("We had to get an exception");
        } catch (NullPointerException e) {
            String errMsg = "No fruits in storage";
            assertEquals(errMsg, e.getMessage());
        }
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

    @Test
    public void readFromFileExceptionTest2() {
        try {
            ReadOperationFromFileService readFromFileService
                    = new ReadOperationFromFileService();
            readFromFileService.read(WRONG_PATH);

            Assert.fail("We had to get an exception");
        } catch (IllegalArgumentException e) {
            String errMsg = "Wrong operation";
            assertEquals(errMsg, e.getMessage());
        }
    }

    @Test
    public void storageOutputTest() {
        ReadOperationFromFileService readOperationFromFileService
                = new ReadOperationFromFileService();
        readOperationFromFileService.read(FIRST_PATH);

        StorageService<FruitBox> storageService = new StorageService<>();
        String storageContent = storageService.getStorage();

        assertEquals("banana,95\n", storageContent);
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

            ReadFromFileService readFromFileService = new ReadFromFileService();
            readFromFileService.readFromFile("");
            Assert.fail("We had to get an exception here");
        } catch (RuntimeException e) {
            String errMsg = "Wrong path";
            assertEquals(errMsg, e.getMessage());
        }
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
    public void expiredDateTest() {
        try {
            ReadOperationFromFileService readOperationFromFileService
                    = new ReadOperationFromFileService();
            readOperationFromFileService.read(EXPIRED_DATE_PATH);
            Assert.fail("We had to get an exception here");
        } catch (RuntimeException e) {
            String errMsg = "We can not accept this fruits!";
            assertEquals(errMsg, e.getMessage());
        }
    }
}
