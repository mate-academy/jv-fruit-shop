package core.basesyntax.servise;

import core.basesyntax.ExecuteTypeOperationStrategy;
import core.basesyntax.implementation.BuyOperation;
import core.basesyntax.implementation.ReturnOperation;
import core.basesyntax.implementation.SupplyOperation;
import core.basesyntax.parser.FruitDtoParser;
import java.util.List;
import java.util.Map;

public class StoreService {
    private FruitDtoParser parser;
    private FileService fileService;
    private StorageService storageService;
    private ExecuteTypeOperationStrategy strategy;

    public StoreService() {
        parser = new FruitDtoParser();
        fileService = new FileService();
        storageService = new StorageService();
        strategy = new ExecuteTypeOperationStrategy(Map.of("b", new BuyOperation(storageService),
                "r", new ReturnOperation(storageService),
                "s", new SupplyOperation(storageService)));
    }

    public void loadFileOperations(String filePath) {
        for (String str : fileService.getListFromInputFile(filePath)) {
            strategy.executeTheRequiredOperation(storageService, parser.parse(str));
        }
    }

    public List<String> getListShopStorageInfo() {
        return storageService.getListInfo();
    }

    public void createStorageReportFile(String filePath) {
        fileService.writeOutputFile(getListShopStorageInfo(), filePath);
    }
}
