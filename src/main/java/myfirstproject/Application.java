package myfirstproject;

import java.util.Map;
import myfirstproject.dao.DataBaseDao;
import myfirstproject.dao.DataBaseDaoTemporal;
import myfirstproject.dao.impl.DataBaseDaoImpl;
import myfirstproject.dao.impl.DataBaseDaoTemporalImpl;
import myfirstproject.db.CustomDataBase;
import myfirstproject.model.Fruit;
import myfirstproject.service.ReadFile;
import myfirstproject.service.WriteFile;
import myfirstproject.service.impl.ReadFileImpl;
import myfirstproject.service.impl.WriteFileImpl;
import myfirstproject.strategy.Operation;

public class Application {
    private static final String PATH_TO_DB = "src/main/resources/sourceFile.csv";
    private static final String PATH_TO_RESULT = "src/main/resources/resultFile.csv";

    public static void main(String[] args) {
        final DataBaseDao dataBaseDao = new DataBaseDaoImpl();
        final DataBaseDaoTemporal dataBaseDaoTemporal = new DataBaseDaoTemporalImpl();
        final Operation operation = new Operation();
        final ReadFile reader = new ReadFileImpl();
        final WriteFile writer = new WriteFileImpl();

        reader.readFile(PATH_TO_DB);
        dataBaseDaoTemporal.saveDataToTemporalDB(operation);
        for (Map.Entry<Fruit, Integer> map : CustomDataBase.storage.entrySet()) {
            System.out.print(map.getKey().getName() + " ");
            System.out.print(map.getValue() + "\n");
        }
        writer.writeToFile(PATH_TO_RESULT, dataBaseDao.getAllRecords());
    }
}
