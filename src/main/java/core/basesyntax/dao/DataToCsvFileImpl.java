package core.basesyntax.dao;

import core.basesyntax.db.WriteFile;
import core.basesyntax.db.WriteFileImpl;
import java.util.ArrayList;
import java.util.List;

public class DataToCsvFileImpl implements DataToCsvFile {
    public static final String REPORT_FILE_CSV_PATH = "src/main/resources/daylireport.csv";
    private final List<String> resultList = new ArrayList<>();
    private final WriteFile writeFile = new WriteFileImpl();

    @Override
    public void generateListToWriteFile(List<String> list) {
        resultList.add(REPORT_TITLE);
        resultList.addAll(list);
        writeFile.writeFileReport(resultList, REPORT_FILE_CSV_PATH);
    }
}
