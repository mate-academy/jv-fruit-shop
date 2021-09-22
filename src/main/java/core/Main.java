package core;

import core.exception.ValidationException;
import core.model.FruitRecord;
import core.model.OperationType;
import core.service.file.FileService;
import core.service.file.OsFileServiceImpl;
import core.service.market.MarketService;
import core.service.market.MarketServiceImpl;
import core.service.operation.BalanceOperationTypeHandler;
import core.service.operation.OperationTypeHandler;
import core.service.operation.PurchaseOperationTypeHandler;
import core.service.operation.ReturnOperationTypeHandler;
import core.service.operation.SupplyOperationHandler;
import core.service.record.FruitRecordService;
import core.service.record.FruitRecordServiceImpl;
import core.service.report.ReportService;
import core.service.report.ReportServiceImpl;
import core.service.strategy.OperationTypeStrategy;
import core.service.strategy.OperationTypeStrategyImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new OsFileServiceImpl();
        List<String> list = null;
        try {
            list = fileService.readFile("src/main/resources/report_input.csv");
        } catch (IOException e) {
            System.out.println("Can't read file " + FileService.PATH_INPUT + "Exception: " + e);
        }
        list.forEach(System.out::println);

        FruitRecordService fruitRecordService = new FruitRecordServiceImpl();

        List<FruitRecord> fruitRecordList = null;
        try {
            fruitRecordList = fruitRecordService.parserFruit(list);
            fruitRecordService.save(fruitRecordList);
        } catch (ValidationException e) {
            System.out.println("Can't parse data " + "Exception: " + e);
        }

        fruitRecordList.forEach(s -> System.out.println(s + "     *******"));
        Map<OperationType, OperationTypeHandler> recordMap = new HashMap<>();
        recordMap.put(OperationType.BALANCE, new BalanceOperationTypeHandler());
        recordMap.put(OperationType.PURCHASE, new PurchaseOperationTypeHandler());
        recordMap.put(OperationType.RETURN, new ReturnOperationTypeHandler());
        recordMap.put(OperationType.SUPPLY, new SupplyOperationHandler());

        OperationTypeStrategy operationTypeStrategy = new OperationTypeStrategyImpl(recordMap);
        MarketService marketService = new MarketServiceImpl(operationTypeStrategy);

        try {
            marketService.applyOperations(fruitRecordList);
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        ReportService reportService = new ReportServiceImpl();
        List<String> report = reportService.createReport();

        reportService.writeReport(report, ReportService.PATH_OUTPUT);
        report.forEach(System.out::println);
    }
}
