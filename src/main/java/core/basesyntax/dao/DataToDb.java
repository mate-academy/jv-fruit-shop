package core.basesyntax.dao;

import java.util.List;

public interface DataToDb {

    String REPORT_TITLE = "fruit,quantity";

    void generateListToWriteFile(List<String> list);
}
