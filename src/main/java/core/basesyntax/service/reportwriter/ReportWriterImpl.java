package core.basesyntax.service.report_writer;

import core.basesyntax.db.Storage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ReportWriterImpl implements ReportWriter {
    private static final String HEAD_LINE = "fruit,quantity";
    private static final String WRITE_TO_FILE_EXCEPTION = "Can't write to file: ";

    @Override
    public void writeReport(String fileName) {
        List<String> collect = Storage.fruits.entrySet()
                .stream()
                .map(currentKey -> currentKey.getKey().getName() + "," + currentKey.getValue())
                .collect(Collectors.toList());
        File fileTo = new File(fileName);
        try {
            collect.add(0, HEAD_LINE);
            Files.write(fileTo.toPath(), collect);
        } catch (IOException e) {
            throw new RuntimeException(WRITE_TO_FILE_EXCEPTION + fileName, e);
        }
    }
}
