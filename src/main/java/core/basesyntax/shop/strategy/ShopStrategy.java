package core.basesyntax.shop.strategy;

import core.basesyntax.shop.service.ShopService;
import core.basesyntax.shop.service.impl.ShopServiceImpl;

public class ShopStrategy {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String RETURN_BACK = "r";
    private static final String PURCHASE = "p";
    private ShopService shopService;

    public ShopStrategy() {
        shopService = new ShopServiceImpl();
    }

    public void chooseStrategy(String type, String item, int quantity) {
        switch (type) {
            case BALANCE :
                shopService.balance(item, quantity);
                break;
            case SUPPLY :
                shopService.supply(item, quantity);
                break;
            case RETURN_BACK :
                shopService.returnBack(item, quantity);
                break;
            default :
            case PURCHASE :
                shopService.purchase(item, quantity);
                break;
        }
    }
}
