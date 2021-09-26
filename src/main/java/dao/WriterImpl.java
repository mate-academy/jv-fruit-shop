package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import service.ReportImpl;

public class WriterImpl implements Writer {
    private static final String FILE_PATH = "src/main/reports/report.csv";
    private static final Map<String, Integer> reportMap = new ReportImpl().report();

    @Override
    public void reportWriter() {
        String header = "fruit, quantity";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.write(header);
            writer.newLine();
            for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
                writer.write(entry.getKey());
                writer.write(", " + entry.getValue());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write this report");
        }
    }
}
