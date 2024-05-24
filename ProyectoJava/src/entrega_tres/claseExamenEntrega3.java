package entrega_tres;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Set;



import us.lsi.ejemplos_b1_tipos.Persona;

public class claseExamenEntrega3 {
	
	

	public static List<Empleado> empleadosEntreDiaMes(Banco banco, String ini, String fin) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM")
	    return banco.empleados().todos().stream()
	        .filter(empleado -> {
	            LocalDate fechaNacimiento = banco.empleados().todos().map(fecha::persona()).filter(x-> x.fechaDeNacimiento);
	            MonthDay nacimiento = MonthDay.of(fechaNacimiento.getMonth(), fechaNacimiento.getDayOfMonth());
	            return !nacimiento.isBefore(start) && !nacimiento.isAfter(end);
	        })
	        .collect(Collectors.toList());
	}
	
	
		
		
	public Map<Character, List<Empleado>> empleadosConLetraDNI(Banco banco, Set<Character> letras) {
        // Verificar que los parámetros estén informados
        if (banco == null || letras == null) {
            throw new IllegalArgumentException("Todos los parámetros deben estar informados");
        }

        // Verificar que el conjunto de letras solo contiene caracteres alfabéticos
        for (char letra : letras) {
            if (!Character.isLetter(letra)) {
                throw new IllegalArgumentException("El conjunto de letras debe contener solo caracteres alfabéticos");
            }
        }

      
        Map<Character, List<Empleado>> empleadosPorLetra = new HashMap<>();

        
        List<Empleado> todosEmpleados = banco.empleados().todos().stream().collect(Collectors.toList());

        
        for (Empleado empleado : todosEmpleados) {
            Map<String, Integer> dni = banco.empleados().todos().stream().collect(Collectors.groupingBy(x -> x.dni()));
            if (!dni.isEmpty() && Character.isLetter(dni.charAt(0)) && letras.contains(dni.charAt(0))) {
                char letraDNI = dni.charAt(0);
                empleadosPorLetra.computeIfAbsent(letraDNI, k -> new ArrayList<>()).add(empleado);
            }
        }

        return empleadosPorLetra;
    }
	

	
	
	public static void main(String[] args) {
		
		Banco banco = Banco.of();
		
		System.out.println("Empleado entre dia mes:");
		System.out.println(claseExamenEntrega3.empleadosEntreDiaMes(banco, 03, 05);
		
		
		
	}
	
}
