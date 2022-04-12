package core.basesyntax.dao;

import java.util.List;

public interface DataToCsvFile {
    List<String> generateListToWriteFile(List<String> list, String reportFileCvsFile);
}
