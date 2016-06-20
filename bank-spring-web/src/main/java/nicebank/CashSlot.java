package nicebank;

public interface CashSlot {
    void load(int dollars);

    int getContents();

    void dispense(int dollars);
}
