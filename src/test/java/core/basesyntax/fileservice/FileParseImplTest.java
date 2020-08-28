package core.basesyntax.fileservice;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class FileParseImplTest {
    private static final List<String> HEADER_LIST
            = new ArrayList<>(List.of("type","fruit","quantity","date"));
    private static final List<List<String>> CORRECT_LIST = new ArrayList<>();
    private static final List<List<String>> NULL_LIST = null;
    private static final List<List<String>> INCORRECT_LIST = new ArrayList<>();
    private static final FileParse FILE_PARSER = new FileParseImpl();

    @BeforeClass
    public static void setUp() {
        CORRECT_LIST.add(HEADER_LIST);
        CORRECT_LIST.add(List.of("s","banana","100","2020-10-17"));
        CORRECT_LIST.add(List.of("b","banana","13","2020-10-15"));
        CORRECT_LIST.add(List.of("r","banana","10","2020-10-17"));
        INCORRECT_LIST.add(HEADER_LIST);
        INCORRECT_LIST.add(List.of("s","banana","100","2020-10-17","ERROR"));
        INCORRECT_LIST.add(List.of("b","banana","13","2020-10-15"));
        INCORRECT_LIST.add(List.of("r","banana","10","2020-10-17"));
    }

    @Test
    public void nullInput() {
        try {
            FILE_PARSER.parseList(NULL_LIST);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("List is null", e.getMessage());
        }
    }

    @Test
    public void incorrectInput() {
        try {
            FILE_PARSER.parseList(INCORRECT_LIST);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid number of elements", e.getMessage());
        }
    }

    @Test
    public void correctInput() {
        Assert.assertEquals(3, FILE_PARSER.parseList(CORRECT_LIST).size());
    }
}