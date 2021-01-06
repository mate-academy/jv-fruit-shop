package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.MyFileWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class MyFileWriterCsvImpl implements MyFileWriter {
    @Override
    public void writeToFile(String filePathForWrite) {
        Map<Fruit, Integer> resultForReport = Report.createReport();
        try (Writer csvWriter = new FileWriter(filePathForWrite)) {
            csvWriter.append("fruit,quantity").append(System.lineSeparator());
            for (Map.Entry<Fruit, Integer> line : resultForReport.entrySet()) {
                csvWriter.append(line.getKey().getName())
                        .append(",")
                        .append(line.getValue().toString())
                        .append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + filePathForWrite, e);
        } catch (IOException e) {
            throw new RuntimeException("Data couldn't write to file " + filePathForWrite, e);
        }
    }
}
