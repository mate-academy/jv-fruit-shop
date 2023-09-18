package core.basesyntax.storage;

import core.basesyntax.service.workwithfile.ParseFile;
import core.basesyntax.service.workwithfile.ReadFileImpl;
import java.util.List;

public class PrepareList {
    private static final int TITLE_INDEX = 0;
    private final ParseFile parseFile = new ParseFile();
    private final ReadFileImpl readFile = new ReadFileImpl();

    public List<String> preparedListWithoutTitle() {
        List<String> operationList = readFile.readFromCsvFile(parseFile.parseFileWithData());
        operationList.remove(TITLE_INDEX);
        return operationList;
    }
}
