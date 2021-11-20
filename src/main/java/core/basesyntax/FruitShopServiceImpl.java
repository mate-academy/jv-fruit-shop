package core.basesyntax;

import core.basesyntax.model.Activity;
import core.basesyntax.service.impl.ReaderServiceImpl;

import java.io.File;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String FILE_SEPARATOR = File.separator;
    private static final String CSV_PATH = "src/main/resources/CSV.csv";
    private static final String WRONG_CSV_PATH = "src/main/resources/WRONG_CSV.csv";


    public static void main(String[] args) {
        File file = new File(CSV_PATH);
        ReaderServiceImpl fileReader = new ReaderServiceImpl();
        List<Activity> fileData= fileReader.read(file);


        System.out.println(fileData);
    }
}
