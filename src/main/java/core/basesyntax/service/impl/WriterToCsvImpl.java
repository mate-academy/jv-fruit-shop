package core.basesyntax.service.impl;

import core.basesyntax.service.WriterToCsv;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToCsvImpl implements WriterToCsv {
    @Override
    public void write(String data, String toFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file" + toFileName, e);
        }
    }
}
