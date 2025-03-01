package core.basesyntax.dstdao;

public interface DestinationDaoStrategy {
    DestinationDao getDstDao(DestinationTypes type);
}
