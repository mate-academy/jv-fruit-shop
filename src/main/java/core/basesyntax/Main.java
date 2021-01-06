package core.basesyntax;

import core.basesyntax.model.shopdao.ShopDto;
import core.basesyntax.shopimpl.database.FruitShopDto;
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
        
        ShopDto<DataRecord> dto = new FruitShopDto();
        dto.addAll(records);
        
        FruitShopStorage storage = new FruitShopStorage();
        
        storage.initStorage(dto.getTransactionHistory());
    }
}
