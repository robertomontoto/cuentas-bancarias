package edu.tallerweb.cuentas;

/**
 * La mas compleja de las cuentas, Esta permite establecer una cantidad de
 * dinero a girar en descubierto. Es por ello que cada vez que se desee extraer
 * dinero, no solo se considera el que se posee, sino el limite adicional que el
 * banco estara brindando.
 *
 * Por supuesto esto no es gratis, ya que el banco nos cobrara un 5% como
 * comision sobre todo el monto en descubierto consumido en la operacion.
 *
 * Por ejemplo, si tuvieramos $ 100 en la cuenta, y quisieramos retirar $ 200
 * (con un descubierto de $ 150), podremos hacerlo. Pasaremos a deberle al banco
 * $ 105 en total: los $ 100 que nos cubrio, mas el 5% adicional sobre el
 * descubierto otorgado.
 */
public class CuentaCorriente extends AbstractCuenta {

	private double sumCuentaCorriente = 0.0; // lo que tengo disponible en mi
												// cuenta corriente
	private final double descubiertoTotal; // lo que el banco nos permte como
											// descubierto total
	private double sumDescubierto = 0.0; // lo que de debemos al banco

	/**
	 * Toda cuenta corriente se inicia con un limite total para el descubierto.
	 *
	 * @param descubiertoTotal
	 */
	public CuentaCorriente(final Double descubiertoTotal) {
		this.descubiertoTotal = descubiertoTotal;
	}

	/**
	 * Todo deposito deberá cubrir primero el descubierto, si lo hubiera, y
	 * luego contar para el saldo de la cuenta.
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
		if (sumDescubierto == 0.0) {
			sumCuentaCorriente += monto;
		}
		if (sumDescubierto > 0) {
			sumDescubierto -= monto;
		} else {
			sumCuentaCorriente += sumDescubierto * (-1);
			sumDescubierto = 0.0;
		}
	}

	/**
	 * Se cobrará el 5% de comisión sobre el monto girado en descubierto. Por
	 * supuesto, no puede extraerse más que el total de la cuenta, más el
	 * descubierto (comisión incluida)
	 *
	 * @param monto
	 *            a extraer
	 */
	@Override
	public void extraer(final Double monto) {
		if (sumCuentaCorriente + (descubiertoTotal + (descubiertoTotal * 0.05)) < monto) {
			throw new RuntimeException(
					"No se puede extraer dinero mayor al disponible en su cuenta junto con el descubierto ");
		}
		if (monto > sumCuentaCorriente) {
			/* Lo que le debo al banco */
			sumDescubierto = (monto - sumCuentaCorriente)
					+ (monto - sumCuentaCorriente) * 0.05;
			sumCuentaCorriente = 0.0;
		}
		if (sumCuentaCorriente > monto) {
			sumCuentaCorriente -= monto;
		}
	}

	/**
	 * Permite saber el saldo de la cuenta
	 *
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		if (sumCuentaCorriente < 0) {
			throw new RuntimeException(
					"El saldo de su Cuenta Corrriente no puede ser negativo");
		}
		return sumCuentaCorriente;
	}

	/**
	 * Permite saber el saldo en descubierto
	 *
	 * @return el descubierto de la cuenta
	 */
	public Double getDescubierto() {
		return sumDescubierto;
	}

}
