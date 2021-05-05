package core.basesyntax;

import core.basesyntax.shop.FileReader;
import core.basesyntax.shop.FileWriter;
import core.basesyntax.shop.ReportCreator;
import core.basesyntax.shop.ShopService;
import core.basesyntax.shop.implementation.DataFileWriter;
import core.basesyntax.shop.implementation.DataReader;
import core.basesyntax.shop.implementation.ShopServiceImpl;
import java.util.List;

public class Main {
    private static final String FILE_PATH_FROM_INPUT_DATA
            = "src/main/java/core/basesyntax/resources/inputData.csv";
    private static final String FILE_PATH_TO_WRITER
            = "src/main/java/core/basesyntax/resources/reportAfterWorkDay.csv";

    public static void main(String[] args) {
        FileReader fileReader = new DataReader();
        FileWriter writeData = new DataFileWriter();
        List<String> data = fileReader.readFromInputData(FILE_PATH_FROM_INPUT_DATA);
        ShopService service = new ShopServiceImpl();
        service.pushDataToStorage(data);
        ReportCreator creator = new ReportCreator();
        writeData.writeToReport(creator.createReport(),
                FILE_PATH_TO_WRITER);
    }
}
