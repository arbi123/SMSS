package Globals;

public class Globals {
    public static String browserType = "chrome";
    public static String fullName = "Arbi Topi";
    public static String smsLoginUrl ="http://192.168.15.40:2525/auth/login";
    public static String dashboardUrl="http://192.168.15.40:2525/dashboard";
    public static String usersUrl= "http://192.168.15.40:2525/users";
    public static String klientetUrl ="http://192.168.15.40:2525/clients";


    public static String generateRandom5DigitNumber() {
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        return String.valueOf(randomNumber);  // Convert the number to a string and return it
    }
}
