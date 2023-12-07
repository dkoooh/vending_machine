package model.moneyAcceptor;

import exceptions.CustomException;

import java.util.Scanner;

public class CardAcceptor implements MoneyAcceptor{
    private final Scanner sc = new Scanner (System.in);
    private int balance;
    private int amount;
    private String oneTimePassword;
    private final Long cardNumber;
    public CardAcceptor(int amount) throws CustomException {
        balance = 1000;
        cardNumber = enterCardNumber();
        oneTimePassword = enterPassword();
        this.amount = amount;
        balance -= amount;

        if (balance < 0) {
            throw new CustomException("Недостаточно средств..");
        }
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    private Long enterCardNumber() throws IllegalArgumentException{
        try {
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
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterCardNumber();
        }
    }

    private String enterPassword() throws IllegalArgumentException {
        try {
            System.out.print("Введите одноразовый код: ");
            String oneTimePassword = sc.nextLine().trim();
            if (!oneTimePassword.isEmpty()) {
                return oneTimePassword;
            } else {
                throw new IllegalArgumentException("Вы не ввели код..");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterPassword();
        }
    }
}
