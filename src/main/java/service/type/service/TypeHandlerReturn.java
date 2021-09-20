package service.type.service;

public class TypeHandlerReturn implements TypeHandler {
    @Override
    public int getType(int amount) {
        return amount * -1;
    }
}
