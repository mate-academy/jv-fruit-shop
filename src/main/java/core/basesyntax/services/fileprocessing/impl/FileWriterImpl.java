package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.services.fileprocessing.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FileWriterImpl implements FileWriter {
    private static final String DATE_TIME_PATTERN = "dd.MM.yy HH-mm";
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(DATE_TIME_PATTERN, Locale.ENGLISH);
    private static final String REPORT_NAME = "REPORT FOR " + FORMATTER.format(LocalDateTime.now());
    private static final String FILE_PATH = "src/main/resources/" + REPORT_NAME;

    @Override
    public void writeToFile(StringBuilder stringBuilder) {
        File currentReport = new File(FILE_PATH);
        BufferedWriter bufferedWriter = null;
        if (!currentReport.exists()) {
            try {
                bufferedWriter = new BufferedWriter(new java.io.FileWriter(FILE_PATH, true));
                bufferedWriter.write(String.valueOf(stringBuilder));
            } catch (IOException e) {
                throw new RuntimeException("Can't write to file", e);
            } finally {
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException("Can't close BufferedWriter", e);
                    }
                }
            }
        }
    }
}
