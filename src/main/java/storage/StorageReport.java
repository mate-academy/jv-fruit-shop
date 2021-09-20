package storage;

import java.util.Map;

public class StorageReport {
    private Map<String, Integer> storageReport;

    public StorageReport(Map<String, Integer> storageReport) {
        this.storageReport = storageReport;
    }

    public Map<String, Integer> getStorageReport() {
        return storageReport;
    }

    public void setStorageReport(Map<String, Integer> storageReport) {
        this.storageReport = storageReport;
    }
}
