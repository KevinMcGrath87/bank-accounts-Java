public class BankAccountTest {
    public static void main(String[] args){
        BankAccount kevinsAccount = new BankAccount(1200, 10);

        System.out.println(kevinsAccount.getAccountNumber());

        System.out.println(BankAccount.getNumberOfAccounts());
    }
}