package com.example.RolePackage;

public abstract class RoleDA0 {

    public RoleDA0() {}

    public abstract Role setRole(String libelle, String description, Permission[] permissions);

    public abstract void removeRole(int idR);

    public abstract Role getRoleById(int idR);

}