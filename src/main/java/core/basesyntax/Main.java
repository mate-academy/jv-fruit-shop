package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConvertService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.ReportGenerationService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConvertServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.OperationStrategyServiceImpl;
import core.basesyntax.service.impl.ReportGenerationServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFile = "src/main/java/input.csv";
        String outputFile = "src/main/java/output3.csv";

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        DataConvertService dataConvertService = new DataConvertServiceImpl();
        OperationStrategyService operationStrategyService = new OperationStrategyServiceImpl();
        ShopService service = new ShopServiceImpl(operationStrategyService);
        ReportGenerationService generationService = new ReportGenerationServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();

        List<String> lines = fileReaderService.readFromFile(inputFile);
        List<FruitTransaction> transactions = dataConvertService.convertTransactions(lines);
        service.processTransactions(transactions);
        Map<String, Integer> reportData = service.getReportData();
        String report = generationService.generateReport(reportData);
        fileWriterService.writeToFile(report, outputFile);
    }
}

