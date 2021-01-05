package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileWriterImplTest {
    private static FileWriter fileWriter;
    private List<String> report;
    private String expectedReportFile = "src/test/resources/expectedreport.csv";
    private String rightFileReport = "src/test/resources/fruitreportTest.csv";

    @BeforeClass
    public static void beforeClass() throws Exception {
        fileWriter = new FileWriterImpl();
    }

    @Before
    public void setUp() throws Exception {
        report = Arrays.asList("apple,100");
    }

    @Test
    public void whenExpectedFileFilledOut_expectEqualsContent() {
        fileWriter.writeToFile(report, rightFileReport);
        long sizeExpectedFile = 0;
        long sizeActual = 0;
        try {
            sizeExpectedFile = Files.size(Path.of(expectedReportFile));
            sizeActual = Files.size(Path.of(rightFileReport));
        } catch (IOException e) {
            throw new RuntimeException("No exist file for testing");
        }
        Assert.assertEquals(sizeExpectedFile, sizeActual);
    }
}
