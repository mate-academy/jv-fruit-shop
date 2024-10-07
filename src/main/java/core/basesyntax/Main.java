package core.basesyntax;

import model.FruitRecord;
import service.parse.DataParser;
import service.parse.DataParserImpl;
import service.read.FileReaderImpl;
import service.report.ReportService;
import service.report.ReportServiceImpl;
import service.strategy.TypeStrategy;
import service.strategy.TypeStrategyImpl;
import service.strategy.strategyimpl.*;
import service.write.FileWriter;
import service.write.FileWriterImpl;

import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String PATH_TO_READ = "src/main/resources/test.csv";
    private static final String PATH_TO_WRITE = "src/main/resources/report.cvs";

    public static void main(String[] args) {
        // 1. Read the data from the CSV file
        service.read.FileReader fileReader = new FileReaderImpl();

        List<String> inputReport = fileReader.read(PATH_TO_READ);

        // 2. Map operations to handlers
        HashMap<FruitRecord.Operation, OperationHandler> typeServiceMap = new HashMap<>();
        typeServiceMap.put(FruitRecord.Operation.BALANCE, new BalanceOperation());
        typeServiceMap.put(FruitRecord.Operation.PURCHASE, new PurchaseOperation());
        typeServiceMap.put(FruitRecord.Operation.RETURN, new ReturnOperation());
        typeServiceMap.put(FruitRecord.Operation.SUPPLY, new SupplyOperation());

        // 3. Create TypeStrategy
        TypeStrategy typeStrategy = new TypeStrategyImpl(typeServiceMap);

        // 4. Parse FruitRecords
        DataParser fruitRecordParser = new DataParserImpl();
        List<FruitRecord> fruitRecords = fruitRecordParser.parseFruitRecords(inputReport);

        // 5. Generate report based on the current Storage state
        ReportService reportService = new ReportServiceImpl();
        String resultReport = reportService.getReport(fruitRecords);

        //6. Write the report to the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultReport, PATH_TO_WRITE);

    }
}
