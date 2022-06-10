import dao.AccountDao;
import dao.AccountDaoImplementation;
import java.io.File;
import java.util.List;
import service.FileService;
import service.ShopService;
import service.impl.FileServiceImplementation;
import service.impl.ShopServiceImplementation;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/fruit_shop.csv";
        File file = new File(path);
        FileService fileService = new FileServiceImplementation();
        ShopService shopService = new ShopServiceImplementation();
        AccountDao dao = new AccountDaoImplementation();
        dao.fill(shopService.parse(fileService.read(file)));
        String newFilePath = "src/main/fruit_shop_report.csv";
        File reportFile = new File(newFilePath);
        List<String[]> balance = shopService.doReport(dao);
        fileService.writeFile(reportFile, balance);
    }
}
