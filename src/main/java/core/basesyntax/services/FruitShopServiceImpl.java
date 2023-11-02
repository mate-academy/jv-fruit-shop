package core.basesyntax.services;

import core.basesyntax.serviceinterfaces.CsvMapper;
import core.basesyntax.serviceinterfaces.FileReader;
import core.basesyntax.serviceinterfaces.ReportCreator;
import core.basesyntax.serviceinterfaces.Writer;
import java.util.List;

public class FruitShopServiceImpl {
    private final FileReader csvReader;
    private final CsvMapper csvMapper;
    private final ReportCreator reportCreator;
    private final Writer writer;

    public FruitShopServiceImpl(FileReader csvReader, CsvMapper csvMapper,
                                ReportCreator reportCreator, Writer writer) {
        this.csvReader = csvReader;
        this.csvMapper = csvMapper;
        this.reportCreator = reportCreator;
        this.writer = writer;
    }

    public void createDailyReport(String fromFile, String toFile) {
        List<String> dataFromFile = csvReader.read(fromFile);
        csvMapper.mapData(dataFromFile);
        String report = reportCreator.createReport();
        writer.writeToFile(report, toFile);
    }
}

