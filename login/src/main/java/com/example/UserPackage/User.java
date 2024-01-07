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
        return this.id;
    }

    /**
     * @return 
     * 
     */
    public String getName() {
    	return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getStatut() {
        return this.statut;
    }

    /**
     * 
     */
    public void setName() {
        this.name = name;
    }

    private void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setStatut(String email) {
        this.statut = statut;
    }

    private void setMdp(String mdp) {
        this.mdp = mdp;
    }




}