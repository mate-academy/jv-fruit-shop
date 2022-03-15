package core.basesyntax.implementation;

import core.basesyntax.file.FileWriter;
import core.basesyntax.service.WriterService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WriterServiceImpl implements WriterService {
    private static final String FIELDS_NAMES = "fruit,quantity";
    private static final String COMA = ",";
    private final FileWriter fileWriter;
    private final String filePath;

    public WriterServiceImpl(FileWriter fileWriter, String filePath) {
        this.fileWriter = fileWriter;
        this.filePath = filePath;
    }

    @Override
    public void writeData(Map<String, Integer> map) {
        List<String> resultList = new ArrayList<>();
        resultList.add(FIELDS_NAMES);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            resultList.add(entry.getKey() + COMA + entry.getValue());
        }
        fileWriter.write(resultList, filePath);
    }
}
