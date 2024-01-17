package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.List;

public interface UniqueFruitsAdderService {
    void add(List<String> readFile, Storage storage);
}
