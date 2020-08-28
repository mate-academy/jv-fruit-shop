package core.basesyntax;

import core.basesyntax.service.ActionController;
import core.basesyntax.service.FileReadService;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.impl.FileReadServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileWriterTest {
    private static final String INPUT_FILE = "src\\test\\resources\\test0.txt";
    private static final String OUTPUT_FILE = "src\\test\\resources\\output.txt";


    private static final FileWriteService fileWriteService = new FileWriteServiceImpl();

    @Before
    public void setUp() {
        Store.fruits.clear();
    }

    @Test
    public void fileWriterOk() {
        FileReadService fileReadService = new FileReadServiceImpl();
        List<Transaction> data = fileReadService.readFile(INPUT_FILE);

        ActionController actionController = new ActionController();
        actionController.distributeActions(data);

        FileWriteService fileWriteService = new FileWriteServiceImpl();
        fileWriteService.writeFile(Store.fruits, OUTPUT_FILE);

        String expected = "fruit, quantity\n"
                + "orange, 90\n"
                + "banana, 80\n"
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
        fileWriteService.writeFile(testMap, OUTPUT_FILE);
    }

    @Test(expected = NullPointerException.class)
    public void fileWriteWithNullArgument() throws IOException {
        fileWriteService.writeFile(null, OUTPUT_FILE);
    }
}
