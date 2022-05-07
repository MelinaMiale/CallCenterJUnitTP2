package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestContactos {

	@Test
	public void queSePuedaCrearUnContacto() {
		//given = Preparacion
		Contacto nuevo;
		final Boolean DESEA_SER_LLAMADO = true;
		
		//when = Ejecucion
		nuevo = new Contacto();
		
		//then = Validacion
		assertNotNull(nuevo);
		
		//estos dos son equivalentes
		//asserertEquals(ES_CLIENTE, nuevo.getEsCliente());
		assertFalse(nuevo.getEsCliente());
		
		assertEquals(DESEA_SER_LLAMADO, nuevo.getDeseaSerLlamado());
	}
	
	@Test
	public void queLosDatosDelContactoSeGuardenCorrectamente() {
		//given
		Contacto nuevo;
		final String NOMBRE_Y_APELLIDO_ESPERADO  = "Adrian Rivas";
		final String CELULAR_ESPERAO = "1154652495";
		final String EMAIL_ESPERADO = "arivas@gmail.com";
		final String DIRECCION_ESPERADA = "gelpi y medrano";
		final Integer CODIGO_POSTAL_ESPERADO = 2365;
		final String LOCALIDAD_ESPERADA = "CABA";
		final Provincia PROVINCIA_ESPERADA = Provincia.CABA;
		final Boolean DESEA_SER_LLAMADO = true;
				
		//when
		nuevo = new Contacto(NOMBRE_Y_APELLIDO_ESPERADO, CELULAR_ESPERAO, EMAIL_ESPERADO,
				DIRECCION_ESPERADA, CODIGO_POSTAL_ESPERADO, LOCALIDAD_ESPERADA,
				PROVINCIA_ESPERADA);
		
		//then
		assertNotNull(nuevo);
		assertEquals(NOMBRE_Y_APELLIDO_ESPERADO, nuevo.getNombreYApellido());
		assertEquals(CELULAR_ESPERAO, nuevo.getCelular());
		assertEquals(EMAIL_ESPERADO, nuevo.getEmail());
		assertEquals(DIRECCION_ESPERADA, nuevo.getDireccion());
		assertEquals(CODIGO_POSTAL_ESPERADO, nuevo.getCodigoPostal());
		assertEquals(LOCALIDAD_ESPERADA, nuevo.getLocalidad());
		assertEquals(PROVINCIA_ESPERADA, nuevo.getProvincia());
		assertFalse(nuevo.getEsCliente());
		assertTrue(DESEA_SER_LLAMADO);				
	}
	
	
	//que cuando se cree una nueva llamada, el contacto seleccionado sea valido para ser llamado
	@Test
	public void queElContactoCumplaLosRequisitosParaSerLlamado() {
	
		//given
		Contacto contacto;
		final String NOMBRE_Y_APELLIDO_ESPERADO  = "Adrian Rivas";
		final String CELULAR_ESPERAO = "1154652495";
		final String EMAIL_ESPERADO = "arivas@gmail.com";
		final String DIRECCION_ESPERADA = "gelpi y medrano";
		final Integer CODIGO_POSTAL_ESPERADO = 1420;
		final String LOCALIDAD_ESPERADA = "CABA";
		final Provincia PROVINCIA_ESPERADA = Provincia.CABA;
		boolean esUnContactoValido;
		
		//when
		contacto = new Contacto(NOMBRE_Y_APELLIDO_ESPERADO, CELULAR_ESPERAO, EMAIL_ESPERADO,
				DIRECCION_ESPERADA, CODIGO_POSTAL_ESPERADO, LOCALIDAD_ESPERADA,
				PROVINCIA_ESPERADA);
		esUnContactoValido = Contacto.validarParaLlamar(contacto).size() > 0 ? false : true;
		
		//then
		assertTrue(esUnContactoValido);
	}
	
	@Test
	public void queSiElContactoNoDeseaSerLlamadoSeGuardeUnMensajeDeError() {
		
		//given
		Contacto contacto;
		final String NOMBRE_Y_APELLIDO_ESPERADO  = "Adrian Rivas";
		final String CELULAR_ESPERAO = "1154652495";
		final String EMAIL_ESPERADO = "arivas@gmail.com";
		final String DIRECCION_ESPERADA = "gelpi y medrano";
		final Integer CODIGO_POSTAL_ESPERADO = 1520;
		final String LOCALIDAD_ESPERADA = "CABA";
		final Provincia PROVINCIA_ESPERADA = Provincia.CABA;
		final String MOTIVO_PARA_NO_SER_LLAMADO_ESPERADO = "El contacto pidio que no se lo contacte";
		List<String> MOTIVO_PARA_NO_SER_LLAMADO_RESULTANTE = new ArrayList<>();

		//when
		contacto = new Contacto(NOMBRE_Y_APELLIDO_ESPERADO, CELULAR_ESPERAO, EMAIL_ESPERADO,
				DIRECCION_ESPERADA, CODIGO_POSTAL_ESPERADO, LOCALIDAD_ESPERADA,
				PROVINCIA_ESPERADA);
		contacto.setDeseaSerLlamado(false);
		MOTIVO_PARA_NO_SER_LLAMADO_RESULTANTE = Contacto.validarParaLlamar(contacto);

		//then
		assertEquals(MOTIVO_PARA_NO_SER_LLAMADO_ESPERADO, MOTIVO_PARA_NO_SER_LLAMADO_RESULTANTE.get(0));
	}

	@Test
	public void queSiElContactoNoResideEnUnaZonaDeCoberturaHabilitadaSeGuardeUnMensajeDeError() {
		
		//given
		Contacto contacto;
		final String NOMBRE_Y_APELLIDO_ESPERADO  = "Adrian Rivas";
		final String CELULAR_ESPERAO = "1154652495";
		final String EMAIL_ESPERADO = "arivas@gmail.com";
		final String DIRECCION_ESPERADA = "gelpi y medrano";
		final Integer CODIGO_POSTAL_ESPERADO = 5001;
		final String LOCALIDAD_ESPERADA = "CABA";
		final Provincia PROVINCIA_ESPERADA = Provincia.CABA;
		final String MOTIVO_PARA_NO_SER_LLAMADO_ESPERADO = "La zona de cobertura no esta cubierta";
		List<String> MOTIVO_PARA_NO_SER_LLAMADO_RESULTANTE = new ArrayList<>();

		//when
		contacto = new Contacto(NOMBRE_Y_APELLIDO_ESPERADO, CELULAR_ESPERAO, EMAIL_ESPERADO,
				DIRECCION_ESPERADA, CODIGO_POSTAL_ESPERADO, LOCALIDAD_ESPERADA,
				PROVINCIA_ESPERADA);
		MOTIVO_PARA_NO_SER_LLAMADO_RESULTANTE = Contacto.validarParaLlamar(contacto);

		//then
		assertEquals(MOTIVO_PARA_NO_SER_LLAMADO_ESPERADO, MOTIVO_PARA_NO_SER_LLAMADO_RESULTANTE.get(0));
	}

}
