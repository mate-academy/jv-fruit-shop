package fruite.store.service;

import fruite.store.dao.ReadDateDao;
import fruite.store.dao.ReadDateFromFileDaoImpl;

public class FruiteServiceImpl implements FruitService {
    @Override
    public void makeReportByDay(String fromFilePath, String toFilePath) {
        ReadDateDao readDateDao = new ReadDateFromFileDaoImpl();
        String date = readDateDao.readDate(fromFilePath);
        System.out.println(date);
    }
}
