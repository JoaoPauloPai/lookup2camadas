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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author T2Ti
 */
@Entity
@Table(name = "cliente")
public class ClienteVO  extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "UF")
    private String uf;
    @Column(name = "SIGLA_PAIS")
    private String siglaPais;
    @JoinColumn(name = "ID_SITUACAO_CLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SituacaoClienteVO situacaoCliente;

    public ClienteVO() {
    }

    public ClienteVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the situacaoCliente
     */
    public SituacaoClienteVO getSituacaoCliente() {
        return situacaoCliente;
    }

    /**
     * @param situacaoCliente the situacaoCliente to set
     */
    public void setSituacaoCliente(SituacaoClienteVO situacaoCliente) {
        this.situacaoCliente = situacaoCliente;
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
