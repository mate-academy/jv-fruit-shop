package fruite.store.service;

import fruite.store.dao.ReadDateDao;
import fruite.store.dao.ReadDateFromFileDaoImpl;
import fruite.store.dao.WriteDateDao;
import fruite.store.dao.WriteDateToFileDaoImpl;
import fruite.store.db.Storage;
import fruite.store.service.strategy.StrategyType;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_FRUIT_QUANTITY = 2;
    private static final String FRUIT_WORD = "fruit";
    private static final String QUANTITY_WORD = "quantity";
    private static final String COMA_SEPARATOR = ",";
    private StrategyType strategyType;
    private ReadDateDao readDateDao;
    private WriteDateDao writeDateDao;

    @Override
    public void makeReportByDay(String fromFilePath, String toFilePath) {
        readDateDao = new ReadDateFromFileDaoImpl();
        String data = readDateDao.readDate(fromFilePath);
        processDate(data);
        byte[] report = generateDataForReport();
        writeDateDao = new WriteDateToFileDaoImpl();
        writeDateDao.writeReport(report, toFilePath);
    }

    private void processDate(String data) {
        strategyType = new StrategyType();
        String[] arrayData = data.split(System.lineSeparator());
        for (int i = 1; i < arrayData.length; i++) {
            String[] temp = arrayData[i].split(COMA_SEPARATOR);
            strategyType.doSpecialOperationOnFruits(
                    temp[INDEX_OF_OPERATION_TYPE],
                    temp[INDEX_OF_FRUIT_TYPE],
                    temp[INDEX_OF_FRUIT_QUANTITY]);
        }
    }

    private byte[] generateDataForReport() {
        StringBuilder builderResult = new StringBuilder();
        builderResult.append(FRUIT_WORD).append(COMA_SEPARATOR).append(QUANTITY_WORD);
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            builderResult.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMA_SEPARATOR)
                    .append(entry.getValue());
        }
        return builderResult.toString().getBytes();
    }
}
