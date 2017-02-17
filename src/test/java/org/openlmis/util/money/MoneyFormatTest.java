/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2017 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Affero General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Affero General Public License for more details. You should have received a copy of
 * the GNU Affero General Public License along with this program. If not, see
 * http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org. 
 */

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
    Locale baseLocale = Locale.getDefault();
    try {
      // given
      Locale.setDefault(Locale.ENGLISH);
      Money money = Money.of(CurrencyUnit.AUD, 1000);

      // when
      String result = MoneyFormat.format(money);

      // then
      assertEquals("AUD 1,000.00", result);
    } finally {
      Locale.setDefault(baseLocale);
    }
  }
}
