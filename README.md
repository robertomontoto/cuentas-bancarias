# Cuentas bancarias

## Contexto
> Una cuenta bancaria es un contrato financiero con una entidad bancaria en virtud del cual se registran el balance y los subsiguientes movimientos de dinero del cliente.  
[Wikipedia](http://es.wikipedia.org/wiki/Cuenta_bancaria)

En rigor nosotros vamos a ser menos estrictos, ya que por el momento no nos interesa computar los movimientos de dinero del cliente sino los totales instantáneos (es decir, cuánto dinero tiene el cliente a cada momento luego de realizar cada transacción).

### Tipos de cuentas
Vamos a establecer, para el contexto de este ejercicio, tres tipos de cuentas: la **Cuenta Sueldo**, la **Caja de Ahorros** y la **Cuenta Corriente**. Cada una cumple con ciertas reglas de negocio, las cuales se detallan a continuación.

#### Cuenta Sueldo
Es el tipo de cuenta más simple, ya que se rige por la premisa de que en tanto y en cuanto se tenga tanto o más dinero en cuenta del que se quiere extraer, la operación se debe efectuar correctamente.

#### Caja de Ahorros
Similar a la anterior, pero se pide que luego de la quinta extracción de dinero se cobre un costo adicional por extracción de $ 6

#### Cuenta Corriente
La más compleja de las cuentas, ésta permite establecer una cantidad de dinero a girar en descubierto. Es por ello que cada vez que se desee extraer dinero, no sólo se considera el que se posee, sino el límite adicional que el banco estará brindando.  
Por supuesto esto no es gratis, ya que el banco nos cobrará un 5% como comisión sobre todo el monto en descubierto consumido en la operación.  
Por ejemplo, si tuviéramos $ 100 en la cuenta, y quisiéramos retirar $ 200 (con un descubierto de $ 150), podremos hacerlo. Pasaremos a deberle al banco $ 105 en total: los $ 100 que nos cubrió, más el 5% adicional sobre el descubierto otorgado.

## Consigna

Se pide implementar una solución que permita utilizar los tres tipos de cuentas. Para ello deberás emplear los conceptos de _herencia_ y _encapsulamiento_.
Aquí un ejemplo de cómo debería funcionar:

    CuentaSueldo cuenta = new CuentaSueldo();
    cuenta.depositar(4000.0);
    
    Double saldo = cuenta.getSaldo();
    // saldo debe valer 4000.0
    
    cuenta.extraer(500.0);
    saldo = cuenta.getSaldo();
    // saldo debe valer 3500.0
    
    cuenta.extraer(4000.0);
    // la operación no debe poder realizarse
    // y debe lanzar una excepción (RuntimeException)

Y así con cada tipo de cuenta. Considerar los recargos establecidos por la consigna.

### Material proporcionado

Se otorga la implementación de la clase `AbstractCuenta`, la cual es abstracta y servirá para que modeles la herencia. La misma responde a los métodos `depositar(Double):void` y `extraer(Double):void`.  
Adicionalmente se proporcionan las clases `CuentaSueldo`, `CajaAhorros` y `CuentaCorriente`. Parte del trabajo implica que las completes para resolver el ejercicio según las reglas de negocio establecidas.

También se te proveerá un *test* (dentro de la clase `CuentaTests`) a modo de testigo, probando el caso proporcionado como ejemplo líneas más arriba. Idealmente deberías hacer crecer esas pruebas, o agregar las tuyas propias para asegurarte de que tu solución es correcta.

### Sugerencias

Una implementación directa puede llevar a la repetición indiscriminada de código. Esto, por supuesto, reduce la mantenibilidad y aumenta la probabilidad de deslizar errores en tu código.  
Es por ello que te proponemos que idees una estrategia para no repetir código (la herencia suele ayudar en ese sentido). De hecho, si encontrás que repetiste líneas de código, incluso una línea sólamente, es probable que estés plantando una bomba de inmantenibilidad a futuro.  
Te alentamos a que intentes revisar y reducir la copia de código al máximo.

## Criterios de evaluación

Este trabajo tendrá una nota normalizada en 10.0 puntos, los cuales se componen según el siguiente detalle:

<table>
 <thead>
 <tr>
  <th>Concepto</th>
  <th>Puntos totales</th>
  <th>Porcentaje sobre el total</th>
 </tr>
 </thead>
 <tr>
  <td>Funcionalidad</td>
  <td>8.0</td>
  <td>80 %</td>
 </tr>
 <tr>
  <td>Estilo</td>
  <td>2.0</td>
  <td>20 %</td>
 </tr>
 <tr>
  <td>Total</td>
  <td>10.0</td>
  <td>100 %</td>
 </tr>
</table>

Por lo tanto, se te evaluará tanto la funcionalidad como la correctitud de estilo (tabulación, espacios, nombres, etcétera).

## Consideraciones

1. Recordá no cambiar la firma de los métodos proporcionados por la cátedra.
2. Podés hacer **tantos tests como consideres necesarios**, pero los mismos no se utilizarán para evaluar tu código.
3. Recordá que podés enviar la tarea a corrección tantas veces como quieras, dentro del período de vigencia de la misma.
