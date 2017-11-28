package boostbrain;

import boostbrain.model.UserEntity;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by BoostBrain on 24.02.2017.
 */

@Named
@SessionScoped
public class ExampleCDI implements Serializable{

    @NotNull
    private String login;

    @NotNull(message="please, fill this field properly")
    private String password;

    private String ustaRanking;

    @NotNull(message = "Please select Sex Type, (M) for Male or (F) for Female")
    private String sex;

    private boolean loginSuccess;
    private boolean createSuccess;

    @EJB
    private ExampleEJB exampleEJB;

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

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public boolean isCreateSuccess() {
        return createSuccess;
    }

    public void setCreateSuccess(boolean createSuccess) {
        this.createSuccess = createSuccess;
    }

    public void checkPassword(){
        loginSuccess = exampleEJB.checkPassword(login, password);
    }

    public void createUser(){
        createSuccess = exampleEJB.createUser(login, password);
    }

    public List<UserEntity> getAllUsers(){
        return exampleEJB.getAllUsers();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUstaRanking() {
        return ustaRanking;
    }

    public void setUstaRanking(String ustaRanking) {
        this.ustaRanking = ustaRanking;
    }
}
