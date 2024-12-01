public class BankingApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread t1 = new Thread(() -> {
            account.deposit(500);
        }, "Deposit-Thread");

        Thread t2 = new Thread(() -> {
            account.withdraw(300);
        }, "Withdraw-Thread");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Account Balance: " + account.getBalance());
    }
}