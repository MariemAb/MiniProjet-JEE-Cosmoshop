/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mariem
 */
@Entity
@Table(name = "article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")
    , @NamedQuery(name = "Article.findByIdarticle", query = "SELECT a FROM Article a WHERE a.idarticle = :idarticle")
    , @NamedQuery(name = "Article.findByLibelle", query = "SELECT a FROM Article a WHERE a.libelle = :libelle")
    , @NamedQuery(name = "Article.findByDesc", query = "SELECT a FROM Article a WHERE a.desc = :desc")
    , @NamedQuery(name = "Article.findByPrix", query = "SELECT a FROM Article a WHERE a.prix = :prix")
    , @NamedQuery(name = "Article.findByImg", query = "SELECT a FROM Article a WHERE a.img = :img")
    , @NamedQuery(name = "Article.findByQte", query = "SELECT a FROM Article a WHERE a.qte = :qte")
    , @NamedQuery(name = "Article.findByDateajout", query = "SELECT a FROM Article a WHERE a.dateajout = :dateajout")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarticle")
    private Integer idarticle;
    @Size(max = 100)
    @Column(name = "libelle")
    private String libelle;
    @Size(max = 500)
    @Column(name = "desc")
    private String desc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix")
    private Double prix;
    @Size(max = 200)
    @Column(name = "img")
    private String img;
    @Column(name = "qte")
    private Integer qte;
    @Column(name = "dateajout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateajout;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private Collection<LigneCommande> ligneCommandeCollection;

    public Article() {
    }

    public Article(Integer idarticle) {
        this.idarticle = idarticle;
    }

    public Integer getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Integer idarticle) {
        this.idarticle = idarticle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Date getDateajout() {
        return dateajout;
    }

    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }

    @XmlTransient
    public Collection<LigneCommande> getLigneCommandeCollection() {
        return ligneCommandeCollection;
    }

    public void setLigneCommandeCollection(Collection<LigneCommande> ligneCommandeCollection) {
        this.ligneCommandeCollection = ligneCommandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarticle != null ? idarticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idarticle == null && other.idarticle != null) || (this.idarticle != null && !this.idarticle.equals(other.idarticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Article[ idarticle=" + idarticle + " ]";
    }
    
}
