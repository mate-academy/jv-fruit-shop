package core.basesyntax.services.work_with_files.impl;

import core.basesyntax.services.work_with_files.DataReaderFromFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReaderFromFileCSVImpl implements DataReaderFromFile {

  @Override
  public List<String> readFromFileAndHoldData(String fromFileName) {
    List<String> rawData = new ArrayList<>();
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFileName))) {
      String line = bufferedReader.readLine();
      while (line != null) {
        rawData.add(line);
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      throw new RuntimeException("Can't read from file", e);
    }
    return rawData;
  }
}
