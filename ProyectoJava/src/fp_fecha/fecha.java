package fp_fecha;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
public record fecha(Integer año, Integer mes, Integer dia) {

	private static final List<String> Lista_auxiliar = List.of("Enero", "Febrero", "Marzo", "Abril", 
									"Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
	
	private static final List<String> nombresDiasSemana = Arrays.asList(
			"Sábado", "Domingo" , "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"
    );
	
	public String nombreMes() {
		return Lista_auxiliar.get(mes -1);
	}
	
	private static int congruenciaZeller(int año, int mes, int dia) {
        if (mes < 3) {
            año--;
            mes += 12;
        }
        int k = año % 100;
        int j = año / 100;
        return (dia + (13 * (mes + 1)) / 5 + k + (k / 4) + (j / 4) + 5 * j) % 7;
	}
	
	 public String diaSemana() {
	        int diaSemanaIndex = congruenciaZeller(año, mes, dia);
	        return nombresDiasSemana.get(diaSemanaIndex);
	 }	
	 
	 public static int diaEnMes(int año, int mes) {
		 int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		 if (mes == 2 && esAñoBisiesto(año)) {
	            return 29;
		 } else {
			 return diasPorMes[mes - 1];
		 }
	 }
		 
	 
	 
	 @Override
	public int hashCode() {
		return Objects.hash(año, dia, mes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		fecha other = (fecha) obj;
		return Objects.equals(año, other.año) && Objects.equals(dia, other.dia) && Objects.equals(mes, other.mes);
	}

	public fecha sumarDías(int dias) {
	        LocalDate fecha = LocalDate.of(año, mes, dia).plusDays(dias);
	        return new fecha(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());
	    }
	 
	 public fecha restarDías(int dias) {
	        LocalDate fecha = LocalDate.of(año, mes, dia).minusDays(dias);
	        return new fecha(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());
	    }
	 
	 public int diferenciaEnDias(fecha otraFecha) {
	        LocalDate fecha1 = LocalDate.of(año(), mes(), dia());
	        LocalDate fecha2 = LocalDate.of(otraFecha.año(), otraFecha.mes(), otraFecha.dia());
	        long diferencia = java.time.temporal.ChronoUnit.DAYS.between(fecha1, fecha2);
	        return Math.abs((int) diferencia);
	 }
	 
	 public static boolean esAñoBisiesto(int año) {
		 return año % 4 == 0 && (año % 100 != 0 || año % 400 == 0);
	 }
	 
	 
	 public static fecha of(Integer año, Integer mes, Integer dia) {
	        return new fecha(año, mes, dia);
	    }
	 
	 public static fecha parse(String cadenaFecha) {
	        String[] partes = cadenaFecha.split("-");
	        if (partes.length != 3) {
	            throw new IllegalArgumentException("Formato de cadena de fecha incorrecto");
	        }
	        Integer año = Integer.parseInt(partes[0]);
	        Integer mes = Integer.parseInt(partes[1]);
	        Integer dia = Integer.parseInt(partes[2]);
	        return new fecha(año, mes, dia);
	    }
	 
	
	@Override
	public String toString() {
        String nombreDiaSemana = diaSemana();
        String nombreMes = nombreMes();
		return String.format("%s, %s de %s de %s", nombreDiaSemana, dia, nombreMes, año );
	}
}
