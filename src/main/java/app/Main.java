package app;

import static app.constants.Constants.INPUT_FILE;
import static app.constants.Constants.OUTPUT_FILE;

import app.service.FileWriterImpl;
import app.service.FruitServiceImpl;
import app.service.TransferDataFromFileToTransactionImpl;

public class Main {

    public static void main(String[] args) {
        new TransferDataFromFileToTransactionImpl().transfer(INPUT_FILE);
        String report = new FruitServiceImpl().getReport();
        new FileWriterImpl().writeToFile(report, OUTPUT_FILE);
    }
}
