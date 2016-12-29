package juyelrana.loginregister;

/**
 * Created by JuyelRana on 6/28/2016.
 */
public class Config {

    //URL to our Register.php file
    public static final String REGISTERURL = "http://10.0.0.71/LoginRegister/register.php";


    public static final String ID = "id";   //id field
    public static final String FIRSTNAME = "firstname";   //firstname field
    public static final String LASTNAME = "lastname";   //lastname field
    public static final String EMAIL = "email";        //email field
    public static final String USERNAME = "username";  //username field
    public static final String PASSWORD = "password";   //password field

    //URL to our login.php file
    public static final String LOGIN_URL = "http://192.168.56.1/Rana/Login.php";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //If server response is not equal to this that means login is failed
    public static final String LOGIN_FAILED = "failed";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "LoginRegister";


    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "email";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";


}
