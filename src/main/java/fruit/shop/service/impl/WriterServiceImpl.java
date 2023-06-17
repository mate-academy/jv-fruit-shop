package fruit.shop.service.impl;

import fruit.shop.service.StringConnector;
import fruit.shop.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeRecordsToFile(String fileName, Map<String, Integer> records) {
        StringConnector connector = new StringConnectorImpl();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(connector.getStringReport(records));
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong! Can't write to file "
                    + fileName + " ! " + e);
        }
    }
}
