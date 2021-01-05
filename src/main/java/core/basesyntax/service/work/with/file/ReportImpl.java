package core.basesyntax.service.work.with.file;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
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
import java.util.List;
import java.util.Map;

public class ReportImpl implements Report {
    @Override
    public String writeReport(List<String> list) {
        createReport(list);
        FruitDao fruitDao = new FruitDaoImpl();
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        int counter = 0;
        for (Map.Entry<Fruit, Integer> entry : fruitDao.getAllFruits()) {
            report.append(fruitDao.getFruit(entry.getKey().getFruitName())
                    .getFruitName()).append(",")
                    .append(fruitDao.getAmount(entry.getKey().getFruitName()));
            counter++;
            if (counter < fruitDao.getSize()) {
                report.append(System.lineSeparator());
            }
        }
        return report.toString();
    }

    @Override
    public void writeReportToFile(String report, String toFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file", e);
        }
        Storage.fruits.clear();
    }

    @Override
    public void createReport(List<String> list) {
        Map<Operation.Type, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.Type.B, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.Type.R, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.Type.P, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.Type.S, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ShopService shopService = new ShopServiceImpl(new FruitDaoImpl(), operationStrategy);
        shopService.doOperation(list);
    }
}

