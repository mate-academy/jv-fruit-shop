package core.basesyntax.services.work_with_files.impl;

import core.basesyntax.services.work_with_files.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileWriterImpl implements FileWriter {
  @Override
  public void writeToFile(StringBuilder stringBuilder) {
    String reportNameByTime = "report";
    File currentReport = new File(reportNameByTime);
    BufferedWriter bufferedWriter = null;
    if (!currentReport.exists()) {
      try {
        bufferedWriter = new BufferedWriter(new java.io.FileWriter(reportNameByTime, true));
        bufferedWriter.write(String.valueOf(stringBuilder));
      } catch (IOException e) {
        throw new RuntimeException("Can't write to file", e);
      } finally {
        if (bufferedWriter != null) {
          try {
            bufferedWriter.close();
          } catch (IOException e) {
            throw new RuntimeException("Can't close BufferedWriter", e);
          }
        }
      }
    }
  }
}
