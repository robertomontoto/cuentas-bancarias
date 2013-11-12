package edu.tallerweb.cuentas;

import org.junit.Assert;
import org.junit.Test;

public class CuentaTests {

	@Test
	public void queVerifiqueCuentaSueldo() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacía, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(500.0);

		Assert.assertEquals(
				"al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
				3500.0, cuenta.getSaldo(), 0.0);
	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueExceptionenCuentaSueldo() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(3500.0);
		cuenta.extraer(4000.0);
	}

	@Test
	public void queVerifiqueCajaAhorros() {
		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(5000.00);
		Assert.assertEquals(
				"al depositar $ 5000.0 en una caja de ahorros vacía, tiene $ 5000.0",
				5000.0, cuenta.getSaldo(), 0.0);

		cuenta.depositar(1000.00);
		cuenta.extraer(500.00);
		cuenta.extraer(500.00);
		cuenta.extraer(500.00);
		cuenta.extraer(500.00);
		cuenta.extraer(500.00);
		cuenta.extraer(500.00);
		Assert.assertEquals(
				"al extraer $3000  de una caja de Ahorro con $ 6000.0 se obtienen $ 2994 por que se empieza a cobrar la comision de $6 superando as cinco extracciones",
				2994.00, cuenta.getSaldo(), 0.0);

	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueExceptionenCajaAhorros() {
		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(6000.0);
		cuenta.extraer(7000.0);
	}

	@Test
	public void queverifiqueCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(150.00);
		cuenta.depositar(100.00);
		cuenta.extraer(200.00);
		Assert.assertEquals(
				"al extraer $200.00  de una Cuenta Corriente con $ 100.00 se obtienen $0 por que me quede sin monto",
				0.0, cuenta.getSaldo(), 0.0);

		Assert.assertEquals(
				"al extraer $200.00  de una Cuenta Corriente con $ 100.00 se obtienen $105 en descubierto los $200"
						+ "que me presto el banco más 5% del descubierto",
				105.00, cuenta.getDescubierto(), 0.0);

	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueExceptionenCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(200.00);
		cuenta.depositar(100.00);
		cuenta.extraer(900.0);
	}

}
