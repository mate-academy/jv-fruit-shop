package core.basesyntax.frut_servise;

import core.basesyntax.DAO.FruitsDao;
import core.basesyntax.frut_data_process.FruitDataProcess;
import core.basesyntax.frut_data_process.FruitReportMaker;
import core.basesyntax.model.FruitTransaction;

import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private FruitsDao fruitsDao;
    private FruitDataProcess fruitDataProcess;
    private FruitReportMaker fruitReportMaker;

    public FruitShopServiceImpl(FruitsDao fruitsDao,
                                FruitDataProcess fruitDataProcess,
                                FruitReportMaker fruitReportMaker) {
        this.fruitsDao = fruitsDao;
        this.fruitDataProcess = fruitDataProcess;
        this.fruitReportMaker = fruitReportMaker;
    }

    @Override
    public String serviceFruitsShop(String fromFile) {
        List<FruitTransaction> fruitsList = fruitsDao.getFruitsData(fromFile);
        Map<String, Integer> fruitsQuantity = fruitDataProcess.processFruitsData(fruitsList);
        return fruitReportMaker.makeFruitReport(fruitsQuantity);
    }
}
