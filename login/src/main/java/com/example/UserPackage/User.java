package com.example.UserPackage;

/**
 * 
 */
public class User {

    /**
     * Default constructor
     */
    public User( int id, String mdp, String username, String name, String first_name, String email, String statut) {
        this.id = id;
        this.username = username;
        this.mdp = mdp;
        this.name = name;
        this.first_name = first_name ;
        this.email = email ;
        this.statut = statut ;
    }

    public  int id;

    public  String username; //pseudo

    public  String mdp;

    public String name;  //nom

    private String first_name; //prenom

    private String email;

    private String statut ;
    /**
     * 
     */
    public int getId() {
        // TODO implement here
        return this.id;
    }

    /**
     * @return 
     * 
     */
    public String getName() {
        // TODO implement here
    	return this.name;
    }

    public String getUsername() {
        // TODO implement here
        return this.username;
    }

    public String getFirstName() {
        // TODO implement here
        return "";
    }

    public String getEmail() {
        // TODO implement here
        return "";
    }

    public String getStatut() {
        // TODO implement here
        return "";
    }

    /**
     * 
     */
    public void setName() {
        // TODO implement here
    }

    private void setFirstName(String first_name) {
        // TODO implement here
    }

    private void setEmail(String email) {
        // TODO implement here
    }

    private void setStatut(String email) {
        // TODO implement here
    }

    private void setMdp(String mdp) {
        // TODO implement here
    }




}