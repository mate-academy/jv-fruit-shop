package core.basesyntax.service.impl;

import core.basesyntax.service.DailyReportFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class DailyReportFileWriterImpl implements DailyReportFileWriter {
    @Override
    public void writeDailyStatistic(Path path, String data) {
        validateReportFile(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + path);
        }
    }
}
