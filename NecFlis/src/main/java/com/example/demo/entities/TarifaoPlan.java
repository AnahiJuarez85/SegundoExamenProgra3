package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarifas")
public class TarifaoPlan {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "tarifa")
		private String nombreTarifa;
		@Column(name = "descripcion")
		private String descripcionTarifa;
		@Column(name = "monto")
		private int montoTarifa;
		@Column(name = "fecha")
		private Date fechaCreacion;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombreTarifa() {
			return nombreTarifa;
		}
		public void setNombreTarifa(String nombreTarifa) {
			this.nombreTarifa = nombreTarifa;
		}
		public String getDescripcionTarifa() {
			return descripcionTarifa;
		}
		public void setDescripcionTarifa(String descripcionTarifa) {
			this.descripcionTarifa = descripcionTarifa;
		}
		public int getMontoTarifa() {
			return montoTarifa;
		}
		public void setMontoTarifa(int montoTarifa) {
			this.montoTarifa = montoTarifa;
		}
		public Date getFechaCreacion() {
			return fechaCreacion;
		}
		public void setFechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}
		
}


