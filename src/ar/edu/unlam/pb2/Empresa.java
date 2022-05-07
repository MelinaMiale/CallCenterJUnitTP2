package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

	public static final List<Contacto> CANDIDATOS = new ArrayList<Contacto>((List.of(
			new Contacto("phill collings", "114523330", "pardise@gmail.com", "arribeños 1200", 1331, "CABA", Provincia.CABA),
			new Contacto("JOE COCKER", "1175364598", "NIGHT_CALLS@GMAIL.COM", "LAS HERAS 300", 1712, "ITUZAINGO", Provincia.CABA),
			new Contacto("CELINE DION", "1196321478", "becauseYouLoveMe@gmail.com", "cerrito 1200", 2000, "CABA", Provincia.CABA),
			new Contacto("rob halford", "1100006666", "judas4ever@gmail.com", "barrio sere 900", 1520, "CASTELAR", Provincia.CABA)
			)));
	private List<Contacto> contactosDeLaEmpresa;
	
	public Empresa() {
		this.contactosDeLaEmpresa = new ArrayList<>();
	}

	public List<Contacto> getContactosDeLaEmpresa() {
		return contactosDeLaEmpresa;
	}

	public void setContactosDeLaEmpresa(List<Contacto> contactosDeLaEmpresa) {
		this.contactosDeLaEmpresa = contactosDeLaEmpresa;
	}

	public void agregarUnCliente(Contacto contacto) {
		this.contactosDeLaEmpresa.add(contacto);	
	}

	public void eliminarUnContacto(Contacto contacto) {
		this.contactosDeLaEmpresa.remove(contacto);
		
	}
		

}
