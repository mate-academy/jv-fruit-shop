package service.type.service;

public class TypeHandlerPurchase implements TypeHandler {
    @Override
    public int getType(Integer amount, Integer result) {
        return result - amount;
    }
}
