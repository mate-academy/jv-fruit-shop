package core.basesyntax;

public class SupplyHandler implements OperationHandler {
    private final ShopService shopService;

    public SupplyHandler(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        shopService.addFruit(fruit, quantity);
    }
}
