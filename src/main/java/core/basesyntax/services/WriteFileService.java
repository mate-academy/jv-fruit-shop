package core.basesyntax.services;

import core.basesyntax.dao.StoreDao;

import java.util.Map;

public interface WriteFileService {
    void writeToFile(StoreDao dao, String fileName);
}
