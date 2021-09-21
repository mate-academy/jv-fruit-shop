package service.activityhandler;

public class PurchaseActivityHandler implements ActivityHandler {
    @Override
    public int get(int fruitAmount) {
        if (fruitAmount < 0) {
            throw new IllegalArgumentException("Purchase amount can not be negative");
        } else {
            return fruitAmount * -1;
        }
    }
}
