package core.basesyntax.servise;

import core.basesyntax.servise.inrterfase.ReportWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeReport(String fileName) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(new ReportGenerator().readData());
        } catch (IOException e) {
            throw new RuntimeException("Can't found the file", e);
        }
    }
}
