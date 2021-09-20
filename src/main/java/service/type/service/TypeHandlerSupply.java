package service.type.service;

public class TypeHandlerSupply implements TypeHandler {
    @Override
    public int getType(int amount) {
        return amount;
    }
}
