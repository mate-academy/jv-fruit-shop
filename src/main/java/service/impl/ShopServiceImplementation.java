package service.impl;

import dao.AccountDao;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ShopService;

public class ShopServiceImplementation implements ShopService {

    @Override
    public List<FruitTransaction> parse(List<String[]> list) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        list.remove(0);
        for (String[] string : list) {
            switch (string[0]) {
                case "b":
                    transactionList.add(new FruitTransaction(FruitTransaction
                            .Operation.BALANCE, string[1], Integer.parseInt(string[2])));
                    break;
                case "p":
                    transactionList.add(new FruitTransaction(FruitTransaction
                            .Operation.PURCHASE, string[1], Integer.parseInt(string[2])));
                    break;
                case "r":
                    transactionList.add(new FruitTransaction(FruitTransaction
                            .Operation.RETURN, string[1], Integer.parseInt(string[2])));
                    break;
                default:
                    transactionList.add(new FruitTransaction(FruitTransaction
                            .Operation.SUPPLY, string[1], Integer.parseInt(string[2])));
                    break;
            }
        }
        return transactionList;
    }

    @Override
    public List<String[]> doReport(AccountDao accountDao) {
        List<String[]> list = accountDao.getBalance();
        list.add(0, new String[]{"fruit", "quantity"});
        return list;
    }
}
