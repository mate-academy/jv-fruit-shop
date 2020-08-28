package core.basesyntax.fileservice;

import core.basesyntax.model.FruitBatch;
import core.basesyntax.storage.Storage;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class FileWriterImplTest {
    private static final FileWrite FILE_WRITER = new FileWriterImpl();
    private static final Storage EMPTY_STORAGE = new Storage();
    private static final Storage REGULAR_STORAGE = new Storage();
    private static final String[] PATH = {"src/test/resources", "test5.csv"};
    private static final Path FILE_PATH = Paths.get(PATH[0]
            + FileSystems.getDefault().getSeparator() + "report_" + PATH[1]);

    @BeforeClass
    public static void setUp() {
        REGULAR_STORAGE.addFruits(new FruitBatch("s", "banana",
                15, LocalDate.parse("2020-05-20")));
        REGULAR_STORAGE.addFruits(new FruitBatch("s", "apple",
                34, LocalDate.parse("2020-05-17")));
    }

    @Test
    public void writeEmpty() {
        FILE_WRITER.writeToFile(PATH, EMPTY_STORAGE);
        Assert.assertTrue(Files.exists(FILE_PATH));
    }

    @Test
    public void writeCorrect() {
        FILE_WRITER.writeToFile(PATH, REGULAR_STORAGE);
        Assert.assertTrue(Files.exists(FILE_PATH));
    }

    @After
    public void deleteFile() {
        try {
            Files.deleteIfExists(FILE_PATH);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
