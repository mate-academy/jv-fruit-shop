package core.basesyntax.db;

import core.basesyntax.db.csv.Reader;
import core.basesyntax.db.csv.Writer;
import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;
import java.util.List;

public class DbManagerImpl implements DbManager<FruitTransactionRow, FruitResultingRow> {
    private final Reader<FruitTransactionRow> reader;
    private final Writer<FruitResultingRow> writer;

    DbManagerImpl(Reader<FruitTransactionRow> reader,
                          Writer<FruitResultingRow> writer) {
        this.reader = reader;
        this.writer = writer;
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
