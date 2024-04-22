package service.impl;

import service.FruitShopService;
import service.WriteToFile;
import service.WriteToStorage;

public class FruitShopServiceImpl implements FruitShopService {
    private final WriteToStorage writeToStorage = new WriteToStorageImpl();
    private final WriteToFile writeFromStorage = new WriteToFileImpl();

    @Override
    public void getResult(String fromFileName, String toFileName) {
        writeToStorage.writeToDataBase(fromFileName);
        writeFromStorage.writeFromDataBase(toFileName);
    }
}
