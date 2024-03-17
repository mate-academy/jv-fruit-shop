package core.basesyntax.readandwriteimpl;

import core.basesyntax.readandwritefile.CsvWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvWriterImpl implements CsvWriter {
    @Override
    public void writeReportToFile(List<String> report, String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (String line : report) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the report to the file: "
                    + e.getMessage());
        }
    }
}
