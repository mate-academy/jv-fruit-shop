package service.type.service;

public class TypeHandlerPurchase implements TypeHandler {
    @Override
    public int getType(int amount) {
        return amount * -1;
    }
}
