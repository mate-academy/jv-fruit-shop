import dao.FruitDao;
import dao.FruitDaoImpl;
import service.FruitShopService;
import service.impl.FruitShopServiceImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl();

        fruitShopService.getResult("inputDateFile.csv", "file.csv");
        System.out.println(fruitDao.getMap().toString());
    }
}
