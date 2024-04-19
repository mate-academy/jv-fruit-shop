package core.basesyntax.service;

import core.basesyntax.dao.reader.ReaderCsv;
import core.basesyntax.dao.writer.WriterCsv;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.parser.ParserCsv;
import core.basesyntax.service.report.ReportService;
import core.basesyntax.service.storage.StorageService;
import java.nio.file.Path;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final ReaderCsv csvReader;
    private final ParserCsv csvParser;
    private final StorageService storageService;
    private final FruitStorage storage;
    private final ReportService reportGenerator;
    private final WriterCsv csvWriter;

    public FruitServiceImpl(ReaderCsv csvReader, ParserCsv csvParser,
                            StorageService storageService, FruitStorage storage,
                            ReportService reportGenerator, WriterCsv csvWriter) {
        this.csvReader = csvReader;
        this.csvParser = csvParser;
        this.storageService = storageService;
        this.storage = storage;
        this.reportGenerator = reportGenerator;
        this.csvWriter = csvWriter;
    }

    @Override
    public void countToCsv(Path fromFile, Path toFile) {
        List<String> lines = csvReader.read(fromFile);
        List<FruitTransaction> fruits = csvParser.parseTransactions(lines);
        storageService.transfer(fruits);
        List<String> report = reportGenerator.report(storage.getAll());
        csvWriter.writeToFile(toFile, report);
    }
}
