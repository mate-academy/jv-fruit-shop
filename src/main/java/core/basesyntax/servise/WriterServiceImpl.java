package core.basesyntax.servise;

import core.basesyntax.files.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WriterServiceImpl implements WriterService {
    private final Writer writer;

    public WriterServiceImpl(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void writeData(Map<String, Integer> map) {
        List<String> resultList = new ArrayList<>();
        resultList.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            resultList.add(entry.getKey() + "," + entry.getValue());
        }
        writer.write(resultList);
    }
}
