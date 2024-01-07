package com.example.CommentairePackage;

import java.util.*;

/**
 *
 */
public class GenericCRUD<T, ID> {

    private List<T> entities = new ArrayList<>();

    public GenericCRUD() {
    }

    public T create(T entity) {
        entities.add(entity);
        return entity;
    }

    public List<T> getAll() {
        return entities;
    }

    public T getById(ID id) {
        // Recherche de l'entité par ID
        // Retourne l'entité correspondante ou null si non trouvée
        return null; // Implémentez la logique de recherche par ID ici
    }

    public T getByProperty(String propertyName, Object value) {
        // Recherche de l'entité par une propriété spécifique
        // Retourne l'entité correspondante ou null si non trouvée
        return null; // Implémentez la logique de recherche par propriété ici
    }

    public T update(T entity) {
        // Mise à jour de l'entité dans la liste
        // Retourne l'entité mise à jour ou null si non trouvée
        return null; // Implémentez la logique de mise à jour ici
    }

    public void deleteById(ID id) {
        // Suppression de l'entité par ID
        // Implémentez la logique de suppression par ID ici
    }

    public void delete(T entity) {
        // Suppression de l'entité de la liste
        entities.remove(entity);
    }
}