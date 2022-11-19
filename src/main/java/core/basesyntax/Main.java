package core.basesyntax;

import core.basesyntax.dao.GetFromFile;
import core.basesyntax.dao.IGetInfoDao;
import core.basesyntax.dao.IPutInfoDao;
import core.basesyntax.dao.PutInFile;
import core.basesyntax.service.IServiceReport;
import core.basesyntax.service.IStorageService;
import core.basesyntax.service.ServiceReport;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.operations.BalanceOperationHanler;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseOperationHanler;
import core.basesyntax.service.operations.ReturnOperationHanler;
import core.basesyntax.service.operations.SupplyOperationHanler;
import core.basesyntax.strategy.OperationHandlerStrategy;
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
        listOperations.put("b", new BalanceOperationHanler());
        listOperations.put("s", new SupplyOperationHanler());
        listOperations.put("p", new PurchaseOperationHanler());
        listOperations.put("r", new ReturnOperationHanler());

        IStorageService storageService = new StorageService(new OperationHandlerStrategy(listOperations));

        IGetInfoDao getInfoDao = new GetFromFile();
        List<String> daysOperations = getInfoDao.getData(PATH_INPUT);
        for (int i = 1; i < daysOperations.size(); i++) {
            String[] tmp = daysOperations.get(i).split(",");
            storageService.operation(tmp[0], tmp[1], Integer.parseInt(tmp[2]));
        }
        IPutInfoDao putInfoDao = new PutInFile();
        IServiceReport serviceReport = new ServiceReport();
        putInfoDao.putData(PATH_OUTPUT, serviceReport.report());
    }
}
