package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.CsvFruitDataReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.StrategyServiceImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String fileFrom = "src\\resources\\file.csv";
    private static final String fileTo = "src\\resources\\report.csv";
    private static final Map<String, Integer> storage = new Storage().getStorageData();
    private static final CsvFruitDataReaderImpl dataReader = new CsvFruitDataReaderImpl();
    private static final StrategyServiceImpl service = new StrategyServiceImpl();
    private static final ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private static final FileWriterService fileWriterService = new FileWriterImpl();

    public static void main(String[] args) {
        List<FruitTransactionDto> fruitTransactionDtoList = dataReader.readData(fileFrom);
        service.processData(fruitTransactionDtoList);
        List<String> report = reportGenerator.createReport(storage);
        fileWriterService.write(report, fileTo);

        System.out.println(reportGenerator.createReport(storage));
        System.out.println(Storage.fruitStorage);
    }
}
