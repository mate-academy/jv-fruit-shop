package service.activityhandler;

public class ReturnActivityHandler implements ActivityHandler {
    @Override
    public int get(int fruitAmount) {
        if (fruitAmount < 0) {
            throw new IllegalArgumentException("Return fruit amount can not be negative");
        } else {
            return fruitAmount;
        }
    }
}
