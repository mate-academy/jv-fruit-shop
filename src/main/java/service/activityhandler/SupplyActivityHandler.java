package service.activityhandler;

public class SupplyActivityHandler implements ActivityHandler {
    @Override
    public int get(int fruitAmount) {
        if (fruitAmount < 0) {
            throw new IllegalArgumentException("Supplies amount can not be negative");
        } else {
            return fruitAmount;
        }
    }
}
