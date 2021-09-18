package service.activityhandler;

public class ReturnActivityHandler implements ActivityHandler {
    @Override
    public int get(int fruitAmount) {
        return fruitAmount;
    }
}
