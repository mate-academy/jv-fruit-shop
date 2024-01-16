package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class CsvWriterServiceImpl implements WriterService {
    public CsvWriterServiceImpl() {
    }

    @Override
    public void write(File toFileName, Map<String, BigDecimal> map) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        map.forEach((key, value) -> stringBuilder.append(key)
                .append(",")
                .append(value)
                .append(System.lineSeparator()));
        String report = stringBuilder.toString();
        try {
            Files.writeString(toFileName.toPath(), report, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file ", e);
        }
    }
}
