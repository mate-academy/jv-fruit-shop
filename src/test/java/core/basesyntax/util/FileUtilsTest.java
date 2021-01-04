package core.basesyntax.util;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import core.basesyntax.ExportData;
import core.basesyntax.Order;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FileUtilsTest {

    private static final String PATH_TO_READ = "src/test/resources/test_to_read.csv";
    private static final String PATH_TO_WRITE = "src/test/resources/write_test_result.csv";

    @Test
    public void checkReadingFile() throws IOException {
        assertEquals(List.of(createOrder()), FileUtils.read(PATH_TO_READ));
    }

    @Test
    public void checkWritingFile() throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        FileUtils.write(PATH_TO_WRITE, List.of(new ExportData(100, "banana")));
        assertArrayEquals(Files.readAllBytes(Path.of("src/test/resources/expected_result")),
                Files.readAllBytes(Path.of(PATH_TO_WRITE)));
        Files.delete(Path.of(PATH_TO_WRITE));
    }

    private Order createOrder() {
        Order order = new Order();
        order.setType('s');
        order.setQuantity(100);
        order.setFruitName("banana");
        order.setDate(LocalDate.parse("2020-10-17"));
        return order;
    }
}
