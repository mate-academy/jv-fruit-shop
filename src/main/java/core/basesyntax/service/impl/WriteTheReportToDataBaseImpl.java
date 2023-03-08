package core.basesyntax.service.impl;

import core.basesyntax.service.CreateReportMessage;
import core.basesyntax.service.CreateTheReport;
import core.basesyntax.service.WriteTheReportToDataBase;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteTheReportToDataBaseImpl implements WriteTheReportToDataBase {
    private static final String REPORT_FILE_NAME = "report.csv";
    CreateReportMessage createReportMessage = new CreateReportMessageImpl();

    @Override
    public void write(Map<String, Integer> toWrite) {
        if (toWrite == null) {
            throw new RuntimeException("Map what is used to write the file is null!");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_FILE_NAME))) {
            writer.write(createReportMessage.createMessage(toWrite));
        } catch (IOException e) {
            throw new RuntimeException("Can't write information to the file" + REPORT_FILE_NAME);
        }
    }
}
