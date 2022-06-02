package service;

import dao.ProductAccountDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.ProductAccount;

public class ShopReportServiceImpl implements ShopReportService {

    private ProductAccountDaoImpl dao;

    public ShopReportServiceImpl(ProductAccountDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public List<String> getShopBalanceReport() {
        List<ProductAccount> balanceReport = dao.getBalance();

        List<String> outStringList = new ArrayList<String>();
        //prepare CSV headers
        outStringList.add((HeaderParts.FRUIT.name().toLowerCase()
                + ","
                + HeaderParts.QUANTITY.name().toLowerCase()));
        //fill csv data
        for (ProductAccount productAccount:balanceReport) {
            outStringList.add((productAccount.getName()
                    + ","
                    + productAccount.getAmount().toString()));
        }
        return outStringList;
    }
}
