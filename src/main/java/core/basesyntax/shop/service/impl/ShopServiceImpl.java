package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.InsufficientGoodsException;
import core.basesyntax.shop.service.ShopDao;
import core.basesyntax.shop.service.ShopService;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private ShopDao fruitShopDao;
    private int purchased;
    private boolean appleBalanced;
    private boolean bananaBalanced;
    private boolean pearBalanced;

    public ShopServiceImpl() {
        fruitShopDao = new ShopDaoImpl();
        purchased = 0;
        appleBalanced = false;
        bananaBalanced = false;
        pearBalanced = false;
    }

    @Override
    public void balance(String item, Integer quantity) {
        if (markBalancedTrueIfBalanced(item)) {
            throw new RuntimeException("Balance for " + item + " has been already got");
        }
        fruitShopDao.add(item, quantity);
    }

    @Override
    public void supply(String item, Integer quantity) {
        fruitShopDao.add(item, quantity);
    }

    @Override
    public void purchase(String item, Integer quantity) {
        try {
            fruitShopDao.subtract(item, quantity);
        } catch (InsufficientGoodsException e) {
            throw new RuntimeException("Insufficient " + item, e);
        }
        purchased += quantity;
    }

    @Override
    public void returnBack(String item, Integer quantity) {
        if (quantity > purchased) {
            throw new RuntimeException("Returned more than purchased");
        }
        fruitShopDao.add(item, quantity);
        purchased -= quantity;
    }

    @Override
    public Map<String, Integer> getMap() {
        return fruitShopDao.returnMap();
    }

    private boolean markBalancedTrueIfBalanced(String item) {
        switch (item) {
            case "apple" :
                if (appleBalanced) {
                    return appleBalanced;
                }
                appleBalanced = true;
                return false;
            case "banana" :
                if (bananaBalanced) {
                    return bananaBalanced;
                }
                bananaBalanced = true;
                return false;
            default:
            case "pear" :
                if (pearBalanced) {
                    return pearBalanced;
                }
                pearBalanced = true;
                return false;
        }
    }
}
