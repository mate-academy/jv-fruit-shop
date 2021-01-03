package core.basesyntax.shop;

public interface Shop {
    void initBalanceFromFile(String sourceFilePath);

    void generateDailyReport(String destFilePath);
}
