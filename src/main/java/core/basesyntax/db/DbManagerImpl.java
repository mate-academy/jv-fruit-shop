package core.basesyntax.db;

import core.basesyntax.db.csv.Reader;
import core.basesyntax.db.csv.Writer;
import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;

import java.util.List;

public class DbManagerImpl implements DbManager<FruitTransactionRow, FruitResultingRow> {
    private static DbManager<FruitTransactionRow, FruitResultingRow> dbManager;
    private final Reader<FruitTransactionRow> reader;
    private final Writer<FruitResultingRow> writer;

    private DbManagerImpl(Reader<FruitTransactionRow> reader,
                          Writer<FruitResultingRow> writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static void createInstance(Reader<FruitTransactionRow> reader,
                                      Writer<FruitResultingRow> writer) {
        if (dbManager == null) {
            dbManager = new DbManagerImpl(reader, writer);
        } else {
            throw new RuntimeException("Illegal action. Cannot initialize DbManager second time");
        }
    }

    public static DbManager<FruitTransactionRow, FruitResultingRow> getInstance() {
        return dbManager;
    }

    @Override
    public List<FruitTransactionRow> getAll() {
        return reader.readAll();
    }

    @Override
    public void putAll(List<FruitResultingRow> resultingRows) {
        writer.writeAll(resultingRows);
    }
}
