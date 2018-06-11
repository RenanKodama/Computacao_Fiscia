/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author geovani
 */
@Entity
@Table(name = "Leitura")
@NamedQueries({
    @NamedQuery(name = "Leitura.findAll", query = "SELECT l FROM Leitura l")})
public class Leitura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLeitura")
    private Integer idLeitura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorLeitura")
    private Float valorLeitura;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "Sensor_idSensor", referencedColumnName = "idSensor")
    @ManyToOne(optional = false)
    private Sensor sensoridSensor;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;

    public Leitura() {
    }

    public Leitura(Integer idLeitura) {
        this.idLeitura = idLeitura;
    }

    public Integer getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(Integer idLeitura) {
        this.idLeitura = idLeitura;
    }

    public Float getValorLeitura() {
        return valorLeitura;
    }

    public void setValorLeitura(Float valorLeitura) {
        this.valorLeitura = valorLeitura;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Sensor getSensoridSensor() {
        return sensoridSensor;
    }

    public void setSensoridSensor(Sensor sensoridSensor) {
        this.sensoridSensor = sensoridSensor;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLeitura != null ? idLeitura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leitura)) {
            return false;
        }
        Leitura other = (Leitura) object;
        if ((this.idLeitura == null && other.idLeitura != null) || (this.idLeitura != null && !this.idLeitura.equals(other.idLeitura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Leitura[ idLeitura=" + idLeitura + " ]";
    }
    
}
