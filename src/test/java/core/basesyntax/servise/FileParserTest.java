package core.basesyntax.servise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.servise.impl.CsvParser;
import core.basesyntax.servise.impl.FilesReaderImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileParserTest {
    private static FileParser<TransactionDto> fileParser;
    private static FilesReader filesReader;
    private static List<String> list;

    @BeforeClass
    public static void beforeClass() throws Exception {
        fileParser = new CsvParser();
        filesReader = new FilesReaderImpl();
        list = filesReader.readData("src/main/resources/test-fruit.csv");
    }

    @Test
    public void parseData_Ok() {
        List<TransactionDto> expect = new ArrayList<>();
        expect.add(new TransactionDto(Operation.fromString("b"), new Fruit("banana"), 20));
        expect.add(new TransactionDto(Operation.fromString("b"), new Fruit("apple"), 100));
        expect.add(new TransactionDto(Operation.fromString("s"), new Fruit("banana"), 100));
        expect.add(new TransactionDto(Operation.fromString("p"), new Fruit("banana"), 13));
        expect.add(new TransactionDto(Operation.fromString("r"), new Fruit("apple"), 10));
        expect.add(new TransactionDto(Operation.fromString("p"), new Fruit("apple"), 20));
        expect.add(new TransactionDto(Operation.fromString("p"), new Fruit("banana"), 5));
        expect.add(new TransactionDto(Operation.fromString("s"), new Fruit("banana"), 50));
        assertEquals(expect, fileParser.parseData(list));
    }

    @Test
    public void parseDataEmptyList_NotOk() {
        List<TransactionDto> expect = new ArrayList<>();
        assertNotEquals(expect, fileParser.parseData(list));
    }

    @Test
    public void parseDataWrongList_NotOk() {
        List<TransactionDto> expect = new ArrayList<>();
        expect.add(new TransactionDto(Operation.fromString("r"), new Fruit("melon"), 10));
        expect.add(new TransactionDto(Operation.fromString("s"), new Fruit("orange"), 1));
        assertNotEquals(expect, fileParser.parseData(list));
    }
}
