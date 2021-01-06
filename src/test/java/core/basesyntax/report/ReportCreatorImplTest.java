package core.basesyntax.report;

import static org.junit.Assert.assertEquals;

import core.basesyntax.database.Storage;
import core.basesyntax.dataio.CsvToStorage;
import core.basesyntax.dataio.FileReaderImpl;
import core.basesyntax.dataio.FileWriter;
import core.basesyntax.dataio.FileWriterImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeMap;
import org.junit.Before;
import org.junit.Test;

public class ReportCreatorImplTest {
    private static ReportCreator reportCreator = new ReportCreatorImpl();

    @Before
    public void setUp() {
        Storage.setFruitsMap(new TreeMap<>());
    }

    @Test
    public void test1_ReportCreatorOk() {
        new CsvToStorage(new FileReaderImpl("src/main/resources/test1.cvs").read());
        String actual = reportCreator.createReport();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,20" + System.lineSeparator() + "banana,95";
        assertEquals(expected, actual);
    }

    @Test
    public void test2_ReportCreatorToFileOk() {
        new CsvToStorage(new FileReaderImpl("src/main/resources/test2.csv").read());
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(reportCreator.createReport(),
                "src/main/resources/test2_output.csv");
        String actual;
        try {
            actual = Files.readString(Path.of("src/main/resources/test2_output.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Can't read test2_output.csv", e);
        }
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,82" + System.lineSeparator() + "banana,43";
        assertEquals(expected, actual);
    }

    @Test
    public void test3_CsvToStorage_emptyProcedures() {
        try {
            new CsvToStorage(new FileReaderImpl("src/main/resources/test3.csv").read());
        } catch (RuntimeException e) {
            assertEquals("Wrong operation ", e.getMessage());
        }
    }

    @Test
    public void test4_CsvToStorage_notEnoughSupply() {
        try {
            new CsvToStorage(new FileReaderImpl("src/main/resources/test4.csv").read());
        } catch (RuntimeException e) {
            assertEquals("Not enough bananas", e.getMessage());
        }
    }

    @Test
    public void test5_CsvToStorage_wrongProcedure() {
        try {
            new CsvToStorage(new FileReaderImpl("src/main/resources/test5.csv").read());
        } catch (RuntimeException e) {
            assertEquals("Wrong operation k", e.getMessage());
        }
    }
}
