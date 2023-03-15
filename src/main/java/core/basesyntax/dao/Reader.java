package core.basesyntax.dao;

import java.io.File;
import java.util.List;

public interface Reader {
  public List<String> readDataFromFile(File file);
}
