package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLlamadas {

	@Test
	public void queSePuedaGenerarUnaLlamadaYQueFigureInicialmeteComoNoFinalizada() {
		//given
		Llamada nuevaLlamada;
		final Boolean RESULTADO_ESPERADO = false;
		
		//when
		nuevaLlamada = new Llamada();
				
		//then
		assertNotNull(nuevaLlamada);
		assertEquals(RESULTADO_ESPERADO, nuevaLlamada.llamadaFinalizada);
	}	
	
	@Test
	public void queSeAsigneUnContactoAlMomentoDeGenerarUnaLlamada() {
		//given
		Llamada nuevaLlamada;

		//when
		nuevaLlamada = new Llamada();
		
		//then
		assertNotNull(nuevaLlamada.getCandidatoALlamar());
	}
	
	@Test
	public void queSeAsigneUnContactoYQueSeaUnContactoValidoAlMomentoDeGenerarUnaLlamada() {
		//given
		Llamada nuevaLlamada;
		Contacto valido;
		//when
		nuevaLlamada = new Llamada();
		valido = nuevaLlamada.getCandidatoALlamar();
		
		//then
		assertTrue(Contacto.validarParaLlamar(valido).isEmpty());
	}
	
	@Test
	public void queAlFinalizarUnaLlamadaSeLaPuedaRegistrarComoExitosa() {
		//given
		Empresa oesteColorCompany = new Empresa();
		Llamada nuevaLlamada;

		//when
		nuevaLlamada = new Llamada();
		Contacto personaContactada = nuevaLlamada.getCandidatoALlamar();
		boolean llamadaExitosa = true;
		nuevaLlamada.setFueExitosa(llamadaExitosa);
		personaContactada.setDeseaSerLlamado(false);
		oesteColorCompany.agregarUnCliente(personaContactada);
		
		//then
		assertTrue(nuevaLlamada.getFueExitosa());
	}
	
	@Test
	public void queAlFinalizarUnaLlamadaExitosaSeAgregueElContactoAlListadoDeClientesDeLaEmpresa() {
		//given
		Empresa oesteColorCompany = new Empresa();
		Llamada nuevaLlamada;
		final Boolean EMPRESA_TIENE_AL_MENOS_UN_CLIENTE_REGISTRADO = true;

		//when
		nuevaLlamada = new Llamada();
		Contacto personaContactada = nuevaLlamada.getCandidatoALlamar();
		boolean llamadaExitosa = true;
		nuevaLlamada.setFueExitosa(llamadaExitosa);
		personaContactada.setDeseaSerLlamado(false);
		oesteColorCompany.agregarUnCliente(personaContactada);
		
		//then
		assertEquals(EMPRESA_TIENE_AL_MENOS_UN_CLIENTE_REGISTRADO, oesteColorCompany.getContactosDeLaEmpresa().size() > 0);
		assertTrue(oesteColorCompany.getContactosDeLaEmpresa().contains(personaContactada));
	}
	
	@Test
	public void queSePuedaAgregarUnComentarioAlFinalizarLaLlamada() {
		//given
		Empresa oesteColorCompany = new Empresa();
		Llamada nuevaLlamada;
		final Boolean SE_INGRESO_UN_COMENTARIO = true;

		//when
		nuevaLlamada = new Llamada();
		Contacto personaContactada = nuevaLlamada.getCandidatoALlamar();
		boolean llamadaExitosa = true;
		nuevaLlamada.setFueExitosa(llamadaExitosa);
		personaContactada.setDeseaSerLlamado(false);
		oesteColorCompany.agregarUnCliente(personaContactada);

		nuevaLlamada.agregarComentario("El cliente Manuel Wirtz se suscribe a HBO");
		
		//then
		assertNotNull(nuevaLlamada.getComentario());
		assertEquals(SE_INGRESO_UN_COMENTARIO, !nuevaLlamada.getComentario().isEmpty());
	}
	
	@Test
	public void queNoSePuedaAgregarUnComentarioSiLaLlamadaNoHaFinalizado() {
		//given
		Llamada nuevaLlamada;
		String TEXTO_INGRESADO = "El cliente Manuel Wirtz se suscribe a HBO";

		//when
		nuevaLlamada = new Llamada();
		nuevaLlamada.agregarComentario(TEXTO_INGRESADO);
		
		//then
		assertTrue(nuevaLlamada.getComentario() == null);
		assertNull(nuevaLlamada.getComentario());
	}	
	
	@Test
	public void queAlFinalizarUnaLlamadaSeLaPuedaRegistrarComoNoExitosa() {
		//given
		Empresa oesteColorCompany = new Empresa();
		Llamada nuevaLlamada;
		final Boolean FUE_EXITOSA = false;

		//when
		nuevaLlamada = new Llamada();
		Contacto personaContactada = nuevaLlamada.getCandidatoALlamar();
		//boolean llamadaExitosa = true;
		nuevaLlamada.setFueExitosa(FUE_EXITOSA);
		personaContactada.setDeseaSerLlamado(true);
		
		//then
		assertFalse(nuevaLlamada.getFueExitosa());
		assertFalse(oesteColorCompany.getContactosDeLaEmpresa().contains(personaContactada));

	}
	
	
	
}
