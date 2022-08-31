package core.basesyntax;

import core.basesyntax.dao.InsertDataToBase;
import core.basesyntax.dao.ReadDataFromFile;
import core.basesyntax.dao.WriteDataToFile;
import core.basesyntax.dao.impl.InsertDataToBaseImpl;
import core.basesyntax.dao.impl.ReadDataFromFileImpl;
import core.basesyntax.dao.impl.WriteDataToFileImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.GetStorageStatistic;
import core.basesyntax.service.ReportGeneration;
import core.basesyntax.service.impl.GetStorageStatisticImpl;
import core.basesyntax.service.impl.ReportGenerationImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.OperationHandlerImplBalance;
import core.basesyntax.strategy.impl.OperationHandlerImplPurchase;
import core.basesyntax.strategy.impl.OperationHandlerImplReturn;
import core.basesyntax.strategy.impl.OperationHandlerImplStrategy;
import core.basesyntax.strategy.impl.OperationHandlerImplSupply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String writeFrom = "src/main/java/core/basesyntax/resourses/database.csv";
        final String writeTo = "src/main/java/core/basesyntax/resourses/result.csv";
        /* Create Strategy Map */
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new OperationHandlerImplBalance());
        operationHandlerMap.put("p", new OperationHandlerImplPurchase());
        operationHandlerMap.put("r", new OperationHandlerImplReturn());
        operationHandlerMap.put("s", new OperationHandlerImplSupply());

        /* Read data from csv file */
        ReadDataFromFile getDataBase = new ReadDataFromFileImpl();
        List<String> list = getDataBase.getFromDatabase(writeFrom);

        /* Insert data to Storage as transactions (parsing) list<Transaction/> */
        InsertDataToBase insertDataToBase = new InsertDataToBaseImpl();
        insertDataToBase.addTransferToStorage(list);

        /* Get statistic from transactions and compile it to Map as a result with counting */
        GetStorageStatistic getStorageStatistic =
                new GetStorageStatisticImpl(new OperationHandlerImplStrategy(operationHandlerMap));
        Map<String,Integer> resultOfStatistic =
                getStorageStatistic.getStorageStatistic(Storage.transactions);

        /* Generate report */
        ReportGeneration reportGeneration = new ReportGenerationImpl();
        String report = reportGeneration.generateReport(resultOfStatistic);

        /* Write result to csv file */
        WriteDataToFile writeDataToFile = new WriteDataToFileImpl();
        writeDataToFile.writeDataToFile(report, writeTo);
    }
}
