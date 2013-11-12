package edu.tallerweb.cuentas;

/**
 * Similar a la CuentaSueldo, pero se pide que luego de la quinta extracci�n de
 * dinero se cobre un costo adicional por extracci�n de $ 6
 */
public class CajaAhorros extends AbstractCuenta {
	private double sumCajaAhorro = 0;
	private int contadorExtracciones = 0;

	/* constructor para la Caja de Ahorro sin par�metros */
	public CajaAhorros() {

	}

	/**
	 * No hay reglas adicionales para el dep�sito
	 *
	 * @param monto
	 *            a depositar
	 */
	@Override
	public void depositar(final Double monto) {
		if (monto < 0.0) {
			throw new RuntimeException(
					"El monto a depositar no puede ser menor a cero");
		}
		sumCajaAhorro += monto;
	}

	/**
	 * Se cobran $6 adicionales por cada extracci�n luego de la quinta.
	 *
	 * @param monto
	 *            a extraer
	 */
	@Override
	public void extraer(final Double monto) {
		if (monto > sumCajaAhorro) {
			throw new RuntimeException(
					"El saldo a extraer no debe ser mayor al disponible en su Caja de Ahorro");
		}
		sumCajaAhorro -= monto;
		contadorExtracciones++;
		if (contadorExtracciones > 5) {
			sumCajaAhorro -= 6;
		}
	}

	/**
	 * Permite saber el saldo de la cuenta
	 *
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		if (sumCajaAhorro < 0) {
			throw new RuntimeException(
					"El saldo de su caja de Ahorro no puede ser negativo");
		}
		return sumCajaAhorro;
	}

}
