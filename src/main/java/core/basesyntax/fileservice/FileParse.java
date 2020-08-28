package core.basesyntax.fileservice;

import core.basesyntax.model.FruitBatch;
import java.util.List;

public interface FileParse {
    List<FruitBatch> parseList(List<List<String>> list);
}
