package core.basesyntax.servise;

import core.basesyntax.ExecuteTypeOperationStrategy;
import core.basesyntax.Storage;
import core.basesyntax.implementation.BuyOperation;
import core.basesyntax.implementation.ReturnOperation;
import core.basesyntax.implementation.SupplyOperation;
import java.util.List;
import java.util.Map;

public class StoreService {
    private FruitDtoParser parser;
    private FileService fileService;
    private Storage storage;
    private ExecuteTypeOperationStrategy strategy;

    public StoreService() {
        parser = new FruitDtoParser();
        fileService = new FileService();
        storage = new Storage();
        strategy = new ExecuteTypeOperationStrategy(Map.of("b", new BuyOperation(),
                "r", new ReturnOperation(), "s", new SupplyOperation()));
    }

    public void loadFileOperations(String filePath) {
        for (String str : fileService.getListFromInputFile(filePath)) {
            strategy.executeTheRequiredOperation(storage, parser.parse(str));
        }
    }

    public List<String> getListShopStorageInfo() {
        return storage.getListInfo();
    }

    public void createStorageReportFile(String filePath) {
        fileService.writeOutputFile(getListShopStorageInfo(), filePath);
    }
}
