package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.repository.Storage;
import core.basesyntax.service.parser.CsvParser;
import core.basesyntax.service.reader.CsvReader;
import core.basesyntax.service.report.ReportGenerator;
import core.basesyntax.service.storage.StorageService;
import core.basesyntax.service.writer.CsvWriter;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final CsvReader csvReader;
    private final CsvParser csvParser;
    private final StorageService storageService;
    private final Storage storage;
    private final ReportGenerator reportGenerator;
    private final CsvWriter csvWriter;

    public FruitServiceImpl(CsvReader csvReader, CsvParser csvParser,
                            StorageService storageService, Storage storage,
                            ReportGenerator reportGenerator, CsvWriter csvWriter) {
        this.csvReader = csvReader;
        this.csvParser = csvParser;
        this.storageService = storageService;
        this.storage = storage;
        this.reportGenerator = reportGenerator;
        this.csvWriter = csvWriter;
    }

    @Override
    public void processCsvFile(Path fromFile, Path toFile) {
        List<String> lines = csvReader.readFile(fromFile);
        List<FruitTransaction> fruits = csvParser.parseFruits(lines);
        storageService.transfer(fruits);
        Map<String, Integer> storageAll = storage.getAll();
        List<String> generated = reportGenerator.generate(storageAll);
        csvWriter.writeToFile(toFile, generated);
    }
}
