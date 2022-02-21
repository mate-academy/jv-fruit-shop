package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Apple;
import core.basesyntax.model.Banana;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Orange;
import core.basesyntax.model.dto.FruitDto;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.IteratorService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.DataConverterServiceImpl;
import core.basesyntax.service.impl.DataReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.IteratorServiceImpl;
import core.basesyntax.service.impl.StorageAdditionServiceImpl;
import core.basesyntax.service.impl.StorageReductionServiceImpl;
import core.basesyntax.strategy.TransDistrStrategy;
import core.basesyntax.strategy.TransDistrStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFruitsService {
    static final String READ_DATA_PATH = "src/main/resources/input.csv";
    static final String WRITE_REPORT_PATH = "src/main/resources/report.csv";
    static final String PURCHASE = "p";
    static final String RETURN = "r";
    static final String SUPPLY = "s";
    static final String BALANCE = "b";
    static final int DEFAULT_QUANTITY = 0;

    public static void main(String[] args) {
        Fruit apple = new Apple("apple");
        Fruit banana = new Banana("banana");
        Fruit orange = new Orange("orange");

        Storage.shopStorage.put(apple, DEFAULT_QUANTITY);
        Storage.shopStorage.put(banana, DEFAULT_QUANTITY);
        Storage.shopStorage.put(orange, DEFAULT_QUANTITY);

        Map<String, StorageService> operationDistributionMap = new HashMap<>();
        operationDistributionMap.put(PURCHASE, new StorageReductionServiceImpl());
        operationDistributionMap.put(RETURN, new StorageAdditionServiceImpl());
        operationDistributionMap.put(SUPPLY, new StorageAdditionServiceImpl());
        operationDistributionMap.put(BALANCE, new StorageAdditionServiceImpl());

        DataReaderService dataReaderService = new DataReaderServiceImpl();
        List<String> linesFromFile = dataReaderService.readDataFromFile(READ_DATA_PATH);

        DataConverterService dataConverterService = new DataConverterServiceImpl();

        List<FruitDto> listFruitDto = dataConverterService.convertToDto(linesFromFile);

        TransDistrStrategy transDistrStrategy =
                new TransDistrStrategyImpl(operationDistributionMap);

        IteratorService iteratorService = new IteratorServiceImpl();
        iteratorService.iterate(listFruitDto, transDistrStrategy, Storage.shopStorage);

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(WRITE_REPORT_PATH, Storage.shopStorage);
    }
}
