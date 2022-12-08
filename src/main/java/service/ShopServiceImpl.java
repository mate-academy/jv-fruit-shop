package service;

import dao.FruitTransactionDao;
import model.FruitTransaction;

public class ShopServiceImpl implements ShopService {
    private FruitTransactionDao fruitTransactionDao;
    private ReportService reportService;

    public ShopServiceImpl(FruitTransactionDao fruitTransactionDao, ReportService reportService) {
        this.fruitTransactionDao = fruitTransactionDao;
        this.reportService = reportService;
    }

    @Override
    public boolean addTransaction(FruitTransaction fruitTransaction) {
        return fruitTransactionDao.add(fruitTransaction);
    }

    @Override
    public boolean getReport() {
        return reportService.createReport();
    }
}
