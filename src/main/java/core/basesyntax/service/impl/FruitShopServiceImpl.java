package core.basesyntax.service.impl;

import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportGeneratorService;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final DataReaderService dataReader;
    private final ReportGeneratorService reportGenerator;
    private final DataWriterService dataWriter;

    public FruitShopServiceImpl(DataReaderService dataReader,
                                ReportGeneratorService reportGenerator,
                                DataWriterService dataWriter) {
        this.dataReader = dataReader;
        this.reportGenerator = reportGenerator;
        this.dataWriter = dataWriter;
    }

    public void makeReport(String fromFileName, String toFileName) {
        List<String> data = dataReader.readFromFile(fromFileName);
        String report = reportGenerator.generateReport(data);
        dataWriter.writeToFile(toFileName, report);
    }
}
