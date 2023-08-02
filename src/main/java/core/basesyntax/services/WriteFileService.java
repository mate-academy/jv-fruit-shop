package core.basesyntax.services;

import core.basesyntax.dao.StoreDao;

public interface WriteFileService {
    void writeToFile(StoreDao dao, String fileName);
}
