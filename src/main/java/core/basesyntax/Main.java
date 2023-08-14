package core.basesyntax;

import core.basesyntax.dao.ReadDataFromFile;
import core.basesyntax.dao.ReadDataFromFileImpl;
import core.basesyntax.dao.WriteDataToFile;
import core.basesyntax.dao.WriteDataToFileImpl;
import core.basesyntax.models.Apple;
import core.basesyntax.models.Banana;
import core.basesyntax.models.Fruit;
import core.basesyntax.service.counter.BalanceTypeImpl;
import core.basesyntax.service.counter.OperationType;
import core.basesyntax.service.counter.PurchaseTypeImpl;
import core.basesyntax.service.counter.ReturnTypeImpl;
import core.basesyntax.service.counter.SupplyTypeImpl;
import core.basesyntax.service.result.ResultFromReport;
import core.basesyntax.service.result.ResultFromReportImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, OperationType> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put("b", new BalanceTypeImpl());
        operationStrategyMap.put("s", new SupplyTypeImpl());
        operationStrategyMap.put("p", new PurchaseTypeImpl());
        operationStrategyMap.put("r", new ReturnTypeImpl());
        
        Map<String, Fruit> fruitTypes = new HashMap<>();
        fruitTypes.put("banana", new Banana());
        fruitTypes.put("apple", new Apple());
        
        Map<Fruit, Integer> dataToUpdateReport = new HashMap<>();

        ReadDataFromFile readDataFromFile = new ReadDataFromFileImpl();
        String filePath = "src/main/java/core/basesyntax/resources/Report.csv";
        List<String> dataFromReport = readDataFromFile.getDataFromReport(filePath);

        ResultFromReport resultFromReport = new ResultFromReportImpl();
        resultFromReport.getResultFromReport(dataFromReport, operationStrategyMap,
                dataToUpdateReport, fruitTypes);

        WriteDataToFile writeDataToFile = new WriteDataToFileImpl();
        writeDataToFile.writeDataToFile(dataToUpdateReport);
    }

}
