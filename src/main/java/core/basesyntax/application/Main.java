package core.basesyntax.application;

import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.serviceImpl.DataParseServiceImpl;
import core.basesyntax.serviceImpl.ReadFromFileServiceImpl;
import core.basesyntax.service.DataParseService;
import core.basesyntax.service.ReadFromFileService;


import java.util.List;

public class Main {
    private static final ReadFromFileService readFromFile = new ReadFromFileServiceImpl();
    private static final DataParseService parseService = new DataParseServiceImpl();

    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";
        List<String> fileContentsList = readFromFile.readFile(inputFilePath);

        List<FruitsTransaction> fruitsTransactionListDto = parseService.getTransactionList(fileContentsList);
        System.out.println(fruitsTransactionListDto);

    }
}
