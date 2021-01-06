package core.basesyntax;

import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.service.IOdataFileService;
import core.basesyntax.shopimpl.storage.FruitShopStorage;
import java.util.List;

public class Main {
    private static final String path = "src/test/resources/testDataBase.csv";
    
    public static void main(String[] args) {
        IOdataFileService fileService = new IOdataFileService();
        List<String> lines = fileService.readFile(path);
        List<DataRecord> records = fileService.parseAll(lines);
        
        FruitShopStorage storage = new FruitShopStorage();
        
        storage.initStorage(records);
        
        fileService.writeReport("src/main/java/core/basesyntax/report.csv",
                storage.getStorage());
    }
}
