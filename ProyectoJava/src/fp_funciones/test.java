package fp_funciones;
import java.util.List;

import fp_funciones.funciones;

import java.util.ArrayList;
public class test {
	public static void main(String[] args ) {
		
		List<Integer> listaEnteros = new ArrayList<>();
        listaEnteros.add(5);
        listaEnteros.add(9);
        listaEnteros.add(12);
        listaEnteros.add(20);
        
        List<String> listaCadena = List.of("Hola", "Armario" , "Sofá", "Salón");
		
		
		System.out.println("Hello world");
		
		System.out.println(funciones.esPrimo(6));
	
		System.out.println(funciones.combinatorio(6, 4));
		
		System.out.println(funciones.funcionS(6, 4));
		
		System.out.println(funciones.calcularDiferencias(listaEnteros));
		
		System.out.println(funciones.encontrarCadenaMasLarga(listaCadena));
		
		
	}	
}
