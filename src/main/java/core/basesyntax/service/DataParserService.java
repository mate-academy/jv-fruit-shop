package core.basesyntax.service;

import core.basesyntax.model.StorageTransaction;
import java.util.List;

public interface DataParserService {
    List<StorageTransaction> parse(List<String> data);
}
