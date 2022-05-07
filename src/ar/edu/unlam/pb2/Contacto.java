package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;


public class Contacto {

	private String nombreYApellido;
	private String celular;
	private String email;
	private Integer codigoPostal;
	private String direccion;
	private Provincia provincia; 
	private String localidad;
	private Boolean esCliente;
	private Boolean deseaSerLlamado;
	
	
	public Contacto() {
		this.esCliente = false;
		this.deseaSerLlamado = true;
	}

	public Contacto(String nOMBRE_Y_APELLIDO_ESPERADO, String cELULAR_ESPERAO, String eMAIL_ESPERADO,
			String dIRECCION_ESPERADA, Integer cODIGO_POSTAL_ESPERADO, String lOCALIDAD_ESPERADA, Provincia pROVINCIA_ESPERADA) {
		
		this.nombreYApellido = nOMBRE_Y_APELLIDO_ESPERADO;
		this.celular = cELULAR_ESPERAO;
		this.email = eMAIL_ESPERADO;
		this.codigoPostal = cODIGO_POSTAL_ESPERADO;
		this.localidad = lOCALIDAD_ESPERADA;
		this.direccion = dIRECCION_ESPERADA;
		this.provincia = pROVINCIA_ESPERADA;
		this.esCliente = false;
		this.deseaSerLlamado = true;
	}

	public boolean getEsCliente() {
		return esCliente;
	}

	public boolean getDeseaSerLlamado() {
		return deseaSerLlamado;
	}

	public void setEsCliente(Boolean esCliente) {
		this.esCliente = esCliente;
	}

	public void setDeseaSerLlamado(Boolean deseaSerLlamado) {
		this.deseaSerLlamado = deseaSerLlamado;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public static List<String> validarParaLlamar(Contacto contacto) {
		List<String> motivosParaNoSerContactado = new ArrayList<>();
				
		if(contacto.getEsCliente()) {
			motivosParaNoSerContactado.add("El contacto ya es cliente");
		}
		if(!contacto.getDeseaSerLlamado()) {
			motivosParaNoSerContactado.add("El contacto pidio que no se lo contacte");
		}
		
		boolean codigoPostalEnZonaDeCobertura = CodigosZonasDeCobertura.encontrarDadoUnValor(contacto.getCodigoPostal()) != null ? true : false;
		if(!codigoPostalEnZonaDeCobertura) {
			motivosParaNoSerContactado.add("La zona de cobertura no esta cubierta");
		}
		
		return motivosParaNoSerContactado;
	}

		
}
