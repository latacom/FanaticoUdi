package udinova.fanatico.Models.POJO;

/**
 * Created by osboliviadev on 14/2/18.
 */

public class LoginPOJO {

    public String login;
    public String password;
    public String securekey;
    public LoginPOJO(){
        securekey = "AudiA2018";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurekey() {
        return securekey;
    }

    public void setSecurekey(String securekey) {
        this.securekey = securekey;
    }
}
