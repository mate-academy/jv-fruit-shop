package service;

import dao.ShopDao;
import java.io.File;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private ShopDao shopDao;
    private TransactionService transactionService;

    public ShopServiceImpl(ShopDao shopDao, TransactionService transactionService) {
        this.shopDao = shopDao;
        this.transactionService = transactionService;
    }

    @Override
    public void process(File fromFile, File toFile) {
        List<String> data = shopDao.readFromFile(fromFile);
        transactionService.processData(data);
        String report = transactionService.generateReport();
        shopDao.writeToFile(toFile, report);
    }
}
