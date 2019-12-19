package beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;


@SessionScoped
@ManagedBean(name = "UserBean")
public class UserBean implements Serializable{

    private String userName;

    public UserBean(){
    }

    public UserBean(String userName){
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public boolean getReady() {
        boolean ready = ((userName == null) || (userName.isEmpty()) || (userName.length() < 4));
        return ready;
    }

    public void changePage(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
