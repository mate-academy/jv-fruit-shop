package core.basesyntax.infratructure.db;

import core.basesyntax.service.Operation;
import java.io.IOException;

public interface InsertListDao {
    void writeInfo(Operation operation, String fruitName, int amount) throws IOException;
}
