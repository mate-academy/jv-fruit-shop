import java.io.File;
import java.util.List;
import service.FileService;
import service.ShopService;
import service.StorageService;
import service.impl.FileServiceImplementation;
import service.impl.ShopServiceImplementation;
import service.impl.StorageImplementation;

public class Main {
    private static final String FROM_FILE = "src/main/fruit_shop.csv";
    private static final String TO_FILE = "src/main/fruit_shop_report.csv";

    public static void main(String[] args) {
        File file = new File(FROM_FILE);
        FileService fileService = new FileServiceImplementation();
        StorageService storageService = new StorageImplementation();
        ShopService shopService = new ShopServiceImplementation(storageService);
        storageService.fill(shopService.parse(fileService.read(file)));
        File reportFile = new File(TO_FILE);
        List<String[]> balance = shopService.doReport();
        fileService.writeFile(reportFile, balance);
    }
}
