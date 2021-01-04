package core.basesyntax.service.work.with.file;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operation.Operation;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImpl;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReportImpl implements Report {
    private static final String toFileName = "Report";

    @Override
    public String writeReport(String fromFileName) {
        createReport(fromFileName);
        FruitDao fruitDao = new FruitDaoImpl();
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (int i = 0; i < Storage.fruits.size(); i++) {
            report.append(fruitDao.get(i).getFruitName()).append(",")
                    .append(fruitDao.get(i).getAmount());
            if (i < Storage.fruits.size() - 1) {
                report.append(System.lineSeparator());
            }
        }
        return report.toString();
    }

    @Override
    public void writeReportToFile(String fromFileName) {
        String report = writeReport(fromFileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file", e);
        }
        Storage.fruits.clear();
    }

    @Override
    public void createReport(String fromFileName) {
        Map<Operation.Type, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.Type.R, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.Type.P, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.Type.S, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ShopService shopService = new ShopServiceImpl(new FruitDaoImpl(), operationStrategy);
        FruitDaoImpl fruitDao = new FruitDaoImpl();
        ReadFromCsvFile readFromCsvFile = new ReadFromCsvFileImpl(fruitDao, fromFileName);
        readFromCsvFile.addNewFruit();
        for (int i = 0; i < Storage.fruits.size(); i++) {
            shopService.doOperation(fruitDao.get(i), fromFileName);
        }
    }
}
