package core.basesyntax;

import core.basesyntax.dao.FruitMapDao;
import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.Validator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FileWorker;
import core.basesyntax.service.impl.ReportMakerCsv;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.ValidatorCsv;
import core.basesyntax.strategy.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  private static final String INPUT_FILEPATH = "src/main/resources/input.csv";
  private static final String OUTPUT_FILEPATH = "src/main/resources/report.csv";

  public static void main(String[] args) {
    FruitStorageDao fruitDao = new FruitMapDao(Storage.map);

    Map<String, OperationHandler> activityHandlerMap = new HashMap<>();
    activityHandlerMap.put(OperationType.BALANCE.getOperation(), new AddOperation(fruitDao));
    activityHandlerMap.put(OperationType.PURCHASE.getOperation(), new RemovingOperation(fruitDao));
    activityHandlerMap.put(OperationType.SUPPLY.getOperation(), new AddOperation(fruitDao));
    activityHandlerMap.put(OperationType.RETURN.getOperation(), new AddOperation(fruitDao));
    OperationStrategy strategy = new OperationStrategyImpl(activityHandlerMap);

    Reader fileReader = new FileWorker();
    Writer fileWriter = new FileWorker();
    ReportMaker reportMaker = new ReportMakerCsv();
    ShopService shopService = new ShopServiceImpl(strategy);
    List<String> inputData = fileReader.readFrom(INPUT_FILEPATH);
    Validator validator = new ValidatorCsv();
    if (validator.isValidData(inputData)) {
      shopService.updateFruitsWarehouse(inputData);
      String report = reportMaker.makeReport(Storage.map);
      fileWriter.write(report, OUTPUT_FILEPATH);
    }
  }
}