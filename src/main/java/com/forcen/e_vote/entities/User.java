package com.forcen.e_vote.entities;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;


//@Data
@Document(collection = "utilisateurs")
public class User {
    @Id
    private String id;
    private String prenom;
    private String nom;
    private String password;
    private String identifiant;
    private String adresse;
    private String email;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    private String telephone;

    public User(String id, String prenom, String nom, String password, String identifiant, String adresse, String email, String telephone, String statut, Date dateNaissance, String lieuNaissance, List<Role> roles) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.password = password;
        this.identifiant = identifiant;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.statut = statut;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.roles = roles;
    }

    private String statut;
    private Date dateNaissance;
    private String lieuNaissance;
    private List<Role> roles;

}

