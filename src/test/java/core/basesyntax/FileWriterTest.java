package core.basesyntax;

import core.basesyntax.service.FileReadService;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.impl.FileReadServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileWriterTest {
    private static final String INPUT_FILE = "test0.txt";
    private static final String OUTPUT_FILE = "output.txt";


    private static final FileWriteService fileWriteService = new FileWriteServiceImpl();

    @BeforeClass
    public static void beforeClass() throws Exception {
        Store.fruits.clear();
    }

    @Test
    public void fileWriterOk() {
        Main.main(new String[]{INPUT_FILE});

        String expected = "banana, 80\n"
                + "orange, 90\n"
                + "apple, 75";
        StringBuilder actual = new StringBuilder();
        Path path = Paths.get(OUTPUT_FILE);

        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                actual.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("File is not exist");
        }

        Assert.assertEquals(expected, actual.toString().trim());
    }

    @Test(expected = IllegalArgumentException.class)
    public void fileWriteWithEmptyMap() {
        Map<String, Integer> testMap = new HashMap<>();
        fileWriteService.writeFile(testMap);
    }

    @Test(expected = NullPointerException.class)
    public void fileWriteWithNullArgument() throws IOException {
        fileWriteService.writeFile(null);
    }
}
