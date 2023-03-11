package core.basesyntax.service;

import core.basesyntax.model.StorageTransaction;
import java.util.List;

public interface DataParseService {
    List<StorageTransaction> getParsedData(List<String> data);
}
