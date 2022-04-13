package core.basesyntax.dao;

import core.basesyntax.service.WriteFile;
import core.basesyntax.service.WriteFileImpl;
import java.util.ArrayList;
import java.util.List;

public class DataToCsvFileImpl implements DataToCsvFile {
    public static final String REPORT_TITLE = "fruit,quantity";
    private final List<String> resultList = new ArrayList<>();
    private final WriteFile writeFile = new WriteFileImpl();

    @Override
    public List<String> generateListToWriteFile(List<String> list, String reportFileCvsFile) {
        resultList.add(REPORT_TITLE);
        resultList.addAll(list);
        writeFile.writeFileReport(resultList, reportFileCvsFile);
        return resultList;

    }
}
