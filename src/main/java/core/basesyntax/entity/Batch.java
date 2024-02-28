package core.basesyntax.entity;

import java.time.LocalDate;

public class Batch {

    private String butchNumber;
    private LocalDate harvestDate;
    private LocalDate expirationDate;

    public Batch(String butchNumber, LocalDate harvestDate, LocalDate expirationDate) {
        this.butchNumber = butchNumber;
        this.harvestDate = harvestDate;
        this.expirationDate = expirationDate;
    }

    public String getButchNumber() {
        return butchNumber;
    }

    public void setButchNumber(String butchNumber) {
        this.butchNumber = butchNumber;
    }

    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
