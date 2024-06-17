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
import service.report.CreateReport;
import service.report.CreateReportImpl;
import service.strategy.TypeStrategy;
import service.strategy.TypeStrategyImpl;
import service.strategy.strategyimpl.BalanceStrategy;
import service.strategy.strategyimpl.PurchaseStrategy;
import service.strategy.strategyimpl.ReturnStrategy;
import service.strategy.strategyimpl.SupplyStrategy;
import service.strategy.strategyimpl.TypeService;
import service.write.FileWrite;
import service.write.FileWriteImpl;

public class HelloWorld {
    private static final String PATH_TO_READ = "src/main/resources/test.csv";
    private static final String PATH_TO_WRITE = "src/main/resources/report.cvs";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        String[] lines = fileReader.readFile(PATH_TO_READ);

        HashMap<FruitRecord.Type, TypeService> typeServiceMap = new HashMap<>();
        typeServiceMap.put(FruitRecord.Type.BALANCE, new BalanceStrategy());
        typeServiceMap.put(FruitRecord.Type.PURCHASE, new PurchaseStrategy());
        typeServiceMap.put(FruitRecord.Type.RETURN, new ReturnStrategy());
        typeServiceMap.put(FruitRecord.Type.SUPPLY, new SupplyStrategy());
        TypeStrategy typeStrategy = new TypeStrategyImpl(typeServiceMap);

        FruitRecordParser fruitRecordParser = new FruitRecordParserImpl();
        List<FruitRecord> fruitRecords = fruitRecordParser.convertToObject(lines);

        DataProcessorService dataProcessorService = new DataProcessorServiceImpl(typeStrategy);
        dataProcessorService.processingData(fruitRecords);

        CreateReport createReport = new CreateReportImpl();
        String report = createReport.getReport();

        FileWrite fileWrite = new FileWriteImpl();
        fileWrite.writeToFile(report, PATH_TO_WRITE);
    }
}
