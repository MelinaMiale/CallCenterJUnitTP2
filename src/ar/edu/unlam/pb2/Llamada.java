package ar.edu.unlam.pb2;

import java.util.Random;

public class Llamada {

	Contacto candidatoALlamar;
	Boolean llamadaFinalizada;
	Boolean fueExitosa;
	String comentario;
	//Operador operadorAsignadoALaLlamada;
	
	public Llamada() {
		this.candidatoALlamar = this.seleccionarCandidatoValido();
		this.llamadaFinalizada = false;
	}
	
	public Contacto getCandidatoALlamar() {
		return candidatoALlamar;
	}
	
	public Contacto seleccionarCandidatoValido() {
		Random aleatorio = new Random();
		int posicionSeleccionada = aleatorio.nextInt(Empresa.CANDIDATOS.size());
		while(!Contacto.validarParaLlamar(Empresa.CANDIDATOS.get(posicionSeleccionada)).isEmpty()){
			posicionSeleccionada = aleatorio.nextInt(Empresa.CANDIDATOS.size());
		}
		
		return Empresa.CANDIDATOS.get(posicionSeleccionada);
	}
	
	public Boolean getFueExitosa() {
		return this.fueExitosa;
	}

	public void setFueExitosa(boolean finalizoConExito) {
		this.fueExitosa = finalizoConExito;
		this.llamadaFinalizada = true;
	}

	public void agregarComentario(String comentario) {
		if(this.llamadaFinalizada) {
			this.comentario = comentario;	
		}
			
	}
	
	public String getComentario() {
		return this.comentario;
	}
	
}


