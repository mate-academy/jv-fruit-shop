package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Storage;
import core.basesyntax.model.FruitBox;
import core.basesyntax.service.*;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


public class FruitStoreTest {
    private static final String FIRST_PATH
            = "C:\\Users\\mosko\\IdeaProjects\\jv-fruit-shop\\src\\fruitsTest.csv";
    private static final String SECOND_PATH
            = "C:\\Users\\mosko\\IdeaProjects\\jv-fruit-shop\\storageContent.csv";
    private static final String SECOND_PATH2
            = "C:\\Users\\mosko\\IdeaProjects\\jv-fruit-shop\\src\\fruitsTest2.csv";

    @Before
    public void setup() {
        try {
            FileWriter fileWriter = new FileWriter(SECOND_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Storage.storage.clear();
    }

    @Test
    public void storageTest() {
        ReadOperationFromFileService readFromFileService = new ReadOperationFromFileService();
        readFromFileService.read(FIRST_PATH);
        StorageService storageService = new StorageService();
        assertEquals("banana,95", storageService.getStorage());
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
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(SECOND_PATH))) {
            currentString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("banana,95", currentString);
    }

    @Test
    public void supplierTest() {
        ReadOperationFromFileService readFromFileService = new ReadOperationFromFileService();
        readFromFileService.read(SECOND_PATH2);

        StorageService<FruitBox> storageService = new StorageService<>();
        String storageContent = storageService.getStorage();

        assertEquals("banana,5", storageContent);
    }

    @Test
    public void outputResultTest() {
        ReadOperationFromFileService readOperationFromFileService = new ReadOperationFromFileService();
        readOperationFromFileService.read(FIRST_PATH);

        StorageService<FruitBox> storageService = new StorageService<>();
        String storageContent = storageService.getStorage();

        WriteIntoFileService writeIntoFileService = new WriteIntoFileService();
        writeIntoFileService.write(storageContent);

        OutputResultFileService OutputResultFileService = new OutputResultFileService();
        String actualResult = OutputResultFileService.sout();

        assertEquals("banana,95", storageContent);
    }
}
