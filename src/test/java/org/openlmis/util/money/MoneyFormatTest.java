package org.openlmis.util.money;

import static org.junit.Assert.assertEquals;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.money.format.MoneyAmountStyle;
import org.junit.Test;

import java.util.Locale;

public class MoneyFormatTest {

  @Test
  public void shouldFormatMoneyWithLocale() {
    // given
    Money money = Money.of(CurrencyUnit.CAD, 1000);

    // when
    String result = MoneyFormat.format(money, Locale.CANADA);

    // then
    assertEquals("CAD 1,000.00", result);
  }

  @Test
  public void shouldFormatMoneyWithLocaleAndMoneyAmountStyle() {
    // given
    Money money = Money.of(CurrencyUnit.EUR, 1000);
    MoneyAmountStyle style = MoneyAmountStyle.ASCII_DECIMAL_POINT_NO_GROUPING;

    // when
    String result = MoneyFormat.format(money, Locale.ENGLISH, style);

    // then
    assertEquals("EUR 1000.00", result);
  }

  @Test
  public void shouldFormatMoneyWithDefaultLocale() {
    // given
    Money money = Money.of(CurrencyUnit.AUD, 10);

    // when
    String result = MoneyFormat.format(money);

    // then
    assertEquals(MoneyFormat.format(money, Locale.getDefault()), result);
  }
}
