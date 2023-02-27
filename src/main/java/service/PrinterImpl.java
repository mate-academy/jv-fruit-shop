package service;

import java.util.List;

public class PrinterImpl implements Printer {
    @Override
    public void print(List<String> inputData) {
        inputData.forEach(System.out::println);
    }
}
