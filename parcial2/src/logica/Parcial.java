package logica;

public class Parcial {

	
	public String Cuadratica(double A, double B, double C) throws Exception {
		
		if (A == 0) {
			throw new Exception ("El coeficiente A no puede ser 0");
		}
		
		double discriminante = Math.pow(B, 2) - (4 * A * C);

		if (discriminante < 0) {
            throw new Exception("La ecuacion tiene raíces complejas");
        }
		
		else {
			double x1 = (-B + discriminante) / 2*A;
			double x2 = (-B - discriminante) / 2*A;
			
			 return "Raiz 1: " + x1 + "\nRaiz 2: " + x2;
		}
		
	}
			
        
}
	
	
	

