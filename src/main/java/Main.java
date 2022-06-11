import dao.AccountDao;
import dao.AccountDaoImplementation;
import java.io.File;
import java.util.List;
import service.FileService;
import service.ShopService;
import service.impl.FileServiceImplementation;
import service.impl.ShopServiceImplementation;

public class Main {
    private static final String FROM_FILE = "src/main/fruit_shop.csv";
    private static final String TO_FILE = "src/main/fruit_shop_report.csv";

    public static void main(String[] args) {
        File file = new File(FROM_FILE);
        FileService fileService = new FileServiceImplementation();
        ShopService shopService = new ShopServiceImplementation();
        AccountDao dao = new AccountDaoImplementation();
        dao.fill(shopService.parse(fileService.read(file)));
        File reportFile = new File(TO_FILE);
        List<String[]> balance = shopService.doReport(dao);
        fileService.writeFile(reportFile, balance);
    }
}
