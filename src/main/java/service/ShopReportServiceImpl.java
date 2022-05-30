package service;

import dao.ProductAccountDaoImpl;
import java.util.List;
import model.ProductAccount;

public class ShopReportServiceImpl implements ShopReportService {

    private ProductAccountDaoImpl dao;

    public ShopReportServiceImpl(ProductAccountDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<ProductAccount> getShopBalanceReport() {
        return dao.getBalance();
    }
}
