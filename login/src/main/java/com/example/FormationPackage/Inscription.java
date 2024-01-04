package com.example.FormationPackage;

public class Inscription {
    private int userId;
    private int FormationId;

    public Inscription(int userId, int FormationId){
        this.userId = userId;
        this.FormationId = FormationId;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getFormationId() {
        return FormationId;
    }
    public void setFormationId(int formationId) {
        FormationId = formationId;
    }
}
