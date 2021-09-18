package service.activityhandler;

public class SupplyActivityHandler implements ActivityHandler {
    @Override
    public int get(int fruitAmount) {
        return fruitAmount;
    }
}
