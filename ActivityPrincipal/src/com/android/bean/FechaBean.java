package com.android.bean;

public class FechaBean {

	private String nroCampana;
	private String anho;
	private String fechaInicio;
	private String fechaFin;
	private String semanaAnual;
	
	public FechaBean(String nroCampana, String anho, String fechaInicio, String fechaFin, String semanaAnual){
		
		this.nroCampana = nroCampana;
		this.anho = anho;
		this.fechaInicio = fechaInicio ;
		this.fechaFin = fechaFin;
		this.semanaAnual = semanaAnual;
	}
	
	
	public String getAnho() {
		return anho;
	}
	public void setAnho(String anho) {
		this.anho = anho;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getSemanaAnual() {
		return semanaAnual;
	}
	public void setSemanaAnual(String semanaAnual) {
		this.semanaAnual = semanaAnual;
	}
	
	public String getNroCampana() {
		return nroCampana;
	}

	public void setNroCampana(String nroCampana) {
		this.nroCampana = nroCampana;
	}

}
