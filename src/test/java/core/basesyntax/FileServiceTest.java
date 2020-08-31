package core.basesyntax;

import dto.PositionDto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import services.FileParser;
import services.FileService;

public class FileServiceTest {
    private static final String VALID_DATAFILE_PATH = "src/test/resources/fruits.csv";
    private static final String FILE_PATH_TO_WRITE_RESULT = "src/test/java/results/result.txt";
    private static final String OPERATION = "some operation";
    private static final String FRUIT_NAME = "kiwi";
    private static final String QUANTITY = "12";
    private static final LocalDate DATE = LocalDate.parse("2020-12-12");
    private static final String SEPARATOR = ",";
    private static final String LINE_FOR_PARSING = OPERATION
            + SEPARATOR + FRUIT_NAME
            + SEPARATOR + QUANTITY
            + SEPARATOR + DATE;

    private static FileService fileService;

    @BeforeClass
    public static void setUp() throws IOException {
        fileService = new FileService();
        try {
            FileWriter file = new FileWriter(FILE_PATH_TO_WRITE_RESULT);
            file.write(LINE_FOR_PARSING);
            file.flush();
        } catch (IOException exception) {
            throw new IOException();
        }
    }

    @After
    public void deleteFile() {
        File file = new File(FILE_PATH_TO_WRITE_RESULT);
        file.delete();
    }

    @Test
    public void parserTest() {
        FileParser fileParser = new FileParser();
        PositionDto expectedPositionDto = new PositionDto(OPERATION, FRUIT_NAME,
                Integer.parseInt(QUANTITY), DATE);
        PositionDto positionDto = fileParser.parse(LINE_FOR_PARSING);
        Assert.assertEquals(expectedPositionDto.getOperation(), positionDto.getOperation());
        Assert.assertEquals(expectedPositionDto.getFruitName(), positionDto.getFruitName());
        Assert.assertEquals(expectedPositionDto.getQuantity(), positionDto.getQuantity());
        Assert.assertEquals(expectedPositionDto.getDate(), positionDto.getDate());
    }

    @Test
    public void writeFileTest() {
        FileService fileService = new FileService();
        fileService.writeFile(LINE_FOR_PARSING, FILE_PATH_TO_WRITE_RESULT);
        File expected = new File(FILE_PATH_TO_WRITE_RESULT);
        Assert.assertTrue(expected.exists()
                && expected.length() != 0
                && !expected.isDirectory());
    }

    @Test
    public void readFileTest() {
        boolean expected = fileService.readFile(VALID_DATAFILE_PATH);
        Assert.assertTrue(expected);
    }
}
