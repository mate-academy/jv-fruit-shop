package service.type.service;

public class TypeHandlerBalance implements TypeHandler {

    @Override
    public int getType(int amount) {
        return amount;
    }
}
