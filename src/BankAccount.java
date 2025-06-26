import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;


public class BankAccount {
    private  String number;
    private String name;
    private int balance;
    private LocalDateTime date;
    private boolean blockAccount;
    public BankAccount(String name) {
        this.name = name;
        this.number = generateNumber();
        this.balance = 0;
        this.date = LocalDateTime.now();
        this.blockAccount = false;
    }
    private String generateNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }
    public boolean deposit(int amount){
        if (amount <= 0 || blockAccount){
            return false;
        }
        else {
            balance += amount;
            return true;
        }
    }
    public  boolean withdraw(int amount){
        if (amount <= 0 || blockAccount || amount > balance){
            return false;
        }
        else{
            balance -= amount;
            return true;
        }
    }
    public  boolean transfer(int amount,  BankAccount otherAccount){
        if (amount <= 0 || blockAccount || otherAccount.blockAccount || amount > balance){
            return false;
        }
        else{
            balance -= amount;
            otherAccount.balance += amount;
            return true;
        }
    }
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankAccount that = (BankAccount) o;
        return Objects.equals(number, that.number);
    }

    public int hashCode() {
        return Objects.hash(number);
    }
    public String toString(){
        String status = blockAccount ? "заблокирован" : "Активен";
        return String.format(
                "Имя владельца: %s\n" +
                        "Номер счета: %s\n" +
                        "Статус: %s\n" +
                        "Баланс: %s\n",
                name,
                number,
                status,
                balance
        );
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getdate() {
        return date;
    }

    public boolean blockAccount() {
        return blockAccount;
    }

}
