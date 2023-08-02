package core.basesyntax.handler.impl;

import static core.basesyntax.Constants.COMMA_SIGN;
import static core.basesyntax.Constants.REPORT_TABLE_HEADER;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.handler.ReportHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportHandlerImpl implements ReportHandler {
    @Override
    public boolean getReport(String dataPathToReport) {
        boolean isSaved = false;
        File file = new File(dataPathToReport);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(REPORT_TABLE_HEADER)
                    .append(System.lineSeparator());
            for (Map.Entry<String, Integer> data : FruitsStorage.fruitsStorage.entrySet()) {
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
