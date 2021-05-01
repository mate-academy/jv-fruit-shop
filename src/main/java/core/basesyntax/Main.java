package core.basesyntax;

import dao.FruitsDao;
import dao.FruitsDaoImpl;
import java.util.HashMap;
import java.util.Map;
import service.FruitRecordParserService;
import service.OperationStrategy;
import service.ReportService;
import service.StoreService;
import service.file.FileReader;
import service.file.FileReaderImpl;
import service.impl.FruitRecordParserServiceImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ReportServiceImpl;
import service.impl.StoreServiceImpl;
import service.operation.AddOperation;
import service.operation.AddOrCreateOperation;
import service.operation.CreateOperation;
import service.operation.Operation;
import service.operation.RemoveOperation;

public class Main {
    public static void main(String[] args) {
        FruitsDao fruitsDao = new FruitsDaoImpl();

        Map<String, Operation> map = new HashMap<>();

        map.put("b", new CreateOperation(fruitsDao));
        map.put("p", new RemoveOperation(fruitsDao));
        map.put("s", new AddOperation(fruitsDao));
        map.put("r", new AddOrCreateOperation(fruitsDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(map);
        FileReader fileReader = new FileReaderImpl();
        FruitRecordParserService recordService = new FruitRecordParserServiceImpl();
        StoreService storeService = new StoreServiceImpl(operationStrategy);
        storeService.doInstruction(recordService.getRecord(fileReader.readFile("src/store.csv")));

        ReportService reportService = new ReportServiceImpl();
        reportService.createReport("src/report.csv");
    }
}
