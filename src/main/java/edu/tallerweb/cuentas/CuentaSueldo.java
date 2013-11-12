package edu.tallerweb.cuentas;

/**
 * Es el tipo de cuenta más simple, ya que se rige por la premisa de que en
 * tanto y en cuanto se tenga tanto o más dinero en cuenta del que se quiere
 * extraer, la operación se debe efectuar correctamente.
 */
public class CuentaSueldo extends AbstractCuenta {
	private double sumCuentaSueldo = 0.0;

	/* Constructor para la Cuenta Sueldo */
	public CuentaSueldo() {

	}

	/**
	 * No hay reglas adicionales para el depósito
	 *
	 * @param monto
	 *            a depositar
	 */

	@Override
	public void depositar(final Double monto) {
		if (monto < 0) {
			throw new RuntimeException(
					"El monto a depositar no puede ser menor a 0");
		}
		sumCuentaSueldo += monto;
	}

	/**
	 * No hay reglas adicionales para la extracción
	 *
	 * @param monto
	 *            a extraer
	 */

	@Override
	public void extraer(final Double monto) {
		if (monto > sumCuentaSueldo) {
			throw new RuntimeException(
					"El saldo a extrear de su cuenta no debe ser mayor a lo que tiene depositado");
		}
		sumCuentaSueldo -= monto;
	}

	/**
	 * Permite saber el saldo de la cuenta
	 *
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		if (sumCuentaSueldo < 0) {
			throw new RuntimeException(
					"El saldo de su cuenta Sueldo no puede ser negativo");
		}
		return sumCuentaSueldo;

	}
}