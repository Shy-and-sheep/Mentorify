package com.example.TFPackage;

import com.example.TFPackage.AbstractDAOFactory;
import com.example.TFPackage.TypeFormation;
import com.example.TFPackage.TypeFormationDAOMySQL;

import java.util.List;

/**
 *
 */
public class DAOMySQLFactory extends AbstractDAOFactory {
    TypeFormationDAOMySQL TypeFormationDAOMySQL;

    /**
     * Default constructor
     */
    public DAOMySQLFactory() {
        super();
        this.TypeFormationDAOMySQL = new TypeFormationDAOMySQL();
    }

    @Override
    public TypeFormation getTypeFormationByIdDAO(int id) {
        return this.TypeFormationDAOMySQL.getTypeFormationById(id);
    }

    @Override
    public List<TypeFormation> getAllTypeFormationDAO() {
        return this.TypeFormationDAOMySQL.getAllTypeFormation();
    }

    @Override
    public TypeFormation addTypeFormationDAO(String nom, String description) {
        return this.TypeFormationDAOMySQL.addTypeFormation(nom,description);
    }

    @Override
    public TypeFormation setTypeFormationDAO(int id,String nom, String description) {
        return this.TypeFormationDAOMySQL.setTypeFormation(id,nom,description);
    }


    @Override
    public void removeTypeFormationDAO(int id) {
        System.out.println("ceci est l'id de DAOMYSQLFactory" + id);
        this.TypeFormationDAOMySQL.removeTypeFormation(id);
    }

}
