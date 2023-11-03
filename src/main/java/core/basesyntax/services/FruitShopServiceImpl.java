package core.basesyntax.services;

import core.basesyntax.serviceinterfaces.FileReader;
import core.basesyntax.serviceinterfaces.Mapper;
import core.basesyntax.serviceinterfaces.ReportCreator;
import core.basesyntax.serviceinterfaces.Writer;
import java.util.List;

public class FruitShopServiceImpl {
    private final FileReader csvReader;
    private final Mapper mapper;
    private final ReportCreator reportCreator;
    private final Writer writer;

    public FruitShopServiceImpl(FileReader csvReader, Mapper mapper,
                                ReportCreator reportCreator, Writer writer) {
        this.csvReader = csvReader;
        this.mapper = mapper;
        this.reportCreator = reportCreator;
        this.writer = writer;
    }

    public void createDailyReport(String fromFile, String toFile) {
        List<String> dataFromFile = csvReader.read(fromFile);
        mapper.mapData(dataFromFile);
        String report = reportCreator.createReport();
        writer.writeToFile(report, toFile);
    }
}

