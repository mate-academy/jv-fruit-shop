package core.basesyntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportFile {
    public void madeReportFile() {
        File reportFile = new File("report.csv");
        BufferedWriter bufferedWriter = null;
        {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(reportFile));
                bufferedWriter.write("fruit,quantity");
                bufferedWriter.newLine();
                for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
                    bufferedWriter.write(entry.getKey() + "," + entry.getValue());
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file", e);
            } finally {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can't close file!", e);
                }
            }
        }
    }
}
