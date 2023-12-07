package model.moneyAcceptor;

public class CardAcceptor implements MoneyAcceptor{
    private int amount;
    public CardAcceptor(int amount) {
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
}
