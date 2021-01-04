package core.basesyntax.shopimpl.database;

import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.ShopActions;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.service.IODataFileService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitShopDao implements ShopDao<DataRecord> {
    private List<DataRecord> dataBase;
    private IODataFileService fileService;
    
    public FruitShopDao(String dataFilePath) {
        fileService = new IODataFileService(dataFilePath);
        dataBase = fileService.readDataFile();
    }
    
    @Override
    public List<DataRecord> getTransactionHistory() {
        return new ArrayList<>(dataBase);
    }
    
    @Override
    public List<DataRecord> getItemTransactionHistory(String item) {
        return dataBase.stream()
                .filter(data -> data.item().getItemName().equalsIgnoreCase(item))
                .collect(Collectors.toList());
    }
    
    @Override
    public void addTransaction(DataRecord action) {
        dataBase.add(action);
    }
    
    public void addAction(ShopActions action, String item, Integer amount) {
        dataBase.add(new DataRecord(action, new Fruit(item), amount));
    }
    
    @Override
    public void updateDatabase() {
        fileService.writeDataFile(dataBase);
    }
}
