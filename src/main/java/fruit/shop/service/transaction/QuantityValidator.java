package fruit.shop.service.transaction;

public class QuantityValidator {
    public boolean validate(Integer available, Integer needed) {
        return available >= needed;
    }
}
