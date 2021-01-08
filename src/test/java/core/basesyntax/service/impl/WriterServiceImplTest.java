package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriterServiceImplTest {
    private static final String TEST_DESTINATION_FILE =
            "src\\test\\resource\\testDestinationFile.csv";
    private static WriterService writerService;
    private static List<String> myTestList;

    @Before
    public void setUp() {
        writerService = new WriterServiceImpl();
        myTestList = new ArrayList<>();
    }

    @After
    public void cleanDestinationFile() {
        try {
            FileWriter fr = new FileWriter(TEST_DESTINATION_FILE, false);
        } catch (IOException e) {
            throw new RuntimeException("Can't clean tested file", e);
        }
    }

    @Test
    public void validData() {
        List<String> myTestList = new ArrayList<>();
        myTestList.add("b,orange,15");
        writerService.writeToFile(myTestList, TEST_DESTINATION_FILE);
        String line = new String();
        try (BufferedReader br = new BufferedReader(
                new FileReader(new File(TEST_DESTINATION_FILE)))) {
            line = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("File can't be read!", e);
        }
        String expected = "b,orange,15";
        String actual = line;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkCreatingFile() {
        myTestList.add("b,orange,15");
        writerService.writeToFile(myTestList, TEST_DESTINATION_FILE);
        File testFile = new File(TEST_DESTINATION_FILE);
        Assert.assertTrue(testFile.isFile());
        Assert.assertTrue(testFile.canRead());
        Assert.assertEquals(testFile.getPath(), TEST_DESTINATION_FILE);
    }

    @Test
    public void invalidData() {
        List<String> myTestList = new ArrayList<>();
        myTestList.add("orange, 15");
        myTestList.add("lemon, 5");
        writerService.writeToFile(myTestList, "src\\test\\resource\\testDestinationFile.csv");
        File testFile = new File(TEST_DESTINATION_FILE);
        Assert.assertTrue(testFile.isFile());
        Assert.assertTrue(testFile.canRead());
        Assert.assertEquals(testFile.getPath(), TEST_DESTINATION_FILE);
    }

    @Test(expected = NullPointerException.class)
    public void exceptionCheck() {
        List<String> myTestList = null;
        writerService.writeToFile(myTestList, "src\\test\\resource\\testDestinationFile.csv");
    }
}
