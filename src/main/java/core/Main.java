package core;

import service.ReaderService;
import service.ReaderServiceImpl;

import java.util.List;

public class Main {
    private static final String FILE_PATH = "src/main/resources/input.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> readedFile = readerService.readFromFile(FILE_PATH);
        System.out.println(readedFile);
    }
}
