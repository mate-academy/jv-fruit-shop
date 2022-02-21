package model;

public class ReturnModelImpl implements ReturnModel {
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public FruitModel getModel(String[] line) {
        return new FruitModel(line[NAME_INDEX], Integer.valueOf(line[AMOUNT_INDEX]));
    }
}
