package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.service.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToCsvFile implements Writer {
    @Override
    public boolean write(String toFileName, String report) {
        File file = new File(toFileName);
        try {
            file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName));
            bufferedWriter.write(report);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't operate with file" + toFileName, e);
        }
        return true;
    }
}
