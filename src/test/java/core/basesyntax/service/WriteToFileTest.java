package core.basesyntax.service;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriteToFileTest {
    WriterToFile writeToFile = new WriterToFile();

    @Test
    public void simpleWriteToFileTest() {
        double randomNumber = Math.random() * 1000;
        String actual = String.valueOf(randomNumber) + "\n";
        writeToFile.print(actual, "src/test/java/resourses/writeSomething.csv");
        try {
            List<String> result = Files.readAllLines(Path.of("src/test/java/resourses/writeSomething.csv"));
            String expected = String.join("", result);
            Assert.assertEquals(actual, expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = RuntimeException.class)
    public void writeByWrongPath() {
        writeToFile.print("", "randomfolder/tnmnmmn.csv");
    }
}
