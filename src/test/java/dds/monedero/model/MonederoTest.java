package dds.monedero.model;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonederoTest {
  private Cuenta cuenta;

  @BeforeEach
  void init() {
    cuenta = new Cuenta();
  }

  @Test
  void Poner() {
    cuenta.poner(1500);
    assertEquals(cuenta.getSaldo(), 1500);
  }

  @Test
  void TresDepositos() {
    cuenta.poner(1500);
    cuenta.poner(456);
    cuenta.poner(1900);
    assertEquals(cuenta.cantidadDeDepositos(), 3);
  }

  @Test
  void SePuedeSaberElMontoExtraidoEnCiertoDia(){
    cuenta.setSaldo(2000);
    cuenta.sacar(500);
    assertEquals(cuenta.getMontoExtraidoA(LocalDate.now()), 500);
  }

  @Test
  void ExtraerCiertaCantidadReduceElSaldo(){
    cuenta.setSaldo(4000);
    cuenta.sacar(700);
    assertEquals(cuenta.getSaldo(), 3300);
  }

}