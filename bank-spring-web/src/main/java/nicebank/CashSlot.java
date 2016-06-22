package nicebank;

public interface CashSlot {
    void load(int dollars);

    int getContents();

    boolean canDispense(final int requested);

    void dispense(int dollars);
}
