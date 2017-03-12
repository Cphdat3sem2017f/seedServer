package entity;

import java.util.ArrayList;
import java.util.List;
import security.IUser;

public class User implements IUser{
  
  private String password;  //Pleeeeease dont store me in plain text
  private String userName;
  List<String> roles = new ArrayList();

  public User(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }
  
  public User(String userName, String password,List<String> roles) {
    this.userName = userName;
    this.password = password;
    this.roles = roles;
  }
  
  public void addRole(String role){
    roles.add(role);
  }
    
  @Override
  public List<String> getRolesAsStrings() {
   return roles;
  }
 
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

 
          
}
