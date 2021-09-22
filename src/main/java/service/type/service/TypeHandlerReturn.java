package service.type.service;

public class TypeHandlerReturn implements TypeHandler {
    @Override
    public int getType(Integer amount, Integer result) {
        return amount + result;
    }
}
