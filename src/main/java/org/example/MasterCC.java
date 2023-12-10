package org.example;

public class MasterCC extends CreditCard {
    MasterCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    boolean isValid() {
        // MasterCard validation logic
        char firstDigit = cardNumber.charAt(0);
        char secondDigit = cardNumber.charAt(1);
        return firstDigit == '5' && secondDigit >= '1' && secondDigit <= '5' && cardNumber.length() == 16;
    }
}