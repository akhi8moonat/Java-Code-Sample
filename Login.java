/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginVerify;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
    @Id
    private String username;
    private String password;
    private String Account;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(String Account) {
        this.Account = Account;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAccount() {
        return Account;
    }
    @Override
    public boolean equals(Object o)
    {
        Login u = (Login)o;
        if((this.username.equals(u.getUsername())) && (this.password.equals(u.getPassword())) && (this.Account.equals(u.getAccount())) )
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}
