package service;

public interface DataValidator {
    public void validateRecord(String record);

    public void validateFirstLine(String firstLine);

    public void validateAmount(int newAmount);
}
