package fp_funciones;
import java.util.List;
import java.util.ArrayList;
public class funciones {
	//primera
	public static boolean esPrimo(int n) {
		if (n%2 == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static long calcularFactorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("El factorial no está definido para números negativos");
	       	}
	        long resultado = 1	;
	        for (int i = 2; i <= n; i++) {
	            resultado *= i;
	        }
	        return resultado;
	    }

	public static double combinatorio(int n, int k) {
		if(n < k) {
			throw new IllegalArgumentException("n debe ser mayor o igual que k");
		} else { 
			return funciones.calcularFactorial(n)/(funciones.calcularFactorial(k)* 
				   funciones.calcularFactorial(n -k));
			
		}
	}
	
	public static double funcionS(int n, int k) {
		if(n < k) {
			throw new IllegalArgumentException("n debe ser mayor o igual que k");
		}
		double resultado = 0;
		for(int i = 0; i <= k; i++) {
			resultado = resultado + (Math.pow(-1, i)* funciones.combinatorio(k, i)* 
						Math.pow(k-i, n));
		}
		return resultado;	
	}
	
	public static List<Integer> calcularDiferencias(List<Integer> lista) {
        List<Integer> diferencias = new ArrayList<>();
        
        if (lista.size() <= 1) {
            return diferencias; 
        }
        
        for (int i = 1; i < lista.size(); i++) {
            int diferencia = lista.get(i) - lista.get(i - 1); 
            diferencias.add(diferencia); 
        }
        
        return diferencias;
    }
	
	public static String encontrarCadenaMasLarga(List<String> lista) {
        
        String cadenaMasLarga = lista.get(0); 
        for (String cadena : lista) {
            if (cadena.length() > cadenaMasLarga.length()) {
                cadenaMasLarga = cadena; 
            }
        }
        
        return cadenaMasLarga;
    }
	
	//Defensa proyecto Java (funciones)
	
	//A
	
	public static int funcionP2(int n,int k) {
		if(k>=n) {
			throw new IllegalArgumentException("n debe ser mayor o igual a k");
		}
		int resultado = 1;
		for(int i = 0; i <= k-2;i++) {
			resultado = resultado * (n -i);
		}
		return resultado;
	}
	
	//B
	public static double fucionC2(int n, int k) {
		if(n <= k) {
			throw new IllegalArgumentException("n debe ser mayor  que k");
		} else { 
			return funciones.calcularFactorial(n)/(funciones.calcularFactorial(k +1)* 
				   funciones.calcularFactorial(n -(k +1)));	
		}
	}
	
	
	
	
	

	
}
	
	

