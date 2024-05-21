package entrega_tres;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Objects;




public class Cuenta {
	
	private String iban;
	private String dni;
	private LocalDate fechaDeCreacion;
	private Double saldo;
	
	
	private Cuenta(String iban, String dni, LocalDate fechaDeCreacion, Double saldo) {
		this.iban = iban;
		this.dni = dni;
		this.fechaDeCreacion = fechaDeCreacion;
		this.saldo = saldo;
	}

	
	public static Cuenta of(String iban, String dni, LocalDate fechaDeCreacion, Double saldo) {
		return new Cuenta(iban,  dni, fechaDeCreacion,  saldo);
	}
	
	public static Cuenta parse(String linea) {
		//ES5267093500351659831393,52184462S,2017-06-25 03:09:54,129522.44
		String[] partes = linea.split(",");
		
		String iban = partes[0];
		String dni = partes[1];
		LocalDateTime fechaDeCreaciondt = LocalDateTime.parse(partes[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		LocalDate fechaDeCreacion = fechaDeCreaciondt.toLocalDate();
		Double saldo = Double.parseDouble(partes[3]);
		
		return Cuenta.of(iban, dni, fechaDeCreacion, saldo);
    }
	
	 //Getter y setters 
	 public String iban() {
	        return iban;
	 }

	 public void setIban(String iban) {
	        this.iban = iban;
	 }
	
	 public String dni() {
	        return dni;
	    }

	 public void setDni(String dni) {
	        this.dni = dni;
	        
	  }

	 public LocalDate fechaDeCreacion() {
	        return fechaDeCreacion;
	    }

	 public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
	        this.fechaDeCreacion = fechaDeCreacion;
	        
	    }

	 public Double saldo() {
	        return saldo;
	    }

	 public void setSaldo(Double saldo) {
	        this.saldo = saldo;
	}
	
	public void ingresar(Double cantidad) {
		saldo += cantidad;
	}
	
	
	public void retirar(Double cantidad) {
		saldo -= cantidad;
	}

	//Criterio de igualdad
	@Override
	public int hashCode() {
		return Objects.hash(dni, fechaDeCreacion, iban, saldo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(fechaDeCreacion, other.fechaDeCreacion)
				&& Objects.equals(iban, other.iban) && Objects.equals(saldo, other.saldo);
	}
	
	 
	public String toString() {
        return iban + ", " + saldo;
    }

}
