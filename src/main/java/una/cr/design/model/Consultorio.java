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
 * John Herrera Jimenez, Kevin Venegas Loria, Caleb Villalta Quesada, Josue David Matamorros.
 */
package una.cr.design.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Grupo Tango
 */
@Entity
@Table(name = "consultorio", catalog = "proyecto", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_consultorio")})
public class Consultorio implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_consultorio", unique = true, nullable = false)
    private int idConsultorio;

    @Column(name = "nombre", unique = false, nullable = false)
    private String nombre;

    @Column(name = "dias", unique = false, nullable = false)
    private String dias;

    @Column(name = "horario", unique = false, nullable = false)
    private String horario;

    @Column(name = "telefono", unique = false, nullable = true)
    private String telefono;

    /**
     * Constructor sin parametros
     */
    public Consultorio() {
    }

    public Consultorio(int idConsultorio, String nombre, String dias, String horario, String telefono) {
        this.idConsultorio = idConsultorio;
        this.nombre = nombre;
        this.dias = dias;
        this.horario = horario;
        this.telefono = telefono;
    }

    public Consultorio(String nombre, String dias, String horario, String telefono) {
        this.nombre = nombre;
        this.dias = dias;
        this.horario = horario;
        this.telefono = telefono;
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idConsultorio;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.dias);
        hash = 97 * hash + Objects.hashCode(this.horario);
        hash = 97 * hash + Objects.hashCode(this.telefono);
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
        final Consultorio other = (Consultorio) obj;
        if (this.idConsultorio != other.idConsultorio) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.dias, other.dias)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultorio{" + "idConsultorio=" + idConsultorio + ", nombre=" + nombre + ", dias=" + dias + ", horario=" + horario + ", telefono=" + telefono + '}';
    }

    
}
