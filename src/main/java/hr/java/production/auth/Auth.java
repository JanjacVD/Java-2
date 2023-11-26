package hr.java.production.auth;


import hr.java.production.model.Person;

public class Auth {

    //Dummy auth class
    private Person user;

    private static Auth instance;
    public Auth(){}
    public static Auth getInstance() {
        if (instance == null) {
            instance = new Auth();
        }
        return instance;
    }
    public void setUser(Person _user){
        this.user = _user;
    }
    public Person getUser(){
        return this.user;
    }
}
