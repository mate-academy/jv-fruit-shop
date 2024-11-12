package core.basesyntax.dao;

import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    private static FileReader fileReader = new FileReaderImpl();
    public static final String nameOfShopDatabase = "database.csv";
    public static final String nameOfFinalReport = "finalReport.csv";

    private static ShopService shopService = new ShopServiceImpl();
    private static ReportWriter reportWriter = new ReportWriterImpl();

    public void createAllFiles() {
        String databaseInfo = "type,fruit,quantity\n"
                + "    b,banana,20\n"
                + "    b,apple,100\n"
                + "    s,banana,100\n"
                + "    p,banana,13\n"
                + "    r,apple,10\n"
                + "    p,apple,20\n"
                + "    p,banana,5\n"
                + "    s,banana,50";
        File directoryForDatabases = new File("directoryForDatabases");
        directoryForDatabases.mkdir();

        String filePathForDatabase = "src/main"
                + File.separator + nameOfShopDatabase;
        String filePathForFinalReport = "src/main"
                + File.separator + nameOfFinalReport;

        File fileForDatabase = new File(filePathForDatabase);
        File fileForFinalReport = new File(filePathForFinalReport);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileForDatabase))) {
            fileForDatabase.createNewFile();
            fileForFinalReport.createNewFile();
            writer.write(databaseInfo);
        } catch (IOException e) {
            throw new RuntimeException("File was not created", e);
        }
    }
}
