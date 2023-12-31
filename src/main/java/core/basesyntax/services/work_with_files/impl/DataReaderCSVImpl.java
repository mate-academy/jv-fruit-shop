package core.basesyntax.services.work_with_files.impl;

import core.basesyntax.services.work_with_files.DataReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReaderCSVImpl implements DataReader {

  @Override
  public StringBuilder readFromFileAndHoldData(String fromFileName) {
    StringBuilder rawData = new StringBuilder();
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFileName))) {
      String line = bufferedReader.readLine();
      while (line != null) {
        rawData.append(line).append(",");
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      throw new RuntimeException("Can't read from file", e);
    }
    return rawData;
  }
}
