package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteCsvService implements Writer {
    private static final String REPORT_PATH = "src/main/resources";
    private static final String FILE_NAME = "Log.CSV";
    private static final String UPPER_TEXT = "fruit,quantity";
    private static final String RUNTIME_EXCEPTION_MESSAGE = "Can't write file ";

    @Override
    public boolean write(Map<String, Integer> map) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(REPORT_PATH + "/" + FILE_NAME));
            bufferedWriter.write(UPPER_TEXT);
            bufferedWriter.newLine();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String line = entry.getKey() + "," + entry.getValue();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(RUNTIME_EXCEPTION_MESSAGE + FILE_NAME, e);
        }
    }
}
