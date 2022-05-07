package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEmpresa {

	@Test
	public void queLaEmpresaPuedaAgregarUnContacto() {
		//given
		Empresa oesteColorCompany;
		
		final String NOMBRE_Y_APELLIDO_ESPERADO  = "Adrian Rivas";
		final String CELULAR_ESPERAO = "1154652495";
		final String EMAIL_ESPERADO = "arivas@gmail.com";
		final String DIRECCION_ESPERADA = "gelpi y medrano";
		final Integer CODIGO_POSTAL_ESPERADO = 1420;
		final String LOCALIDAD_ESPERADA = "CABA";
		final Provincia PROVINCIA_ESPERADA = Provincia.CABA;
		Contacto contacto = new Contacto(NOMBRE_Y_APELLIDO_ESPERADO, CELULAR_ESPERAO, EMAIL_ESPERADO,
				DIRECCION_ESPERADA, CODIGO_POSTAL_ESPERADO, LOCALIDAD_ESPERADA,
				PROVINCIA_ESPERADA);
		
		//when
		oesteColorCompany = new Empresa();
		oesteColorCompany.agregarUnCliente(contacto);
		
		//then
		assertNotNull(oesteColorCompany);
		assertNotNull(oesteColorCompany.getContactosDeLaEmpresa());
		assertTrue(oesteColorCompany.getContactosDeLaEmpresa().size() > 0);
	}
	
	@Test
	public void queLaEmpresaPuedaEliminarUnContacto() {
		//given
		Empresa oesteColorCompany;
		
		final String NOMBRE_Y_APELLIDO_ESPERADO  = "Adrian Rivas";
		final String CELULAR_ESPERAO = "1122220000";
		final String EMAIL_ESPERADO = "arivas@gmail.com";
		final String DIRECCION_ESPERADA = "gelpi y medrano";
		final Integer CODIGO_POSTAL_ESPERADO = 1420;
		final String LOCALIDAD_ESPERADA = "ITUZAINGO";
		final Provincia PROVINCIA_ESPERADA = Provincia.CABA;
		Contacto contacto = new Contacto(NOMBRE_Y_APELLIDO_ESPERADO, CELULAR_ESPERAO, EMAIL_ESPERADO,
				DIRECCION_ESPERADA, CODIGO_POSTAL_ESPERADO, LOCALIDAD_ESPERADA,
				PROVINCIA_ESPERADA);
		
		boolean estaEnLaListaDeContactos;
		
		//when
		oesteColorCompany = new Empresa();
		oesteColorCompany.eliminarUnContacto(contacto);
		estaEnLaListaDeContactos = oesteColorCompany.getContactosDeLaEmpresa().contains(contacto);
		
		//then
		assertNotNull(oesteColorCompany);
		assertNotNull(oesteColorCompany.getContactosDeLaEmpresa());
		assertFalse(estaEnLaListaDeContactos);
	}
	

}

