package core.basesyntax.service;

public interface StoreService {

    /*
    input: String date - date of input file that present in file name
    so searched input file name will be = date + " input file.csv"
    */
    void processInputFile(String date);

    /*
    method generates report file based on current remnants present in Storage
    input: String date - date to be included in report file name
    so generated report file will have name = date + " report file.csv"
     */
    void generateReport(String date);
}
