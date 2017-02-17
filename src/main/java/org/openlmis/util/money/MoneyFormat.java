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

import org.joda.money.Money;
import org.joda.money.format.MoneyAmountStyle;
import org.joda.money.format.MoneyFormatter;
import org.joda.money.format.MoneyFormatterBuilder;

import java.util.Locale;

public final class MoneyFormat {

  private MoneyFormat() {
    throw new UnsupportedOperationException();
  }

  /**
   * Prints formatted Money instance using default format and locale.
   *
   * @param money money to print
   * @return formatted money
   */
  public static String format(Money money) {
    return format(money, Locale.getDefault());
  }

  /**
   * Prints formatted Money instance using default format and given locale.
   *
   * @param money money to print
   * @param locale locale for formatting
   * @return formatted money
   */
  public static String format(Money money, Locale locale) {
    return format(money, locale, MoneyAmountStyle.of(locale));
  }

  /**
   * Prints Money instance using default format, given locale and money amount style.
   *
   * @param money money to print
   * @param locale locale for formatting
   * @param amountStyle style for printing money amount
   * @return formatted money
   */
  public static String format(Money money, Locale locale, MoneyAmountStyle amountStyle) {
    MoneyFormatterBuilder builder = new MoneyFormatterBuilder();

    builder.appendCurrencyCode();
    builder.appendLiteral(" ");
    builder.appendAmount(amountStyle);

    MoneyFormatter formatter = builder.toFormatter(locale);
    return formatter.print(money);
  }
}