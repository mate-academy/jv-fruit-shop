package servise.impl;

import dao.ItemDao;
import java.util.List;
import servise.ShopService;
import servise.TransactionService;

public class ShopServiceImpl implements ShopService {
    private final ItemDao itemDao;
    private final TransactionService transactionService;

    public ShopServiceImpl(ItemDao itemDao, TransactionService transactionService) {
        this.itemDao = itemDao;
        this.transactionService = transactionService;
    }

    @Override
    public void process(List<String> records) {
        records.stream()
                .filter(r -> !r.startsWith("type"))
                .map(transactionService::createTransaction)
                .forEach(itemDao::insert);
    }
}
