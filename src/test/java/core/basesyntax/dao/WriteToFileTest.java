package core.basesyntax.dao;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class WriteToFileTest {
    private static final String TEST_STRING = "fruit,quantity" + System.lineSeparator() +
            "banana,3" + System.lineSeparator();
    private static final String FILE_DEST_TEST_5 = "src/test/resources/Test_5.csv";
    private static final LocalDate FIRST_DATE = LocalDate.of(2020, 12, 12);
    private static final LocalDate SECOND_DATE = LocalDate.of(2020, 11, 21);
    private static final Path FILE_DEST_TEST_3 = Paths.get("src/test/resources/Test_3.csv");
    private static final Path FILE_DEST_TEST_4 = Paths.get("src/test/resources/Test_4.csv");
    private static final Fruit FRUIT_FIRST = new Fruit();
    private static final Fruit FRUIT_SECOND = new Fruit();

    @Before
    public void setUpClass() {
        FRUIT_FIRST.setName("banana");
        FRUIT_FIRST.setAmount(1);
        FRUIT_FIRST.setExpirationDate(FIRST_DATE);
        FRUIT_SECOND.setName("banana");
        FRUIT_SECOND.setAmount(2);
        FRUIT_SECOND.setExpirationDate(SECOND_DATE);
        ListStorage.listStorage.clear();
        ListStorage.listStorage.add(FRUIT_FIRST);
        ListStorage.listStorage.add(FRUIT_SECOND);

        if (Files.exists(FILE_DEST_TEST_4)) {
            try {
                Files.delete(FILE_DEST_TEST_4);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void writeToExistedFile() throws IOException {
        WriteToFile write = new WriteToFile();
        write.writeToFile(FILE_DEST_TEST_3.toString());
        String csvString = Files.readString(FILE_DEST_TEST_3);
        Assert.assertEquals(TEST_STRING, csvString);
    }

    @Test
    public void writeToNonExistedFile() throws IOException {
        WriteToFile write = new WriteToFile();
        write.writeToFile(FILE_DEST_TEST_4.toString());
        String csvString = Files.readString(FILE_DEST_TEST_4);
        Assert.assertEquals(TEST_STRING, csvString);
    }
//
//    @Test(expected = RuntimeException.class)
//    public void fileWriterException() {
//        WriteToFile write = new WriteToFile();
//        write.writeToFile(FILE_DEST_TEST_5);
//    }
}
