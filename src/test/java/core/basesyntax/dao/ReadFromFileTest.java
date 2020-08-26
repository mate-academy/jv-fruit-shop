package core.basesyntax.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFromFileTest {
    private String fileDest = "src\\test\\resources\\ReadFromFile.csv";
    private static final String TEST_STRING = "1 2 3 4 5 6 a b c D F G ! # $ % ^ ^";

    @Before
    public void setUp() {
        WriteToFile write = new WriteToFile();
        write.writeToFile(fileDest);

    }

    @Test
    public void readFromFileOk() {
        Path path = Paths.get(fileDest);
        String read = null;
        try {
            read = Files.readAllLines(path).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(TEST_STRING, read);
    }
}