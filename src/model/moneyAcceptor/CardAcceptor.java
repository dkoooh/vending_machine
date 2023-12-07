package model.moneyAcceptor;

import java.util.Scanner;

public class CardAcceptor implements MoneyAcceptor{
    private final Scanner sc = new Scanner (System.in);

    private int amount;
    private String oneTimePassword;
    private final Long cardNumber;
    public CardAcceptor(int amount) {
        cardNumber = enterCardNumber();
        oneTimePassword = enterPassword();
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    private Long enterCardNumber() {
        while (true) {
            System.out.print("Введите номер карты (без пробелов): ");
            String strCardNumber = sc.nextLine().trim();
            if (!strCardNumber.isEmpty()) {
                if (strCardNumber.length() == 16) {
                    return Long.parseLong(strCardNumber);
                } else {
                    throw new IllegalArgumentException("Номер карты должен состоять из 16 символов..");
                }
            } else {
                throw new IllegalArgumentException("Вы не ввели номер карты..");
            }
        }
    }

    private String enterPassword () {
        while (true) {
            System.out.print("Введите одноразовый код: ");
            String oneTimePassword = sc.nextLine().trim();
            if (!oneTimePassword.isEmpty()) {
                return oneTimePassword;
            } else {
                throw new IllegalArgumentException("Вы не ввели код..");
            }
        }
    }
}
