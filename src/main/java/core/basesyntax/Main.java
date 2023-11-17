package core.basesyntax;

import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ConvertDataService;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteDataToFileService;
import core.basesyntax.service.impl.ConvertDataServiceImpl;
import core.basesyntax.service.impl.ProcessDataServiceImpl;
import core.basesyntax.service.impl.ReadDataFromFileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteDataToFileServiceImpl;
import core.basesyntax.service.strategy.impl.OperationResolverImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TRANSACTIONS = "src/main/resources/balanceFruits.csv";
    private static final String PATH_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {

        Map<String, Operation> operationMap = new HashMap<>();
        operationMap.put("b", Operation.BALANCE);
        operationMap.put("s", Operation.SUPPLY);
        operationMap.put("p", Operation.PURCHASE);
        operationMap.put("r", Operation.RETURN);

        ReadDataFromFileServiceImpl readDataFromFile = new ReadDataFromFileServiceImpl();
        List<String> listDataFromFile = readDataFromFile.readFromFile(PATH_TRANSACTIONS);

        ConvertDataService convertData =
                new ConvertDataServiceImpl(new OperationResolverImpl(operationMap));
        List<FruitTransaction> operations = convertData.processingData(listDataFromFile);

        ProcessDataService processDataService = new ProcessDataServiceImpl(new StorageDaoImpl());
        Map<String, Integer> reportMap = processDataService.processing(operations);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.prepareReport(reportMap);

        WriteDataToFileService writeDataToFile = new WriteDataToFileServiceImpl();
        writeDataToFile.writeData(PATH_REPORT, report);

    }
}
