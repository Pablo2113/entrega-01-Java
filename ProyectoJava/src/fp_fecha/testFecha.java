package fp_fecha;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import fp_fecha.fecha;


public class testFecha {
	public static void main(String[] args) {
		fecha fechaNueva = new fecha(2024, 3, 15);
		fecha otraFecha = new fecha(2024, 2, 10);
		
		System.out.println(fechaNueva.nombreMes());
		System.out.println(fechaNueva.diaSemana());
		System.out.println(fechaNueva.sumarDías(40));
		System.out.println(fechaNueva.restarDías(19));
		System.out.println(fechaNueva.diferenciaEnDias(otraFecha));
		
		
		//Propuesta Test Fecha(DANIEL MATEOS)
		
		// Crear una fecha
        Integer año = 2024;
        Integer mes = 3;
        Integer dia = 8;
 
        // Crear una instancia de Fecha
        fecha Fecha = fecha.of(año, mes, dia);
 
        // Crear una instancia de LocalDate
        LocalDate localDate = LocalDate.of(año, mes, dia);
 
        // Comprobar que los metodos comunes coinciden
        System.out.println("Fecha: " + Fecha);
        System.out.println("LocalDate: " + localDate);
 
        System.out.println("\nFecha.esAnioBisiesto(): " + fecha.esAñoBisiesto(Fecha.año()));
        System.out.println("LocalDate.isLeapYear(): " + localDate.isLeapYear());
 
        System.out.println("\nFecha.diasEnMes(): " + fecha.diaEnMes(Fecha.año(), Fecha.mes()));
        System.out.println("LocalDate.lengthOfMonth(): " + localDate.lengthOfMonth());
 
        fecha fechaSumada = Fecha.sumarDías(10);
        LocalDate localDateSumada = localDate.plusDays(10);
 
        System.out.println("\nFecha.sumardias(10): " + fechaSumada);
        System.out.println("LocalDate.plusDays(10): " + localDateSumada);
 
        fecha fechaRestada = Fecha.restarDías(10);
        LocalDate localDateRestada = localDate.minusDays(10);
 
        System.out.println("\nFecha.restarDias(10): " + fechaRestada);
        System.out.println("LocalDate.minusDays(10): " + localDateRestada);
 
        Integer diferenciaEnDias = Fecha.diferenciaEnDias(fechaSumada);
        long diferenciaEnDiasLocalDate = ChronoUnit.DAYS.between(localDate, localDateSumada);
 
        System.out.println("\nFecha.diferenciaEnDias(fechaSumada): " + diferenciaEnDias);
        System.out.println("ChronoUnit.DAYS.between(localDate, localDateSumada): " + diferenciaEnDiasLocalDate);

	
	}
}
