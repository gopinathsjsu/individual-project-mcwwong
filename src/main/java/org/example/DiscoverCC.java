package org.example;


public class DiscoverCC extends CreditCard{
    DiscoverCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public boolean isValid() {
        return cardNumber.startsWith("6011") && cardNumber.length() == 16;
    }
}