package core.basesyntax;


import core.basesyntax.operations.*;
import core.basesyntax.service.*;
import core.basesyntax.serviceImpl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReadFromFile fileReader = new ReadFromCsvFileImpl();
        List<String> importInfo = fileReader.readFromFile("importFile.csv");
        ImportOperations importOperations = new ImportOperationsImpl();
        List<String[]> listOfOperations = importOperations.getOperations(importInfo);

        Map<String, Operation> operationMap = new HashMap<>();
        operationMap.put("s", new SupplyOperation());
        operationMap.put("r", new ReturnOperation());
        operationMap.put("b", new BalanceOperation());
        operationMap.put("p", new PurchaseOperation());
        FruitOperationStrategy fruitOperationStrategy = new FruitOperationStrategyImpl(operationMap);

        DoOperations doOperations = new DoOperationImpl(fruitOperationStrategy);
        doOperations.closeAllOperations(listOfOperations);
        CreateExportInfo exportReport = new CreateExportInfoImpl();
        String report = exportReport.createReport();
        WriteFile writeFile = new WriteCsvFileImpl();
        writeFile.writeFile(report, "exportFile.csv");
    }
}
