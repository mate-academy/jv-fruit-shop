package core.basesyntax.shopimpl.service;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class IOdataFileServiceTest {
    private static final IOdataFileService fileService = new IOdataFileService();
    private String reportFile = "src/test/resources/report.csv";
    private String filePathValid
            = "src/test/resources/TestValid.csv";
    private String filePathInvalid
            = "src/test/resources/TestInvalid.csv";
    private String filePathInvalid2
            = "src/test/resources/TestInvalid2.csv";
    private List<DataRecord> expectedValid =
            List.of(new DataRecord(ShopTransactionsType.BALANCE, new Fruit("Fruit"), 100),
                    new DataRecord(ShopTransactionsType.BALANCE, new Fruit("Fruit"), 100),
                    new DataRecord(ShopTransactionsType.BALANCE, new Fruit("Fruit"), 100));
    
    @Test
    public void writeDataFile() {
        Map<AbstractItem, Integer> storage = new HashMap<>();
        storage.put(new Fruit("Fruit1"), 100);
        storage.put(new Fruit("Fruit2"), 100);
        storage.put(new Fruit("Fruit3"), 100);
        fileService.writeReport(reportFile, storage);
        
        List<String> expected = List.of("Item,Amount"
                , "Fruit1,100"
                , "Fruit2,100"
                , "Fruit3,100");
        try {
            List<String> actual = Files.readAllLines(Path.of(reportFile));
            assertEquals(expected, actual);
        } catch (IOException e) {
            throw new RuntimeException("test reading has failed", e);
        }
    }
    
    @Test
    public void readDataFileValidInput() {
        List<String> actual = fileService.readFile(filePathValid);
        List<String> expected = List.of("ShopAction,Item,Amount",
                "b,Fruit,100",
                "b,Fruit,100",
                "b,Fruit,100");
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void parseDataFileInvalidData() {
        List<String> lines = fileService.readFile(filePathInvalid);
        List<DataRecord> records = fileService.parseAll(lines);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void readDataFileNegativeValue() {
        List<String> lines = fileService.readFile(filePathInvalid2);
        List<DataRecord> records = fileService.parseAll(lines);
    }
    
    @Test
    public void readDataFileValidData() {
        List<String> lines = fileService.readFile(filePathValid);
        List<DataRecord> actual = fileService.parseAll(lines);
        assertEquals(expectedValid, actual);
    }
}
