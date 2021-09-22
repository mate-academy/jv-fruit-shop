package service.type.service;

public class TypeHandlerBalance implements TypeHandler {

    @Override
    public int getType(Integer amount, Integer result) {
        return amount;
    }
}
