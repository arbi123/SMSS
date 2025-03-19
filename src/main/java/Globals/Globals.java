package Globals;

public class Globals {
    public static String browserType = "chrome";
    public static String fullName = "Arbi Topi";

    public static String validEmail = "noter2";
    public static String validPassword = "Zxasqw1@";
    public static String loginUrl = "http://localhost:5163/Login";
    public static String homenUrl = "http://localhost:5163/";
    public static String institucionConfigURL ="http://localhost:5163/InstitutionsConfigurations";
    public static String NjesitConfigURL ="http://localhost:5163/UnitConfigurations";
    public static String KonfigurimiDokumenteveShoqeruese = "http://localhost:5163/AccompanyingDocumentsConfigurations";
    public static String DitetPushimUrl ="http://localhost:5163/HolidaysConfigurations";
    public static String perdoruesConfigUrl ="http://localhost:5163/UserConfigurations";
    public static String SherbimetConfigUrl ="http://localhost:5163/ServiceConfigurations";


    public static String generateRandom5DigitNumber() {
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        return String.valueOf(randomNumber);  // Convert the number to a string and return it
    }
}
