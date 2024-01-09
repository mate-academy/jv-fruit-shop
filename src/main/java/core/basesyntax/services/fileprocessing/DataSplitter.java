package core.basesyntax.services.fileprocessing;

import java.util.List;

public interface DataSplitter {
    List<String[]> divideData(List<String> rawData);
}
