package core.basesyntax.io.read.impl.csv;

import core.basesyntax.io.read.ReportReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReaderImpl implements ReportReader {
    private final String reportPath;

    public CsvReaderImpl(String reportPath) {
        this.reportPath = reportPath;
    }

    public String readReport() throws FileNotFoundException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(reportPath))) {
            if (reportPath.isEmpty()) {
                throw new FileNotFoundException("The path specified is incorrect");
            }
            StringBuilder sb = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                sb.append(value);
                value = bufferedReader.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("The file was not processed correctly");
        }
    }
}
