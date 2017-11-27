/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "PERSONNE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p")})
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @JoinTable(name = "REAL_SERIE", joinColumns = {
        @JoinColumn(name = "REALISATEURS_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SERIESREALISES_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Serie> serieList;
    @JoinTable(name = "REAL_FILM", joinColumns = {
        @JoinColumn(name = "REALISATEURS_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "FILMSREALISES_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Film> filmList;
    @JoinTable(name = "ACTEUR_FILM", joinColumns = {
        @JoinColumn(name = "ACTEURS_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "FILMSJOUES_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Film> filmList1;
    @JoinTable(name = "ACTEUR_SERIE", joinColumns = {
        @JoinColumn(name = "ACTEURS_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SERIESJOUES_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Serie> serieList1;

    public Personne() {
    }

    public Personne(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlTransient
    public List<Serie> getSerieList() {
        return serieList;
    }

    public void setSerieList(List<Serie> serieList) {
        this.serieList = serieList;
    }

    @XmlTransient
    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    @XmlTransient
    public List<Film> getFilmList1() {
        return filmList1;
    }

    public void setFilmList1(List<Film> filmList1) {
        this.filmList1 = filmList1;
    }

    @XmlTransient
    public List<Serie> getSerieList1() {
        return serieList1;
    }

    public void setSerieList1(List<Serie> serieList1) {
        this.serieList1 = serieList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atelierjavaweb.entity.Personne[ id=" + id + " ]";
    }
    
}
