package entrega_tres;

public class testeo {
	
	public static void main(String[] args) {
		
		Banco banco = Banco.of();
		
		System.out.println("Vencimiento prestamos de cliente:");
		System.out.println(Questions.vencimientoDePrestamosDeCliente(banco, "62822051N"));
		System.out.println("Cliente con mas prestamos:");
		System.out.println(Questions.clienteConMasPrestamos(banco));
		System.out.println("Cantidad prestamos de empleados:");
		System.out.println(Questions.cantidadPrestamosPmpledado(banco, "86921364V"));
		System.out.println("Empleado mas longevo: ");
		System.out.println(Questions.empleadoMasLongevo(banco));
		System.out.println("Rango de intereses de prestamos:");
		System.out.println(Questions.rangoDeIntereseDePrestamos(banco));
		System.out.println("Numero de prestamos por mes año: ");
		System.out.println(Questions.numPrestamosPorMesAño(banco));
	
	}

}
