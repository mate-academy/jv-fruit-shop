package service.type.service;

public class TypeHandlerSupply implements TypeHandler {
    @Override
    public int getType(Integer amount, Integer result) {
        return amount + result;
    }
}
