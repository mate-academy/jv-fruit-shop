package core.basesyntax;

import core.basesyntax.db.DbManager;
import core.basesyntax.db.DbManagerImpl;
import core.basesyntax.db.csv.Reader;
import core.basesyntax.db.csv.Writer;
import core.basesyntax.db.csv.impl.CsvReaderImpl;
import core.basesyntax.db.csv.impl.CsvWriterImpl;
import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;

import java.io.File;

public class App {
    private static final String resourcesFolderPath = "src/main/resources";
    private static final String pathInput = resourcesFolderPath + File.separator + "input.csv";
    private static final String pathOutput = resourcesFolderPath + File.separator + "output.csv";
    public static void main(String[] args) {
        Reader<FruitTransactionRow> reader = new CsvReaderImpl(pathInput);
        Writer<FruitResultingRow> writer = new CsvWriterImpl(pathOutput);
        DbManagerImpl.createInstance(reader, writer);
        DbManager<FruitTransactionRow, FruitResultingRow> dbManager = DbManagerImpl.getInstance();
        dbManager.getAll().forEach(System.out::println);
    }
}
