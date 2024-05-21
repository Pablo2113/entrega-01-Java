package entrega_tres;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Comparator;

import us.lsi.ejemplos_b1_tipos.Persona;

public class Questions {

	//	Vencimiento de los prestamos de un cliente
	public static Set<LocalDate> vencimientoDePrestamosDeCliente(Banco banco,String dni) {
		return banco.prestamosDeCliente(dni).stream()
	            .map(Prestamo::fechaVencimiento)
	            .collect(Collectors.toSet());
	}
	//	Persona con más prestamos
	public static Persona clienteConMasPrestamos(Banco banco) {
		Map<String,Integer> prestamos = banco.prestamos().todos().stream()
				.collect(Collectors.groupingBy(x -> x.dniCliente(),
						Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
		
		Integer numeroMaximoPrestamos = prestamos.values().stream().mapToInt(x -> x)
				.max().getAsInt();
		
		String dni = prestamos.entrySet().stream()
				.filter(x -> x.getValue().equals(numeroMaximoPrestamos))
				.map(Map.Entry::getKey)
				.findFirst().orElse(null);
		
		
		return banco.personas().todos().stream()
				.filter(x -> x.dni().equals(dni))
				.findFirst().orElse(null);
		
	      
		
	}
	//	Cantidad total de los crétditos gestionados por un empleado
	public static Double cantidadPrestamosPmpledado(Banco banco,String dni) {
		return banco.prestamosDeCliente(dni).stream()
				.mapToDouble(Prestamo::cantidad).sum();
				
	}
	//	Empleado más longevo
	public static Persona empleadoMasLongevo(Banco banco) {
		return banco.empleados().todos().stream().map(x->x.persona()).
				sorted((x,y) -> y.edad().compareTo(x.edad()))
				.toList().get(0);
	}
	
	
	
	//	Interés mínimo, máximo y medio de los préstamos
	public static record Info(Double min, Double max, Double mean) {
		public String toString() {
			return String.format("(%.2f,%.2f,%.2f)",this.min(),this.max(),this.mean());
		}
	}
	public static  Info rangoDeIntereseDePrestamos(Banco banco) {
		Double min = banco.prestamos().todos().stream()
				.mapToDouble(x->x.interes()).min().getAsDouble();
		
		Double max = banco.prestamos().todos().stream()
				.mapToDouble(x->x.interes()).max().getAsDouble();
		
		Double mean = banco.prestamos().todos().stream()
				.mapToDouble(x->x.interes()).average().getAsDouble();
		
		return new Info(min, max, mean);
	}

	//	Número de préstamos por mes y año
	public static record Info2(Integer mes, Integer año) {
		public String toString() {
			return String.format("(%d,%d)",this.mes(),this.año());
		}
	}
	public static Map<Info2,Integer> numPrestamosPorMesAño(Banco banco) {
		return banco.prestamos().todos().stream()
				.collect(Collectors.groupingBy(x-> new Info2(x.fechaComienzo().getMonthValue(),
						x.fechaComienzo().getYear()),
						Collectors.collectingAndThen(Collectors.counting(),
								Long::intValue)));
	}
}
