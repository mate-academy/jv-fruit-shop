package core.basesyntax;

import core.basesyntax.factory.Factory;
import core.basesyntax.factory.impl.FactoryImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ConvertService;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ConvertServiceImpl;
import core.basesyntax.service.impl.ProcessDataServiceImpl;
import core.basesyntax.service.impl.ReaderServiceFromFileImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Grocery {
    private static final String INPUT_FILE = "src/main/resources/inputData.csv";
    private static Factory factory = new FactoryImpl();

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceFromFileImpl();
        ConvertService convertService = new ConvertServiceImpl();
        ProcessDataService processDataService = new ProcessDataServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        readerService.readFromFile(INPUT_FILE);
        List<Fruit> convertedData = convertService.convert(readerService.getData());
        processDataService.processData(convertedData, factory);
        String report = reportService.createReport();
        writerService.write(report);
    }
}
