/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariem
 */
@Entity
@Table(name = "ligne_commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LigneCommande.findAll", query = "SELECT l FROM LigneCommande l")
    , @NamedQuery(name = "LigneCommande.findByIdcmd", query = "SELECT l FROM LigneCommande l WHERE l.ligneCommandePK.idcmd = :idcmd")
    , @NamedQuery(name = "LigneCommande.findByIdart", query = "SELECT l FROM LigneCommande l WHERE l.ligneCommandePK.idart = :idart")
    , @NamedQuery(name = "LigneCommande.findByNbr", query = "SELECT l FROM LigneCommande l WHERE l.nbr = :nbr")})
public class LigneCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LigneCommandePK ligneCommandePK;
    @Column(name = "nbr")
    private Integer nbr;
    @JoinColumn(name = "idart", referencedColumnName = "idarticle", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "idcmd", referencedColumnName = "idcommande", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;

    public LigneCommande() {
    }

    public LigneCommande(LigneCommandePK ligneCommandePK) {
        this.ligneCommandePK = ligneCommandePK;
    }

    public LigneCommande(int idcmd, int idart) {
        this.ligneCommandePK = new LigneCommandePK(idcmd, idart);
    }

    public LigneCommandePK getLigneCommandePK() {
        return ligneCommandePK;
    }

    public void setLigneCommandePK(LigneCommandePK ligneCommandePK) {
        this.ligneCommandePK = ligneCommandePK;
    }

    public Integer getNbr() {
        return nbr;
    }

    public void setNbr(Integer nbr) {
        this.nbr = nbr;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ligneCommandePK != null ? ligneCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LigneCommande)) {
            return false;
        }
        LigneCommande other = (LigneCommande) object;
        if ((this.ligneCommandePK == null && other.ligneCommandePK != null) || (this.ligneCommandePK != null && !this.ligneCommandePK.equals(other.ligneCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LigneCommande[ ligneCommandePK=" + ligneCommandePK + " ]";
    }
    
}
