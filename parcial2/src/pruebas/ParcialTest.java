package pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logica.Parcial;


import static org.junit.jupiter.api.Assertions.*;

public class ParcialTest {
	
	private Parcial parcial;
	
	@BeforeEach
	public void setUp() {
		this.parcial = new Parcial();
	}
		
	@Test
	public void testCasoValido() throws Exception {
		String resultado = parcial.Cuadratica(1, 5, 6);
		assertEquals("Raiz 1: -2.0\nRaiz 2: -3.0", resultado);
		
	}
	
	@Test
	public void testCasoErroneoCompleja() throws Exception {
		Exception excepcion = assertThrows(
				Exception.class,
				() -> this.parcial.Cuadratica(1, 2, 2)
				);
		
		assertEquals("La ecuacion tiene raíces complejas", excepcion.getMessage());
		
	}
	
	@Test
	public void testCasoErroneoCoeficienteA() throws Exception {
		Exception excepcion = assertThrows(
				Exception.class,
				() -> this.parcial.Cuadratica(0, 2, 2)
				);
		
		assertEquals("El coeficiente A no puede ser 0", excepcion.getMessage());
		
	}

}
