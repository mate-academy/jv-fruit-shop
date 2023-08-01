package core.basesyntax.handler.impl;

import static core.basesyntax.Constants.COMMA_SIGN;
import static core.basesyntax.Constants.REPORT_TABLE_HEADER;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.handler.ReportHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class ReportHandlerImpl implements ReportHandler {
    private final FruitsStorage storage;

    public ReportHandlerImpl(FruitsStorage storage) {
        this.storage = storage;
    }

    @Override
    public boolean getReport(String dataToReport) {
        boolean isSaved = false;
        File file = new File(dataToReport);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(REPORT_TABLE_HEADER)
                        .append(System.lineSeparator());
            for (Map.Entry<String, BigDecimal> data : storage.getFruitsStorage().entrySet()) {
                stringBuilder.append(data.getKey())
                        .append(COMMA_SIGN)
                        .append(data.getValue())
                        .append(System.lineSeparator());
            }
            bufferedWriter.write(stringBuilder.toString());
            isSaved = true;
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file " + file.getName(), e);
        }
        return isSaved;
    }
}
