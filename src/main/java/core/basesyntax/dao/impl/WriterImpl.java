package core.basesyntax.dao.impl;

import core.basesyntax.dao.Writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class WriterImpl implements Writer {
    @Override
    public void WriteDataToFile(String data, String fileName) {
      File report = new File(fileName);
      try {
        report.createNewFile();
        Files.write(report.toPath(), data.getBytes(), StandardOpenOption.APPEND);
      } catch (IOException e) {
        throw new RuntimeException("Can't create new file or write to to it", e);
      }
    }
}
