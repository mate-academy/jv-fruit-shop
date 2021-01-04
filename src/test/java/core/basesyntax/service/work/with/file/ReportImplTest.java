package core.basesyntax.service.work.with.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReportImplTest {
    private static Report report;
    private static String expected;
    private static String fileName;

    @BeforeAll
    static void beforeAll() {
        report = new ReportImpl();
        fileName = "";
        expected = "";
    }

    @Test
    void inputData1_Ok() {
        fileName = "database.csv";
        expected = "fruit,quantity" + System.lineSeparator()
                + "banana,152" + System.lineSeparator()
                + "apple,90";
        report.writeReportToFile(fileName);
        assertEquals(expected, report.writeReport(fileName));
        Storage.fruits.clear();
    }

    @Test
    void inputData2_Ok() {
        fileName = "database1.csv";
        expected = "fruit,quantity" + System.lineSeparator()
                + "banana,46" + System.lineSeparator()
                + "apple,134" + System.lineSeparator()
                + "orange,1000";
        report.writeReportToFile(fileName);
        assertEquals(expected, report.writeReport(fileName));
        Storage.fruits.clear();
    }

    @Test
    void inputData_NotOk() {
        fileName = "databaseWithNegativeNumber.csv";
        assertThrows(ArithmeticException.class, () -> report.writeReport(fileName));
    }

    @Test
    void inputDataWithRepetitiveBalance_Ok() {
        fileName = "databaseWithRepetitiveBalance.csv";
        expected = "fruit,quantity" + System.lineSeparator()
                + "banana,152" + System.lineSeparator()
                + "apple,90";
        report.writeReportToFile(fileName);
        assertEquals(expected, report.writeReport(fileName));
        Storage.fruits.clear();
    }
}
