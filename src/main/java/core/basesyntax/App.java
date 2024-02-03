package core.basesyntax;

import core.basesyntax.db.DbManagerImpl;
import core.basesyntax.db.csv.Reader;
import core.basesyntax.db.csv.Writer;
import core.basesyntax.db.csv.impl.CsvReaderImpl;
import core.basesyntax.db.csv.impl.CsvWriterImpl;
import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ReportSaver;
import core.basesyntax.service.ReportSaverImpl;
import java.io.File;
import java.util.Map;

public class App {
    private static final String INPUT_FILE_PATH =
            "src/main/resources" + File.separator + "input.csv";
    private static final String OUTPUT_FILE_PATH =
            "src/main/resources" + File.separator + "output.csv";
    private static final String OUTPUT_FILE_COLUMN_NAMES = "fruit,quantity";

    public static void main(String[] args) {
        Reader<FruitTransactionRow> reader = new CsvReaderImpl(INPUT_FILE_PATH);
        Writer<FruitResultingRow> writer =
                new CsvWriterImpl(OUTPUT_FILE_PATH, OUTPUT_FILE_COLUMN_NAMES);
        DbManagerImpl.createInstance(reader, writer);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        ReportSaver reportSaver = new ReportSaverImpl();
        Map<String, Integer> reportAboutFruits =
                reportGenerator.generate(DbManagerImpl.getInstance().getAll());
        reportSaver.saveReport(reportAboutFruits);
    }
}
