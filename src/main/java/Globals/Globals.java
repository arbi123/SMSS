package Globals;

public class Globals {
    public static String browserType = "chrome";
    public static String fullName = "Arbi Topi";

    public static String validEmail = "noter2";
    public static String validPassword = "Zxasqw1@";
    public static String institucionConfigURL ="https://localhost:7166/InstitutionsConfigurations";
    public static String NjesitConfigURL ="https://localhost:7166/UnitConfigurations";
    public static String KonfigurimiDokumenteveShoqeruese = "https://localhost:7166/AccompanyingDocumentsConfigurations";
    public static String DitetPushimUrl ="https://localhost:7166/HolidaysConfigurations";


    public static String generateRandom5DigitNumber() {
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        return String.valueOf(randomNumber);  // Convert the number to a string and return it
    }
}
