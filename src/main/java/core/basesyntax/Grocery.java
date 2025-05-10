package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitMapper;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitMapperImpl;
import core.basesyntax.service.impl.ProcessDataServiceImpl;
import core.basesyntax.service.impl.ReaderFromFileImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.WriterImpl;
import java.util.List;

public class Grocery {
    private static final String INPUT_FILE = "src/main/resources/inputData.csv";
    private static final String OUTPUT_FILE = "src/main/resources/outputData.csv";

    public static void main(String[] args) {
        Reader reader = new ReaderFromFileImpl();
        FruitMapper fruitMapper = new FruitMapperImpl();
        ProcessDataService processDataService = new ProcessDataServiceImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        Writer writer = new WriterImpl();

        List<String> dataFromFile = reader.readFromFile(INPUT_FILE);
        List<Fruit> convertedData = fruitMapper.convert(dataFromFile);

        processDataService.processData(convertedData);
        String report = reportGenerator.createReport();
        writer.write(report,OUTPUT_FILE);
    }
}
