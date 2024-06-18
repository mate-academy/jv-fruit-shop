package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import model.FruitRecord;
import service.parse.FruitRecordParser;
import service.parse.FruitRecordParserImpl;
import service.processor.DataProcessorService;
import service.processor.DataProcessorServiceImpl;
import service.read.FileReader;
import service.read.FileReaderImpl;
import service.report.ReportService;
import service.report.ReportServiceImpl;
import service.strategy.TypeStrategy;
import service.strategy.TypeStrategyImpl;
import service.strategy.strategyimpl.BalanceStrategy;
import service.strategy.strategyimpl.PurchaseStrategy;
import service.strategy.strategyimpl.ReturnStrategy;
import service.strategy.strategyimpl.SupplyStrategy;
import service.strategy.strategyimpl.TypeService;
import service.write.FileWriterService;
import service.write.FileWriterServiceImpl;

public class HelloWorld {
    private static final String PATH_TO_READ = "src/main/resources/test.csv";
    private static final String PATH_TO_WRITE = "src/main/resources/report.cvs";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        String[] lines = fileReader.readFile(PATH_TO_READ);

        HashMap<FruitRecord.Operation, TypeService> typeServiceMap = new HashMap<>();
        typeServiceMap.put(FruitRecord.Operation.BALANCE, new BalanceStrategy());
        typeServiceMap.put(FruitRecord.Operation.PURCHASE, new PurchaseStrategy());
        typeServiceMap.put(FruitRecord.Operation.RETURN, new ReturnStrategy());
        typeServiceMap.put(FruitRecord.Operation.SUPPLY, new SupplyStrategy());
        TypeStrategy typeStrategy = new TypeStrategyImpl(typeServiceMap);

        FruitRecordParser fruitRecordParser = new FruitRecordParserImpl();
        List<FruitRecord> fruitRecords = fruitRecordParser.parseFruitRecords(lines);

        DataProcessorService dataProcessorService = new DataProcessorServiceImpl(typeStrategy);
        dataProcessorService.processData(fruitRecords);

        ReportService createReport = new ReportServiceImpl();
        String report = createReport.getReport();

        FileWriterService fileWrite = new FileWriterServiceImpl();
        fileWrite.writeToFile(report, PATH_TO_WRITE);
    }
}
