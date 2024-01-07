package com.example.FormationPackage;

import com.example.PostsPackage.Post;
import com.example.TFPackage.TypeFormation;
import com.example.database.MySQLConnection;
import com.example.FormationPackage.Formation;

import java.sql.*;
import java.util.*;
public class FormationDAOMySQL extends FormationDAO {

    /**
     * Default constructor
     */
    public FormationDAOMySQL() {}

    public Formation getFormationById(int id) {
        Connection conn = MySQLConnection.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Formation formation = null;

        try {
            String query = "SELECT id, authorName, nom, description, prix, typespayment, nbPlacesMax, nbPlacesDispo, typeFormation FROM Formations WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int formationId = rs.getInt("id");
                String authorName = rs.getString("authorName");
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                double prix = rs.getDouble("prix");
                String typespayment = rs.getString("typespayment");
                int nbPlacesMax = rs.getInt("nbPlacesMax");
                int nbPlacesDispo = rs.getInt("nbPlacesDispo");
                String typeFormation = rs.getString("typeFormation");

                formation = new Formation(formationId, authorName, nom, description, prix, typespayment, nbPlacesMax, nbPlacesDispo, typeFormation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return formation;
    }

    public void removeFormation(int id) {
        Connection conn = null;
        PreparedStatement inscriptionsStmt = null;
        PreparedStatement formationsStmt = null;
        PreparedStatement commentairesStmt = null;

        try {
            conn = MySQLConnection.getConnection();

            // Suppression des inscriptions associées à la formation
            String deleteInscriptionsQuery = "DELETE FROM Inscriptions WHERE FormationId = ?";
            inscriptionsStmt = conn.prepareStatement(deleteInscriptionsQuery);
            inscriptionsStmt.setInt(1, id);
            inscriptionsStmt.executeUpdate();

            //suprpression des commentaires associés à la formation
            String deleteCommentairesQuery = "DELETE FROM Commentaires WHERE formationId = ?";
            commentairesStmt = conn.prepareStatement(deleteCommentairesQuery);
            commentairesStmt.setInt(1,id);
            commentairesStmt.executeUpdate();

            // Suppression de la formation
            String deleteFormationQuery = "DELETE FROM Formations WHERE id = ?";
            formationsStmt = conn.prepareStatement(deleteFormationQuery);
            formationsStmt.setInt(1, id);
            formationsStmt.executeUpdate();

            System.out.println("La formation avec l'ID " + id + " a été supprimée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Formation> getAllFormation() {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Formation> formations = new ArrayList<>();

        try {
            String query = "SELECT id,nom,description,prix,nbPlacesMax,nbPlacesDispo,typeFormation,authorName,typespayment FROM Formations";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int formationId = rs.getInt("id");
                String authorName = rs.getString("authorName");
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                double prix = rs.getDouble("prix");
                String typespayment = rs.getString("typespayment");
                int nbPlacesMax = rs.getInt("nbPlacesMax");
                int nbPlacesDispo = rs.getInt("nbPlacesDispo");
                String typeFormation = rs.getString("typeFormation");

                Formation formation = new Formation(formationId, authorName, nom, description, prix, typespayment, nbPlacesMax, nbPlacesDispo, typeFormation);
                formations.add(formation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return formations;
    }

    public Formation addFormation(String authorName, String nom, String description, double prix, String typespayment, int nbPlacesMax, int nbPlacesDispo, String typeFormation) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;
        Formation newFormation = null;
        try {
            String query = "INSERT INTO Formations (nom,description,prix,nbPlacesMax,nbPlacesDispo,typeFormation,authorName,typespayment) VALUES (?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nom);
            stmt.setString(2, description);
            stmt.setDouble(3, prix);
            stmt.setInt(4, nbPlacesMax);
            stmt.setInt(5, nbPlacesDispo);
            stmt.setString(6, typeFormation);
            stmt.setString(7, authorName);
            stmt.setString(8, typespayment);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("La création de la formation a échoué, aucune ligne n'a été modifiée.");
            }
            generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                newFormation = new Formation(id, authorName, nom, description, prix, typespayment, nbPlacesMax, nbPlacesDispo, typeFormation);
                System.out.println("Formation ajoutée avec l'ID : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newFormation;
    }
    public Formation setFormation(int id,String authorName,String nom,String description,double prix,String typespayment,int nbPlacesMax,int nbPlacesDispo,String typeFormation) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        Formation formation = null;

        try {
            String query = "UPDATE Formations SET nom = ?,description = ?,prix = ?,nbPlacesMax = ?,nbPlacesDispo = ?,typeFormation = ?,typespayment = ? WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, nom);
            stmt.setString(2, description);
            stmt.setDouble(3, prix);
            stmt.setInt(4, nbPlacesMax);
            stmt.setInt(5, nbPlacesDispo);
            stmt.setString(6, typeFormation);
            stmt.setString(7, typespayment);
            stmt.setInt(8, id);


            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                formation = new Formation(id, authorName, nom, description, prix, typespayment, nbPlacesMax, nbPlacesDispo, typeFormation);
            }else{
                System.out.println("rien n'a été modifié");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return formation;
    }


    public void inscriptionFormation(int userId, int idFormation) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = MySQLConnection.getConnection();

            // Vérification des places disponibles dans la formation
            String checkQuery = "SELECT nbPlacesDispo, nbPlacesMax FROM Formations WHERE id = ?";
            stmt = conn.prepareStatement(checkQuery);
            stmt.setInt(1, idFormation);
            ResultSet resultSet = stmt.executeQuery();

            int nbPlacesDispo = 0;
            int nbPlacesMax = 0;
            if (resultSet.next()) {
                nbPlacesDispo = resultSet.getInt("nbPlacesDispo");
                nbPlacesMax = resultSet.getInt("nbPlacesMax");
            }

            // Vérification si l'utilisateur est déjà inscrit
            String checkInscriptionQuery = "SELECT * FROM Inscriptions WHERE userId = ? AND FormationId = ?";
            stmt = conn.prepareStatement(checkInscriptionQuery);
            stmt.setInt(1, userId);
            stmt.setInt(2, idFormation);
            ResultSet existingInscription = stmt.executeQuery();

            if (existingInscription.next()) {
                System.out.println("L'utilisateur est déjà inscrit à cette formation.");
                return; // Ne pas inscrire s'il est déjà inscrit
            }

            // Si des places sont disponibles et pas de double inscription
            if (nbPlacesDispo > 0 && nbPlacesDispo <= nbPlacesMax) {
                String updateQuery = "UPDATE Formations SET nbPlacesDispo = nbPlacesDispo - 1 WHERE id = ?";
                stmt = conn.prepareStatement(updateQuery);
                stmt.setInt(1, idFormation);
                int rowsUpdated = stmt.executeUpdate();

                if (rowsUpdated > 0) {
                    String insertQuery = "INSERT INTO Inscriptions (userId, FormationId) VALUES (?, ?)";
                    stmt = conn.prepareStatement(insertQuery);
                    stmt.setInt(1, userId);
                    stmt.setInt(2, idFormation);
                    int rowsInserted = stmt.executeUpdate();

                    if (rowsInserted > 0) {
                        System.out.println("Utilisateur inscrit à la formation avec succès.");
                    } else {
                        System.out.println("Échec de l'inscription à la formation.");
                    }
                } else {
                    System.out.println("Échec de l'inscription à la formation.");
                }
            } else {
                System.out.println("Aucune place disponible pour cette formation.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desinscriptionFormation(int userId, int idFormation) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = MySQLConnection.getConnection();

            // Vérification de l'inscription de l'utilisateur à la formation
            String checkInscriptionQuery = "SELECT * FROM Inscriptions WHERE userId = ? AND FormationId = ?";
            stmt = conn.prepareStatement(checkInscriptionQuery);
            stmt.setInt(1, userId);
            stmt.setInt(2, idFormation);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                // Désinscription de l'utilisateur
                String updateQuery = "DELETE FROM Inscriptions WHERE userId = ? AND FormationId = ?";
                stmt = conn.prepareStatement(updateQuery);
                stmt.setInt(1, userId);
                stmt.setInt(2, idFormation);
                int rowsDeleted = stmt.executeUpdate();

                if (rowsDeleted > 0) {
                    // Mise à jour des places disponibles dans la formation
                    String updatePlacesQuery = "UPDATE Formations SET nbPlacesDispo = nbPlacesDispo + 1 WHERE id = ?";
                    stmt = conn.prepareStatement(updatePlacesQuery);
                    stmt.setInt(1, idFormation);
                    int rowsUpdated = stmt.executeUpdate();

                    if (rowsUpdated > 0) {
                        System.out.println("Utilisateur désinscrit de la formation avec succès.");
                    } else {
                        System.out.println("Échec de la mise à jour des places disponibles pour la formation.");
                    }
                } else {
                    System.out.println("Échec de la désinscription de l'utilisateur à la formation.");
                }
            } else {
                System.out.println("L'utilisateur n'est pas inscrit à cette formation.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Formation> getFormationByTF(String TF) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        List<Formation> formations = new ArrayList<>();

        try{
            String query = "SELECT id,nom,description,prix,nbPlacesMax,nbPlacesDispo,typeFormation,authorName,typespayment FROM Formations WHERE typeFormation = ?";
            statement = conn.prepareStatement(query);
            statement.setString(1, TF);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                int formationId = rs.getInt("id");
                String authorName = rs.getString("authorName");
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                double prix = rs.getDouble("prix");
                String typespayment = rs.getString("typespayment");
                int nbPlacesMax = rs.getInt("nbPlacesMax");
                int nbPlacesDispo = rs.getInt("nbPlacesDispo");
                String typeFormation = rs.getString("typeFormation");

                Formation formation = new Formation(formationId,authorName,nom,description,prix,typespayment,nbPlacesMax,nbPlacesDispo,typeFormation);
                formations.add(formation);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return formations;

    }

}