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
	public void queVerifiqueLaConsignaException() {
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
	}

}
