package com.example.RolePackage;

import java.util.List;

public abstract class PermissionDA0 {

    public PermissionDA0() {}
    
    public abstract List<Permission> getAllPermission();

    public abstract Permission setPermissionDAO(int idP,String libelle, String description);

    public abstract void removePermissionDAO(int idP);

}