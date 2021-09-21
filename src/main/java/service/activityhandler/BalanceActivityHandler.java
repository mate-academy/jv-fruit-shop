package service.activityhandler;

public class BalanceActivityHandler implements ActivityHandler {

    @Override
    public int get(int fruitAmount) {
        if (fruitAmount < 0) {
            throw new IllegalArgumentException("Initial supplies can not be negative");
        } else {
            return fruitAmount;
        }
    }
}
