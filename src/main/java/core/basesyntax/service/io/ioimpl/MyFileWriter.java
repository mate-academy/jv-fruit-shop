package core.basesyntax.service.io.ioimpl;

import core.basesyntax.service.io.MyWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriter implements MyWriter {
    @Override
    public void write(String path, List<String> content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String s : content) {
                writer.write(s + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + path, e);
        }
    }
}
