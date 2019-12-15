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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mariem
 */
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findByIdcommande", query = "SELECT c FROM Commande c WHERE c.idcommande = :idcommande")
    , @NamedQuery(name = "Commande.findByDatecmd", query = "SELECT c FROM Commande c WHERE c.datecmd = :datecmd")
    , @NamedQuery(name = "Commande.findByPrixtotale", query = "SELECT c FROM Commande c WHERE c.prixtotale = :prixtotale")
    , @NamedQuery(name = "Commande.findByEtat", query = "SELECT c FROM Commande c WHERE c.etat = :etat")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcommande")
    private Integer idcommande;
    @Column(name = "datecmd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecmd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prixtotale")
    private Double prixtotale;
    @Column(name = "etat")
    private Integer etat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private Collection<LigneCommande> ligneCommandeCollection;
    @JoinColumn(name = "login", referencedColumnName = "login")
    @ManyToOne
    private Client login;

    public Commande() {
    }

    public Commande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    public Integer getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    public Date getDatecmd() {
        return datecmd;
    }

    public void setDatecmd(Date datecmd) {
        this.datecmd = datecmd;
    }

    public Double getPrixtotale() {
        return prixtotale;
    }

    public void setPrixtotale(Double prixtotale) {
        this.prixtotale = prixtotale;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    @XmlTransient
    public Collection<LigneCommande> getLigneCommandeCollection() {
        return ligneCommandeCollection;
    }

    public void setLigneCommandeCollection(Collection<LigneCommande> ligneCommandeCollection) {
        this.ligneCommandeCollection = ligneCommandeCollection;
    }

    public Client getLogin() {
        return login;
    }

    public void setLogin(Client login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcommande != null ? idcommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idcommande == null && other.idcommande != null) || (this.idcommande != null && !this.idcommande.equals(other.idcommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Commande[ idcommande=" + idcommande + " ]";
    }
    
}
