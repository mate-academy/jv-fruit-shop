package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteCsvService implements Writer {
    private static final String TITLE_TEXT = "fruit,quantity";
    private static final String RUNTIME_EXCEPTION_MESSAGE = "Can't write file ";

    @Override
    public boolean write(String report, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(path));
            bufferedWriter.write(TITLE_TEXT);
            bufferedWriter.newLine();
            bufferedWriter.write(report);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(RUNTIME_EXCEPTION_MESSAGE + path, e);
        }
        return true;
    }
}
