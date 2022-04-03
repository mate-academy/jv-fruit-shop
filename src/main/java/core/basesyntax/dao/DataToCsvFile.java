package core.basesyntax.dao;

import java.util.List;

public interface DataToCsvFile {

    String REPORT_TITLE = "fruit,quantity";

    void generateListToWriteFile(List<String> list);
}
