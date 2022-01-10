package core.basesyntax.service;

public interface StoreService {

    //process these data
    void processInputFile(String date);

    //generate a report based on processed data
    void generateReport(String date);
}
