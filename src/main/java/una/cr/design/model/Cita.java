/*
 * Copyright (C) 2016 Grupo Tango
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Estudiantes: Luis Alonso Morgan Campos,
 * John Herrera Jimenez, Kevin Venegas, Caleb Villalta, Josue David Matamorros.
 */
package una.cr.design.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Grupo Tango
 */
@Entity
@Table(name = "cita", catalog = "proyecto", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_cita")})
public class Cita {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_cita", unique = true, nullable = false)
    private int idCita;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    @JoinColumn(name = "id_paciente", nullable = false)
    Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    @JoinColumn(name = "id_consultorio", nullable = false)
    private Consultorio consultorio;
    
    @Column(name = "fecha", unique = false, nullable = false)
    private String fecha;
    
    @Column(name = "confirmado", unique = false, nullable = false)
    private boolean confirmar;

    /**
     * Constructor sin parametro
     */
    public Cita() {
    }

 

    /**
     * Constructor con parametro
     *
     * @param idCita
     * @param paciente
     * @param consultorio
     * @param fecha
     * @param confirmar
     */
       public Cita(int idCita, Paciente paciente, Consultorio consultorio, String fecha, boolean confirmar) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.consultorio = consultorio;
        this.fecha = fecha;
        this.confirmar = confirmar;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isConfirmar() {
        return confirmar;
    }

    public void setConfirmar(boolean confirmar) {
        this.confirmar = confirmar;
    }

    /**
     * Verifica el estado de confirmacion de la cita
     *
     * @return aux
     */
    public String confirmado() {
        String aux;
        if (isConfirmar() == true) {
            aux = "Confirmado";
        } else {
            aux = "No Confirmado";
        }

        return aux;
    }

    /**
     *
     * @return toString
     */
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idCita;
        hash = 97 * hash + Objects.hashCode(this.paciente);
        hash = 97 * hash + Objects.hashCode(this.consultorio);
        hash = 97 * hash + Objects.hashCode(this.fecha);
        hash = 97 * hash + Objects.hashCode(this.confirmar);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cita other = (Cita) obj;
        if (this.idCita != other.idCita) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.consultorio, other.consultorio)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.confirmar, other.confirmar)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Cita{" + "id=" + idCita + ", consultorio=" + consultorio + ", fecha=" + fecha + ", confirmar=" + confirmar + '}';
    }

}
