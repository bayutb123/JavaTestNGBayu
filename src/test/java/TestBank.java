import com.juaracoding.BankAccount;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBank {

    private static final int ACCOUNT_ID = 0;
    private static final String ACCOUNT_NAME = "Bayu Tantra Bramandhita";
    private static double ACCOUNT_BALANCE = 2500000.0;
    private static final double DEPOSIT_BALANCE_AMOUNT = 125000.0;
    private static final double WITHDRAW_BALANCE_AMOUNT = 25000.0;
    private static final double WITHDRAW_BALANCE_WILL_FAILED = 3000000.0;

    static BankAccount bankAccount;
    @BeforeClass
    public void setupClass() {
        bankAccount = new BankAccount();
        bankAccount.setAccount(ACCOUNT_ID, ACCOUNT_NAME, ACCOUNT_BALANCE);
    }

    @Test
    public void testDeposit() {
        double result = bankAccount.deposit(DEPOSIT_BALANCE_AMOUNT);
        double expected = ACCOUNT_BALANCE += DEPOSIT_BALANCE_AMOUNT;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testWithdraw() {
        double result = bankAccount.withdraw(WITHDRAW_BALANCE_AMOUNT);
        double expected = ACCOUNT_BALANCE -= WITHDRAW_BALANCE_AMOUNT;
        Assert.assertEquals(result, expected);

        double resultOnInvalid = bankAccount.withdraw(WITHDRAW_BALANCE_WILL_FAILED);
        Assert.assertEquals(resultOnInvalid, expected);
    }

    @Test
    public void testCheckBalance() {
        String result = bankAccount.checkBalance();
        String expected = "Balance is: " + ACCOUNT_BALANCE;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testDisplay() {
        String result = bankAccount.display();
        String expected = ACCOUNT_ID + " " + ACCOUNT_NAME + " " + ACCOUNT_BALANCE;

        Assert.assertEquals(result, expected);
    }
}
