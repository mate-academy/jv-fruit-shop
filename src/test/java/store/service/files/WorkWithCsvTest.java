package store.service.files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WorkWithCsvTest {
    private WorkWithCsv workWithCsv;

    @BeforeEach
    void createObject() {
        workWithCsv = new WorkWithCsv();
    }

    @Test
    void read_fileNotExist() {
        workWithCsv.setFileNameForRead("asd.csv");
        Assertions.assertThrows(RuntimeException.class, () -> workWithCsv.read());
    }

    @Test
    void read_negativeValue() {
        workWithCsv.setFileNameForRead("fileNegativeValues.csv");
        Assertions.assertThrows(RuntimeException.class, () -> workWithCsv.read());
    }

    @Test
    void read_buyFruit_NotOk() {
        workWithCsv.setFileNameForRead("fileBuyNotOk.csv");
        Assertions.assertThrows(RuntimeException.class, () -> workWithCsv.read());
    }

    @Test
    void read_buyFruit_Ok() {
        workWithCsv.setFileNameForRead("file.csv");
        workWithCsv.read();
    }

    @Test
    void read_buyFruit_null() {
        Assertions.assertThrows(NullPointerException.class,
                () -> workWithCsv.setFileNameForRead(null));
    }

    @Test
    void getReport_finalTest1() {
        workWithCsv.setFileNameForRead("file.csv");
        workWithCsv.startWork();
        StringBuilder expected = new StringBuilder();
        expected.append("fruit").append(",").append("quantity").append(System.lineSeparator())
                .append("banana").append(",").append("152").append(System.lineSeparator())
                .append("apple").append(",").append("90").append(System.lineSeparator());
        Assertions.assertEquals(expected.toString(), workWithCsv.writeToReport());
    }

    @Test
    void getReport_finalTest2() {
        workWithCsv.setFileNameForRead("file2.csv");
        workWithCsv.startWork();
        StringBuilder expected = new StringBuilder();
        expected.append("fruit").append(",").append("quantity").append(System.lineSeparator())
                .append("banana").append(",").append("132").append(System.lineSeparator())
                .append("apple").append(",").append("90").append(System.lineSeparator());
        Assertions.assertEquals(expected.toString(), workWithCsv.writeToReport());
    }
}
