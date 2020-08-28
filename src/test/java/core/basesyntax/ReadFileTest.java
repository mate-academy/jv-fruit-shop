package core.basesyntax;

import core.basesyntax.servise.FileReadService;
import core.basesyntax.servise.ReadFile;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadFileTest {
    private static final String FILE_WITH_CORRECTLY_DATA = "src/resources/FruitTestOk.csv";
    private static final String EMPTY_DATA = "src/resources/DataIsEmpty.csv";
    private static final String WRONG_NAME_FILE = "wrongName.txt";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static FileReadService readService;

    @BeforeClass
    public static void BeforeClass() {
        readService = new ReadFile();
    }

}
