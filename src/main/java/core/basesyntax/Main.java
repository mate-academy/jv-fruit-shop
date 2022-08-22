package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.cvs.CsvParseService;
import core.basesyntax.service.cvs.CsvParseServiceImpl;
import core.basesyntax.service.cvs.CsvReportService;
import core.basesyntax.service.cvs.CsvReportServiceImpl;
import core.basesyntax.service.cvs.ReaderService;
import core.basesyntax.service.cvs.ReaderServiceImpl;
import core.basesyntax.service.cvs.WriterService;
import core.basesyntax.service.cvs.WriterServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.service.report.FruitReportService;
import core.basesyntax.service.report.FruitReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FILE_IN = "src\\resources\\fruit-shop.csv";
    public static final String FILE_REPORT = "src\\resources\\fruit-shop-report.csv";

    public static void main(String[] args) {
        //read file
        ReaderService read = new ReaderServiceImpl();
        List<String> fileIn = read.readFromFile(FILE_IN);
        //csv -> List
        CsvParseService csvFileReaderService = new CsvParseServiceImpl();
        List<FruitTransaction> fruits = csvFileReaderService.getFruitsFromCsv(fileIn);
        //allFruits to Storage
        Map<Operation, OperationHandler> map = getMapStategy();
        OperationStrategy operationStrategy = new OperationStrategyImpl(map);
        FruitReportService fruitServiceN = new FruitReportServiceImpl(operationStrategy);
        fruitServiceN.handleAll(fruits);
        //getReport
        CsvReportService w = new CsvReportServiceImpl();
        String report = w.getReport();
        //writeReport to File
        WriterService wr = new WriterServiceImpl(w);
        wr.writeReportToFile(FILE_REPORT);
    }

    public static Map<Operation, OperationHandler> getMapStategy() {
        Map<Operation, OperationHandler> map = new HashMap<>();
        map.put(Operation.BALANCE, new BalanceOperationHandler());
        map.put(Operation.SUPPLY, new SupplyOperationHandler());
        map.put(Operation.PURCHASE, new PurchaseOperationHandler());
        map.put(Operation.RETURN, new ReturnOperationHandler());
        return map;
    }
}
