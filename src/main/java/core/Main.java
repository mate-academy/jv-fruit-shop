package core;

import core.model.FruitRecord;
import core.model.OperationType;
import core.service.file.FileService;
import core.service.file.OsFileServiceImpl;
import core.service.file.WriteToFileService;
import core.service.file.WriteToFileServiceImpl;
import core.service.market.MarketService;
import core.service.market.MarketServiceImpl;
import core.service.operation.BalanceOperationTypeHandler;
import core.service.operation.OperationTypeHandler;
import core.service.operation.PurchaseOperationTypeHandler;
import core.service.operation.ReturnOperationTypeHandler;
import core.service.operation.SupplyOperationHandler;
import core.service.record.FruitRecordService;
import core.service.record.FruitRecordServiceImpl;
import core.service.report.CreateReportService;
import core.service.report.CreateReportServiceImpl;
import core.service.strategy.OperationTypeStrategy;
import core.service.strategy.OperationTypeStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String PATH_INPUT = "src/main/resources/report_input.csv";
    public static final String PATH_OUTPUT = "src/main/resources/report_output.csv";

    public static void main(String[] args) {
        FileService fileService = new OsFileServiceImpl();
        List<String> list = fileService.readFile(PATH_INPUT);
        FruitRecordService fruitRecordService = new FruitRecordServiceImpl();

        Map<OperationType, OperationTypeHandler> recordMap = new HashMap<>();
        recordMap.put(OperationType.BALANCE, new BalanceOperationTypeHandler());
        recordMap.put(OperationType.PURCHASE, new PurchaseOperationTypeHandler());
        recordMap.put(OperationType.RETURN, new ReturnOperationTypeHandler());
        recordMap.put(OperationType.SUPPLY, new SupplyOperationHandler());

        List<FruitRecord> fruitRecordList = fruitRecordService.parserFruit(list);
        OperationTypeStrategy operationTypeStrategy = new OperationTypeStrategyImpl(recordMap);
        MarketService marketService = new MarketServiceImpl(operationTypeStrategy);
        marketService.applyOperations(fruitRecordList);

        CreateReportService reportService = new CreateReportServiceImpl();
        List<String> report = reportService.createReport();

        WriteToFileService writeToFileService = new WriteToFileServiceImpl();
        writeToFileService.writeReport(report, PATH_OUTPUT);
    }
}
