/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.t2ti.java;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author T2Ti
 */
@Entity
@Table(name = "cep")
public class CepVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "UF")
    private String uf;
    @Column(name = "SIGLA_PAIS")
    private String siglaPais;

    public CepVO() {
    }

    public CepVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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
        if (!(object instanceof CepVO)) {
            return false;
        }
        CepVO other = (CepVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.t2ti.java.CepVO[id=" + id + "]";
    }

    /**
     * @return the siglaPais
     */
    public String getSiglaPais() {
        return siglaPais;
    }

    /**
     * @param siglaPais the siglaPais to set
     */
    public void setSiglaPais(String siglaPais) {
        this.siglaPais = siglaPais;
    }

}
