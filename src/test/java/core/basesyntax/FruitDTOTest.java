package core.basesyntax;

import core.exceptions.FileEmptyException;
import core.parser.FileService;
import core.parser.FileServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FruitDTOTest {
    private static final FileService SERVICE = new FileServiceImpl();
    private static final String CORRECT_FILE_IN = "Fruit In";
    private static final String EMPTY_FILE_IN = "Fruit Empty";
    private static final String NO_FILE = "404 File";
    private static final String OUT_FILE = "FruitOut";
    private static final String PATH= "src/test/resources/";

    @Test
    public void Parse() {
    }
}
