package org.example;

public class AmExCC extends CreditCard{
    AmExCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    boolean isValid() {
        // American Express validation logic
        char firstDigit = cardNumber.charAt(0);
        char secondDigit = cardNumber.charAt(1);
        return firstDigit == '3' && (secondDigit == '4' || secondDigit == '7') && cardNumber.length() == 15;
    }
}
