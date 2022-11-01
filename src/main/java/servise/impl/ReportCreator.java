package servise.impl;

import dao.StorageEnternce;
import dao.impl.EntrenceToStorage;
import java.util.List;
import service.CreatReport;

public class ReportCreator implements CreatReport {
    private static final String SPLITERATOR = ",";

    @Override
    public List<String> creatReport() {
        StorageEnternce storageEnter = new EntrenceToStorage();
        return storageEnter.getStorage().entrySet().stream()
                .map(e -> "" + e.getKey() + SPLITERATOR + e.getValue() + System.lineSeparator())
                .toList();
    }
}
