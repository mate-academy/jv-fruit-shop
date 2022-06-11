package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ShopService;
import service.StorageService;

public class ShopServiceImplementation implements ShopService {
    private final StorageService storageService;

    public ShopServiceImplementation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public List<FruitTransaction> parse(List<String[]> list) {
        return list.stream()
                .skip(1)
                .map(i -> new FruitTransaction(i[0], i[1], Integer.parseInt(i[2])))
                .collect(Collectors.toList());
    }

    @Override
    public List<String[]> doReport() {
        List<String[]> list = storageService.getBalance();
        list.add(0, new String[]{"fruit", "quantity"});
        return list;
    }
}
