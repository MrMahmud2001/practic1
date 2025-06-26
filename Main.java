public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Иван Иванов");
        BankAccount account2 = new BankAccount("Ольга Семенова");

        boolean depositAccount = account1.deposit(500);
        System.out.println("Пополнение счета: " + (depositAccount ? "Успешно" : "Неудача"));
        System.out.println("Счет: " + account1.getBalance());

        boolean withdrawAccount = account1.withdraw(100);
        System.out.println("Снятие с счета: " + (depositAccount ? "Успешно" : "Неудача"));
        System.out.println("Счет: " + account1.getBalance());

        boolean transferAccount = account1.transfer(100, account2);
        System.out.println("Перевод на другой счет: " + (depositAccount ? "Успешно" : "Неудача"));
        System.out.println("Счет Ивана Иванова: " + account1.getBalance());
        System.out.println("Счет Ольги Семеновой: " + account2.getBalance());

        System.out.println(account1.toString());

        account1.setNumber("12345678");
        account2.setNumber("12345678");
        System.out.println(account1.equals(account2));
        System.out.println(account1.hashCode() == account2.hashCode());
    }
}