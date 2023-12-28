package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.model.ReportRecord;
import core.basesyntax.service.ReportWriterService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CsvFileReportWriterServiceTest {
    private static final String filename = "src/test/resources/output.csv";
    private ReportWriterService writerService;

    @BeforeEach
    void setUp() {
        writerService = new CsvFileReportWriterService(filename);
    }

    @AfterEach
    void tearDown() {
        new File(filename).delete();
    }

    @Test
    void write_whenEmptyList_thenFileHasOneLineWithHeaders() {
        writerService.write(new ArrayList<>());
        assertEquals(1, readFile().size());
    }

    @Test
    void write_ValidData_success() {
        List<ReportRecord> list = new ArrayList<>();
        list.add(new ReportRecord("apple", 10));
        list.add(new ReportRecord("banana", 7));
        writerService.write(list);
        assertEquals(3, readFile().size());
    }

    private List<String> readFile() {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File '" + filename + "' not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file '" + filename + "'.", e);
        }

        return list;
    }
}
