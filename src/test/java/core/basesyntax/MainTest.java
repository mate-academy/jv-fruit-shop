package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.servise.FruitTransactionService;
import core.basesyntax.servise.FruitTransactionServiceImp;
import core.basesyntax.servise.fileservice.FileReaderUtility;
import core.basesyntax.servise.fileservice.FileReaderUtilityImp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void testReturnAndSupply_ok() throws IOException {
        String path = "src/test/java/core/basesyntax/fileTest4.csv";
        String actualFile = Main.createReportFile(path);
        String exceptionFile = "src/test/java/core/basesyntax/fileTest4Exception.csv";
        BufferedReader readerActual = new BufferedReader(new FileReader(actualFile));
        StringBuilder stringBuilderActual = new StringBuilder();
        String actualLine = readerActual.readLine();
        while (actualLine != null) {
            stringBuilderActual.append(actualLine);
            actualLine = readerActual.readLine();
        }
        BufferedReader readerException = new BufferedReader(new FileReader(exceptionFile));
        StringBuilder stringBuilderException = new StringBuilder();
        String exceptionLine = readerException.readLine();
        while (exceptionLine != null) {
            stringBuilderException.append(exceptionLine);
            exceptionLine = readerException.readLine();
        }
        assertEquals(stringBuilderException.toString(), stringBuilderActual.toString());
    }

    @Test
    void testCreateReportFile() {
        String path = "src/test/java/core/basesyntax/fileTest.csv";
        String actual = Main.createReportFile(path);
        String exception = "src/main/java/core/basesyntax/files/report " + LocalDate.now() + ".csv";
        assertNotNull(actual);
        assertEquals(actual,exception);
    }

    @Test
    void testFileReaderUtility_ok() {
        FileReaderUtility fileReader = new FileReaderUtilityImp();
        String path = "src/test/java/core/basesyntax/fileTest2.csv";
        List<String> actual = fileReader.retrieveFileData(path);
        List<String> exception = new ArrayList<>();
        exception.add("b,banana,20");
        exception.add("b,apple,100");
        assertEquals(actual.size(),exception.size());
        int index = 0;
        for (String line: actual) {
            assertEquals(line, exception.get(index));
            index++;
        }
    }

    @Test
    void testFileReaderUtility_notOk() {
        FileReaderUtility fileReader = new FileReaderUtilityImp();
        String path = "src/test/java/core/basesyntax/fileTest3.csv";
        assertThrows(RuntimeException.class, () -> fileReader.retrieveFileData(path));
    }

    @Test
    void testFileReaderUtility_notOk1() {
        FileReaderUtility fileReader = new FileReaderUtilityImp();
        String path = "src/test/java/core/basesyntax/fileTestEmpty.csv";
        List<String> actual = fileReader.retrieveFileData(path);
    }

    @Test
    void testFruitTransactionService_NotOk() {
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImp();
        List<String> listDate = new ArrayList<String>();
        listDate.add(" , , ");
        assertThrows(IllegalArgumentException.class, () ->
                fruitTransactionService.createTransactionList(listDate));
    }
}
