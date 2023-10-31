package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteToCSV implements Writer {
    private static final String REPORT_PATH = "src/main/resources";
    private static final String FILE_NAME = "Log.CSV";

    @Override
    public boolean write(Map<String, Integer> map) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(REPORT_PATH + "/" + FILE_NAME));
            bufferedWriter.write("fruit,quantity");
            bufferedWriter.newLine();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String line = entry.getKey() + "," + entry.getValue();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + FILE_NAME, e);
        }
    }
}
