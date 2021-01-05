package core.basesyntax.shopimpl.service;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.Test;

public class IOdataFileServiceTest {
    private String filePathValid
            = "src/test/resources/TestValid.csv";
    private String filePathInvalid
            = "src/test/resources/TestInvalid.csv";
    private String filePathInvalid2
            = "src/test/resources/TestInvalid2.csv";
    private List<DataRecord> list =
            List.of(new DataRecord(ShopTransactionsType.BALANCE, new Fruit("Fruit"), 100),
                    new DataRecord(ShopTransactionsType.BALANCE, new Fruit("Fruit"), 100),
                    new DataRecord(ShopTransactionsType.BALANCE, new Fruit("Fruit"), 100));
    
    @Test
    public void writeDataFile() {
        IOdataFileService.writeDataFile(filePathValid, list);
        
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
        List<DataRecord> actual = IOdataFileService.readDataFile(filePathValid);
        List<DataRecord> expected = list;
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void readDataFileInvalidData() {
        List<DataRecord> actual = IOdataFileService.readDataFile(filePathInvalid);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void readDataFileNegativeValue() {
        List<DataRecord> actual = IOdataFileService.readDataFile(filePathInvalid2);
    }
}
