/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mariem
 */
@Embeddable
public class LigneCommandePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idcmd")
    private int idcmd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idart")
    private int idart;

    public LigneCommandePK() {
    }

    public LigneCommandePK(int idcmd, int idart) {
        this.idcmd = idcmd;
        this.idart = idart;
    }

    public int getIdcmd() {
        return idcmd;
    }

    public void setIdcmd(int idcmd) {
        this.idcmd = idcmd;
    }

    public int getIdart() {
        return idart;
    }

    public void setIdart(int idart) {
        this.idart = idart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcmd;
        hash += (int) idart;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LigneCommandePK)) {
            return false;
        }
        LigneCommandePK other = (LigneCommandePK) object;
        if (this.idcmd != other.idcmd) {
            return false;
        }
        if (this.idart != other.idart) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LigneCommandePK[ idcmd=" + idcmd + ", idart=" + idart + " ]";
    }
    
}
