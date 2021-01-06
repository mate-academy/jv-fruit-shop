package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class WriterServiceImplTest {
    private static final String TEST_DESTINATION_FILE =
            "src\\test\\resource\\testDestinationFile.csv";
    WriterService writerService = new WriterServiceImpl();

    @Test
    public void validData() {
        List<String> myTestList = new ArrayList<>();
        myTestList.add("orange, 15");
        myTestList.add("lemon, 5");
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
}
