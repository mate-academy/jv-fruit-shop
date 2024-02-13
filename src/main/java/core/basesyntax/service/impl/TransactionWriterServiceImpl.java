package core.basesyntax.service.impl;

import core.basesyntax.service.TransactionWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class TransactionWriterServiceImpl implements TransactionWriterService {
    @Override
    public void writeToFile(Map<String, Integer> fruitReport, String fileName) {
        File report = new File(fileName);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(report));
            writer.write("fruit,quantity");
            for (Map.Entry<String, Integer> entry : fruitReport.entrySet()) {
                writer.newLine();
                writer.write(entry.getKey() + "," + entry.getValue());
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
