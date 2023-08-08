package core.basesyntax.data.processing;

import java.util.ArrayList;
import java.util.List;

public class DataProcessingImpl implements DataProcessing {

    @Override
    public List<String[]> process(List<String> lines) {
        List<String[]> fruitInfo = new ArrayList<>();
        for (String line : lines) {
            String[] dataParts = line.split(",");
            fruitInfo.add(dataParts);
        }
        return fruitInfo;
    }
}
