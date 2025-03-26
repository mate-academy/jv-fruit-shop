package core.basesyntax.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl extends FileWriter implements core.basesyntax.report.FileWriter {

    public FileWriterImpl(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String report, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file: " + fileName, e);
        }
    }
}
