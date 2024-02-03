package core.basesyntax.db;

import core.basesyntax.db.csv.Reader;
import core.basesyntax.db.csv.Writer;
import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;

public class DbManagerFactory {
    static DbManager<FruitTransactionRow, FruitResultingRow> dbManager;

    public static void initInstance(Reader<FruitTransactionRow> reader,
                             Writer<FruitResultingRow> writer) {
        dbManager = new DbManagerImpl(reader, writer);
    }

    public static DbManager<FruitTransactionRow, FruitResultingRow> getInstance() {
        return dbManager;
    }
}
