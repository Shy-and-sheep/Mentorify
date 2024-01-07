package com.example.sessionPackage;

import com.example.FormationPackage.FormationFacade;
import com.example.LoginPackage.UserFacade;
import com.example.database.MySQLConnection;
import com.example.FormationPackage.Formation;
import com.example.LoginPackage.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 */
public class SessionDAOMySQL extends SessionDA0 {

    @Override
    public Session getSessionById(int id) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM Sessions WHERE id=?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int authorId = resultSet.getInt("authorId");
                String nom = resultSet.getString("nom");
                String description = resultSet.getString("description");
                double prix = resultSet.getDouble("prix");
                int nbPlacesMax = resultSet.getInt("nbPlacesMax");
                String lieu = resultSet.getString("lieu");
                String date = resultSet.getString("date");

                List<Formation> formations = getFormationsForSession(id, conn);
                List<TypePaiement> typespayment = getTypePaiementForSession(id, conn);
                List<User> etudiants = getEtudiantsForSession(id, conn);

                Session session = new Session(id, authorId, nom, description, prix, nbPlacesMax, lieu, date);
                session.setFormations(formations);
                session.setTypespaiement(typespayment);
                session.setEtudiants(etudiants);
                return session;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture des ressources
            closeResultSet(resultSet);
            closeStatement(statement);
        }
        return null;
    }

    private List<Formation> getFormationsForSession(int sessionId, Connection conn) throws SQLException {
        List<Formation> formations = new ArrayList<>();
        String query = "SELECT formationId FROM FormationSession WHERE sessionId=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, sessionId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int formationId = resultSet.getInt("formationId");
                    Formation formation = FormationFacade.getInstance().getFormationById(formationId);
                            formations.add(formation);
                }
            }
        }
        return formations;
    }

    private List<User> getEtudiantsForSession(int sessionId, Connection conn) throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT etudiantId FROM InscriptionSession WHERE sessionId=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, sessionId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int etudiantId = resultSet.getInt("etudiantId");
                    User user = UserFacade.getInstance().getUser();
                    if (user != null) {
                        users.add(user);
                    }
                }
            }
        }
        return users;
    }

    private List<TypePaiement> getTypePaiementForSession(int sessionId, Connection conn) throws SQLException {
        List<TypePaiement> typespayment = new ArrayList<>();
        String query = "SELECT typePayementId FROM TypePaiementSession WHERE sessionId=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, sessionId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int typePayementId = resultSet.getInt("typePayementId");
                    TypePaiement typePaiement = new TypePaiement(1, "nom");
                    typespayment.add(typePaiement);
                }
            }
        }
        return typespayment;
    }

    @Override
    public void removeSession(int sessionId) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;

        try {
            String deleteFormationQuery = "DELETE FROM FormationSession WHERE sessionId = ?";
            statement = conn.prepareStatement(deleteFormationQuery);
            statement.setInt(1, sessionId);
            statement.executeUpdate();
            closeStatement(statement);

            String deleteTypePaymentQuery = "DELETE FROM TypePaiementSession WHERE sessionId = ?";
            statement = conn.prepareStatement(deleteTypePaymentQuery);
            statement.setInt(1, sessionId);
            statement.executeUpdate();
            closeStatement(statement);

            String deleteInscriptionQuery = "DELETE FROM InscriptionSession WHERE sessionId = ?";
            statement = conn.prepareStatement(deleteInscriptionQuery);
            statement.setInt(1, sessionId);
            statement.executeUpdate();
            closeStatement(statement);

            String deleteSessionQuery = "DELETE FROM Sessions WHERE id = ?";
            statement = conn.prepareStatement(deleteSessionQuery);
            statement.setInt(1, sessionId);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Aucune session avec l'ID " + sessionId + " n'a été trouvée.");
            } else {
                System.out.println("La session avec l'ID " + sessionId
                        + " et ses données associées ont été supprimées avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public List<Session> getAllSession() {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Session> sessions = new ArrayList<>();

        try {
            String query = "SELECT * FROM Sessions";
            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int authorId = resultSet.getInt("authorId");
                String nom = resultSet.getString("nom");
                String description = resultSet.getString("description");
                double prix = resultSet.getDouble("prix");
                int nbPlacesMax = resultSet.getInt("nbPlacesMax");
                String lieu = resultSet.getString("lieu");
                String date = resultSet.getString("date");

                List<Formation> formations = getFormationsForSession(id, conn);
                List<TypePaiement> typespayment = getTypePaiementForSession(id, conn);
                List<User> etudiants = getEtudiantsForSession(id, conn);

                Session session = new Session(id, authorId, nom, description, prix, nbPlacesMax, lieu, date);
                session.setFormations(formations);
                session.setTypespaiement(typespayment);
                session.setEtudiants(etudiants);
                sessions.add(session);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture des ressources
            closeResultSet(resultSet);
            closeStatement(statement);
        }
        return sessions;
    }

    private void saveFormationsForSession(int sessionId, List<Formation> formations, Connection conn)
            throws SQLException {
        String query = "INSERT INTO FormationSession (formationId, sessionId) VALUES (?, ?)";
        PreparedStatement formationStatement = conn.prepareStatement(query);

        for (Formation formation : formations) {
            if (formation != null) {
                formationStatement.setInt(1, formation.getId());
                formationStatement.setInt(2, sessionId);
                formationStatement.executeUpdate();
            }
        }
    }

    private void saveEtudiantsForSession(int sessionId, List<User> users, Connection conn) throws SQLException {
        String query = "INSERT INTO InscriptionSession (etudiantId, sessionId) VALUES (?, ?)";
        PreparedStatement etudiantStatement = conn.prepareStatement(query);

        for (User user : users) {
            if (user != null ) {
                etudiantStatement.setInt(1, user.getId());
                etudiantStatement.setInt(2, sessionId);
                etudiantStatement.executeUpdate();
            }
        }
    }

    private void saveTypePaiementForSession(int sessionId, List<TypePaiement> typespayment, Connection conn)
            throws SQLException {
        String query = "INSERT INTO TypePaiementSession (typePayementId, sessionId) VALUES (?, ?)";
        PreparedStatement typePaiementStatement = conn.prepareStatement(query);

        for (TypePaiement typePaiement : typespayment) {
            if (typePaiement != null) {
                typePaiementStatement.setInt(1, typePaiement.id);
                typePaiementStatement.setInt(2, sessionId);
                typePaiementStatement.executeUpdate();
            }
        }
    }

    private void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteFormationsForSession(int sessionId, Connection conn) throws SQLException {
        String query = "DELETE FROM FormationSession WHERE sessionId=?";
        PreparedStatement deleteStatement = conn.prepareStatement(query);
        deleteStatement.setInt(1, sessionId);
        deleteStatement.executeUpdate();
    }

    private void deleteTypePaiementForSession(int sessionId, Connection conn) throws SQLException {
        String query = "DELETE FROM TypePaiementSession WHERE sessionId=?";
        PreparedStatement deleteStatement = conn.prepareStatement(query);
        deleteStatement.setInt(1, sessionId);
        deleteStatement.executeUpdate();
    }

    private void deleteEtudiantForSession(int sessionId, Connection conn) throws SQLException {
        String query = "DELETE FROM InscriptionSession WHERE sessionId=?";
        PreparedStatement deleteStatement = conn.prepareStatement(query);
        deleteStatement.setInt(1, sessionId);
        deleteStatement.executeUpdate();
    }

    @Override
    public void inscriptionSession(int etudiantId, int sessionId) {
        System.out.println("cette méthode est appelée");
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        try{
            String query = "INSERT INTO InscriptionSession (etudiantId, sessionId) VALUES (?, ?)";
            statement = conn.prepareStatement(query);
            statement.setInt(1, etudiantId);
            statement.setInt(2, sessionId);
            statement.executeUpdate();
            System.out.println("etudiant bien inscrit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void desinscriptionSession(int etudiantId, int sessionId) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM InscriptionSession WHERE etudiantId = ? AND sessionId = ?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, etudiantId);
            statement.setInt(2, sessionId);
            statement.executeUpdate();
            System.out.println("étudiant bien désinscrit");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Session addSession(int authorId, String nom, String description, List<Formation> formations, double prix,
            List<TypePaiement> typespayment, int nbPlacesMax, String lieu, String date) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        Session createdSession = null;

        try {
            String query = "INSERT INTO Sessions (authorId, nom, description, prix, nbPlacesMax, lieu, date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, authorId);
            statement.setString(2, nom);
            statement.setString(3, description);
            statement.setDouble(4, prix);
            statement.setInt(5, nbPlacesMax);
            statement.setString(6, lieu);
            statement.setString(7, date);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 1) {
                generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int sessionId = generatedKeys.getInt(1);

                    saveFormationsForSession(sessionId, formations, conn);

                    saveTypePaiementForSession(sessionId, typespayment, conn);

                    createdSession = new Session(sessionId, authorId, nom, description, prix, nbPlacesMax, lieu, date);
                    createdSession.setFormations(formations);
                    createdSession.setTypespaiement(typespayment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture des ressources
            closeResultSet(generatedKeys);
            closeStatement(statement);
        }

        return createdSession;
    }

    @Override
    public Session setSession(int sessionId, int authorId, String nom, String description, List<Formation> formations,
            List<User> etudiants, double prix, List<TypePaiement> typespayment, int nbPlacesMax, String lieu,
            String date) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement statement = null;

        try {
            String query = "UPDATE Sessions SET authorId=?, nom=?, description=?, prix=?, nbPlacesMax=?, lieu=?, date=? WHERE id=?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, authorId);
            statement.setString(2, nom);
            statement.setString(3, description);
            statement.setDouble(4, prix);
            statement.setInt(5, nbPlacesMax);
            statement.setString(6, lieu);
            statement.setString(7, date);
            statement.setInt(8, sessionId);

            statement.executeUpdate();

            deleteFormationsForSession(sessionId, conn);

            saveFormationsForSession(sessionId, formations, conn);

            deleteTypePaiementForSession(sessionId, conn);

            saveTypePaiementForSession(sessionId, typespayment, conn);

            deleteEtudiantForSession(sessionId, conn);

            saveEtudiantsForSession(sessionId, etudiants, conn);

            // Créer un nouvel objet Session avec les valeurs mises à jour et le renvoyer
            Session updatedSession = new Session(sessionId, authorId, nom, description, prix, nbPlacesMax, lieu, date);
            updatedSession.setEtudiants(etudiants);
            updatedSession.setFormations(formations);
            updatedSession.setTypespaiement(typespayment);
            return updatedSession;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // Fermeture des ressources
            closeStatement(statement);
        }
    }
}
