package service.impl;

import java.util.List;
import service.ShopService;
import service.StorageService;

public class ShopServiceImpl implements ShopService {
    private final StorageService storageService;

    public ShopServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public List<String[]> doReport() {
        List<String[]> list = storageService.getBalance();
        list.add(0, new String[]{"fruit", "quantity"});
        return list;
    }
}
