package core.basesyntax;

import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileWriter;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.service.ServiceReport;
import core.basesyntax.service.ServiceReportImpl;
import core.basesyntax.service.StorageServiceImpl;
import core.basesyntax.service.operations.BalanceOperationHandler;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseOperationHandler;
import core.basesyntax.service.operations.ReturnOperationHandler;
import core.basesyntax.service.operations.SupplyOperationHandler;
import core.basesyntax.strategy.OperatioHandlerStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String PATH_INPUT = "src/main/resources/input.csv";
    private static final String PATH_OUTPUT = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> listOperations = new HashMap<>();
        listOperations.put("b", new BalanceOperationHandler());
        listOperations.put("s", new SupplyOperationHandler());
        listOperations.put("p", new PurchaseOperationHandler());
        listOperations.put("r", new ReturnOperationHandler());

        StorageServiceImpl storageService =
                new StorageServiceImpl(new OperatioHandlerStrategyImpl(listOperations));

        FileReader getInfoDao = new FileReaderImpl();
        List<String> daysOperations = getInfoDao.getData(PATH_INPUT);
        for (int i = 1; i < daysOperations.size(); i++) {
            String[] tmp = daysOperations.get(i).split(",");
            storageService.operation(tmp[0], tmp[1], Integer.parseInt(tmp[2]));
        }
        FileWriter putInfoDao = new FileWriterImpl();
        ServiceReport serviceReport = new ServiceReportImpl();
        putInfoDao.putData(PATH_OUTPUT, serviceReport.makeReport());
    }
}
