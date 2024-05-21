package entrega_tres;


import java.util.Set;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.tools.File2;


public class Cuentas {
	
	private static Cuentas gestorDeCuentas = null;
	private Set<Cuenta> cuentas;
	private Map<String, Cuenta> cuentasIban;
	
	private Cuentas(Set<Cuenta> cuentas ) {
		super();
		this.cuentas = cuentas;
		this.cuentasIban = this.cuentas.stream().collect(Collectors.toMap(o ->o.iban() , o -> o));
	}

	public static Cuentas of() {
		if(Cuentas.gestorDeCuentas == null) 
			Cuentas.gestorDeCuentas = Cuentas.parse("bancos/cuentas.txt");
		return Cuentas.gestorDeCuentas;
	}

	public static Cuentas parse(String fichero) {
		Set<Cuenta> cuentas = File2.streamDeFichero(fichero, "UTF-8")
				.map(l -> Cuenta.parse(l))
				.collect(Collectors.toSet());
		Cuentas.gestorDeCuentas = new Cuentas(cuentas);
		return Cuentas.gestorDeCuentas;
	}
	
    
	//Propiedades
	
	public Set<Cuenta> todas() {
        return cuentas;
    }
	
	public Optional<Cuenta> cuentaIban(String iban) {
        return Optional.ofNullable(cuentasIban.get(iban));
    }
	
	public Integer size() {
		return cuentas.size();
		}
	
	public Cuenta cuentaIndex(int n) {
        List<Cuenta> cuentasList = cuentas.stream().collect(Collectors.toList());
        if (n >= 0 && n < cuentasList.size()) {
            return cuentasList.get(n);
        } else {
            throw new IndexOutOfBoundsException("El índice está fuera de los límites de la lista de cuentas.");
        }
    }

	
	
	//Criterio de igualdad
	
	@Override
	public int hashCode() {
		return Objects.hash(cuentas, cuentasIban);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuentas other = (Cuentas) obj;
		return Objects.equals(cuentas, other.cuentas) && Objects.equals(cuentasIban, other.cuentasIban);
	}
	
	String representacionComoCadena() {
	    return cuentas.stream()
	            .map(Cuenta::toString) 
	            .collect(Collectors.joining("\n"));
	}
	
}


	

	
