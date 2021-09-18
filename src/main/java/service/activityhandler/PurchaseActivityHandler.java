package service.activityhandler;

public class PurchaseActivityHandler implements ActivityHandler {
    @Override
    public int get(int fruitAmount) {
        return fruitAmount * -1;
    }
}
