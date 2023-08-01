package core.basesyntax;

import core.basesyntax.dataservice.CsvFileReader;
import core.basesyntax.dataservice.CsvFileWriter;
import core.basesyntax.dataservice.ProcessData;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        String dataFromFile = new CsvFileReader().readDataFromFile("src/main/resources/data.csv");
        String processedData = new ProcessData().processData(dataFromFile);
        new CsvFileWriter().writeDataToFile(processedData, "src/main/resources/processedData.csv");
    }
}
