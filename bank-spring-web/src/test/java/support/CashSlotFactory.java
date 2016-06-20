package support;

import nicebank.CashSlot;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

public final class CashSlotFactory {

    public static CashSlot createTestCashSlot(final CashSlot realCashSlot) {
        final CashSlot mockCashSlot = mock(CashSlot.class, "mockCashSlot");
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                realCashSlot.load(invocation.getArgumentAt(0, Integer.class));
                return null;
            }
        }).when(mockCashSlot).load(anyInt());

        doAnswer(invocation -> realCashSlot.getContents()).when(mockCashSlot).getContents();
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                realCashSlot.dispense(invocation.getArgumentAt(0, Integer.class));
                return null;
            }
        }).when(mockCashSlot).dispense(anyInt());

        mockCashSlot.load(1000);

        return mockCashSlot;
    }

}
