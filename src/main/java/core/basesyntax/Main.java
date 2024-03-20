package core.basesyntax;

import core.basesyntax.repository.Storage;
import core.basesyntax.repository.StorageImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.parser.CsvParser;
import core.basesyntax.service.parser.CsvParserImpl;
import core.basesyntax.service.reader.CsvReader;
import core.basesyntax.service.reader.CsvReaderImpl;
import core.basesyntax.service.report.ReportGenerator;
import core.basesyntax.service.report.ReportGeneratorImpl;
import core.basesyntax.service.storage.StorageService;
import core.basesyntax.service.storage.StorageServiceImpl;
import core.basesyntax.service.writer.CsvWriter;
import core.basesyntax.service.writer.CsvWriterImpl;
import core.basesyntax.strategy.StrategySupplier;
import java.nio.file.Path;

public class Main {
    private static final Path FROM_FILE = Path.of("/Users/aleksejgaevoj/projects/fruits.csv");
    private static final Path TO_FILE = Path.of("/Users/aleksejgaevoj/projects/new.csv");

    public static void main(String[] args) {
        CsvReader csvReader = new CsvReaderImpl();
        CsvParser csvParser = new CsvParserImpl();
        Storage storage = new StorageImpl();
        StrategySupplier changesStrategy = new StrategySupplier();
        StorageService storageService = new StorageServiceImpl(storage, changesStrategy);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        CsvWriter csvWriter = new CsvWriterImpl();
        FruitService fruitService = new FruitServiceImpl(
                csvReader, csvParser, storageService, storage, reportGenerator, csvWriter);
        fruitService.processCsvFile(FROM_FILE, TO_FILE);
    }
}
