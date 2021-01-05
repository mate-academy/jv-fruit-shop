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
    private String filePath = "src/test/java/core/basesyntax/shopimpl/service/Test.csv";
    private IOdataFileService testObject = new IOdataFileService(filePath);
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
            List<String> allLines = Files.readAllLines(Path.of(filePath));
            String actual = String.join("\n\r", allLines);
            assertEquals(expected, actual);
        } catch (IOException e) {
            throw new RuntimeException("test reading has failed", e);
        }
    }
    
    @Test
    public void readDataFile() {
        testObject = new IOdataFileService(filePath);
    
        List<DataRecord> actual = testObject.readDataFile();
        List<DataRecord> expected = list;
    
        assertEquals(expected, actual);
    }
    
    @Test void readDataFileInvalidData() {
    
    }
}
