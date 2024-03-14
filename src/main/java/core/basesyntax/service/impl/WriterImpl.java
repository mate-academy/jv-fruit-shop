package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    @Override
    public void write(String finalData, String newFilePass) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFilePass,true));
            bufferedWriter.write(finalData);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + newFilePass, e);
        }
    }
}
