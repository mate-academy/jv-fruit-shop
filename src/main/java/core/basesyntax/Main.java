package core.basesyntax;

import core.basesyntax.service.DataProcessingService;

public class Main {

    public static void main(String[] args) {
        String readFile = "src/main/resources/fruits_shop.csv";
        String writeFile = "src/main/resources/fruits_report.csv";
        DataProcessingService dataProcessingService = new DataProcessingService();
        dataProcessingService.getDataProcessing(readFile, writeFile);
    }
}
