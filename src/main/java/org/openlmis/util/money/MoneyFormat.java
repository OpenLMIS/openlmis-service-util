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