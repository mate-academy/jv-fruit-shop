package core.basesyntax.services.work_with_files;

import java.util.List;

public interface DataReaderFromFile {
  List<String> readFromFileAndHoldData(String fromFileName);
}
