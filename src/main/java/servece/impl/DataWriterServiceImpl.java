package servece.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import service.DataWriterService;

public class DataWriterServiceImpl implements DataWriterService {

    private static final String LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "fruit,quantity";

    @Override
    public void writeProcessedDataToFile(String fileName, Map<String, Integer> dates) {
        File file = new File(fileName);
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(FILE_HEADER + LINE_SEPARATOR);
            for (Map.Entry<String, Integer> data : dates.entrySet()) {
                bufferedWriter.write(data.getKey() + ","
                        + data.getValue() + LINE_SEPARATOR);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to this file: " + e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can't close this file:" + e);
                }
            }
        }
    }
}
