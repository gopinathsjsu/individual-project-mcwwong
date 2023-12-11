package org.example;

public class Processor {
    public static CreditCard getCreditCard(String cardNumber, String expirationDate, String cardHolderName)
    {
        if (cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16))
        {
            return new VisaCC(cardNumber, expirationDate, cardHolderName);
        }
        else if (cardNumber.startsWith("5") && cardNumber.length() == 16)
        {
            return new MasterCC(cardNumber, expirationDate, cardHolderName);
        }
        else if ((cardNumber.startsWith("34") || cardNumber.startsWith("37")) && cardNumber.length() == 15)
        {
            return new AmExCC(cardNumber, expirationDate, cardHolderName);
        }
        else if (cardNumber.startsWith("6011") && cardNumber.length() == 16)
        {
            return new DiscoverCC(cardNumber, expirationDate, cardHolderName);
        }
        else
        {
            return null;
        }
    }

    public static String getCardType(CreditCard card) {
        if(card.getClass()== AmExCC.class){
            return "AmericanExpress";
        }
        if(card.getClass()== DiscoverCC.class){
            return "Discover";
        }
        if(card.getClass()== MasterCC.class){
            return "MasterCard";
        }
        if(card.getClass()== VisaCC.class) {
            return "Visa";
        }else{
            return card.getClass().getSimpleName().replace("CC", "");
        }
    }

    public static String determineErrorMessage(String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            return "Invalid: empty/null card number";
        }
        if (cardNumber.length() > 19) {
            return "Invalid: more than 19 digits";
        }
        if (!cardNumber.matches("\\d+")) {
            return "Invalid: non numeric characters";
        }
        if (!isPossibleCardNumber(cardNumber)) {
            return "Invalid: not a possible card number";
        }
        return "";
    }

    public static boolean isPossibleCardNumber(String cardNumber) {
        if (cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16)) {
            return true; // Visa
        }
        if (cardNumber.startsWith("5") && cardNumber.length() == 16) {
            return true; // MasterCard
        }
        if ((cardNumber.startsWith("34") || cardNumber.startsWith("37")) && cardNumber.length() == 15) {
            return true; // American Express
        }
        if (cardNumber.startsWith("6011") && cardNumber.length() == 16) {
            return true; // Discover
        }
        return false; // Not a plausible card number
    }
}
