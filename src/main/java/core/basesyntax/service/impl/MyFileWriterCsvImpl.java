package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MyFileWriterCsvImpl implements MyFileWriter {
    @Override
    public void writeToFile(String filePathForWrite, String dataForWrite) {
        if (dataForWrite == null) {
            throw new RuntimeException("We don't have data for write. Our data null");
        }
        try (Writer csvWriter = new FileWriter(filePathForWrite)) {
            csvWriter.append(dataForWrite);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + filePathForWrite, e);
        } catch (IOException e) {
            throw new RuntimeException("Data couldn't write to file " + filePathForWrite, e);
        }
    }
}
