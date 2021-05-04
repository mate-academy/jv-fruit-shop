package core.basesyntax.service.impls;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportFileWriterImpl implements ReportFileWriter {
    private static final String OUTPUT_HEADER = "fruit,quantity";

    @Override
    public void writeToFile(String outputFile) {
        try (BufferedWriter reportWriter = new BufferedWriter(new FileWriter(outputFile))) {
            reportWriter.write(OUTPUT_HEADER + "\n");
            for (Map.Entry<String, Integer> entry : Storage.shopDatabase.entrySet()) {
                reportWriter.write(String.valueOf(entry.getKey()) + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + outputFile);
        }
    }
}
