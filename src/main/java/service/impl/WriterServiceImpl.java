package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String REPORT_TITLE = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";
    private static final int BORDER_POSITIVE = 0;

    @Override
    public void writeToFile(String filePath, Map<String, Integer> data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(REPORT_TITLE);
            for (Map.Entry<String, Integer> item : data.entrySet()) {
                if (item.getValue() < BORDER_POSITIVE) {
                    throw new RuntimeException("Balance can't be negative quantity!");
                }
                bufferedWriter.write(item.getKey() + COMMA + item.getValue()
                        + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + filePath, e);
        }
        if (!(new File(filePath).exists())) {
            try {
                throw new FileNotFoundException("Can't find file by path: " + filePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
