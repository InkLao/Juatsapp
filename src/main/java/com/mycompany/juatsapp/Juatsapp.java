/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.juatsapp;

import dominio.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eduar
 */
public class Juatsapp {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("com.mycompany_juatsapp_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Usuario usuario = new Usuario();
        usuario.setContraseña("adssad");
        usuario.setDireccion("Nerones 40");
        usuario.setFechaNacimiento("15/02/2002");
        usuario.setSexo("Masculino");
        usuario.setTelefono((long) 1671072782);
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
