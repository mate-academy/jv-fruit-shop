package core.basesyntax.shopimpl.service;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.Test;

public class IOdataFileServiceTest {
    private String filePathValid = "src/test/java/core/basesyntax/shopimpl/service/TestValid.csv";
    private String filePathInvalid = "src/test/java/core/basesyntax/shopimpl/service/TestInvalid.csv";
    private String filePathInvalid2 = "src/test/java/core/basesyntax/shopimpl/service/TestInvalid2.csv";
    private IOdataFileService testObject = new IOdataFileService(filePathValid);
    private List<DataRecord> list =
            List.of(new DataRecord(ShopTransactionsTypes.BALANCE, new Fruit("Fruit"), 100),
            new DataRecord(ShopTransactionsTypes.BALANCE, new Fruit("Fruit"), 100),
            new DataRecord(ShopTransactionsTypes.BALANCE, new Fruit("Fruit"), 100));
    
    @Test
    public void writeDataFile() {
        testObject.writeDataFile(list);
    
        String expected = "ShopAction,Item,Amount\n\r"
                          + "b,Fruit,100\n\r"
                          + "b,Fruit,100\n\r"
                          + "b,Fruit,100";
        try {
            List<String> allLines = Files.readAllLines(Path.of(filePathValid));
            String actual = String.join("\n\r", allLines);
            assertEquals(expected, actual);
        } catch (IOException e) {
            throw new RuntimeException("test reading has failed", e);
        }
    }
    
    @Test
    public void readDataFile() {
        testObject = new IOdataFileService(filePathValid);
    
        List<DataRecord> actual = testObject.readDataFile();
        List<DataRecord> expected = list;
    
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void readDataFileInvalidData() {
        testObject = new IOdataFileService(filePathInvalid);
        List<DataRecord> actual = testObject.readDataFile();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void readDataFileNegativeValue() {
        testObject = new IOdataFileService(filePathInvalid2);
        List<DataRecord> actual = testObject.readDataFile();
    }
}
