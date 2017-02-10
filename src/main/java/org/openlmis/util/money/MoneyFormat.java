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
   * Prints formatted Money instance using default formatter.
   * See: {@link #format(Money, MoneyFormatter)}
   *
   * @param money money to print
   * @return formatted money
   */
  public static String format(Money money) {
    MoneyFormatterBuilder builder = getDefaultBuilderWithCurrencyPrefix();
    builder.appendAmountLocalized();

    MoneyFormatter formatter = builder.toFormatter(Locale.getDefault());
    return format(money, formatter);
  }

  /**
   * Prints Money instance using given formatter.
   *
   * @param money money to print
   * @param formatter formatter for printing money
   * @return formatted money
   */
  public static String format(Money money, MoneyFormatter formatter) {
    return formatter.print(money);
  }

  /**
   * Prints Money instance using default formatter and custom money amount style.
   *
   * @param money money to print
   * @param amountStyle style for printing money amount
   * @return formatted money
   */
  public static String format(Money money, MoneyAmountStyle amountStyle) {
    MoneyFormatterBuilder builder = getDefaultBuilderWithCurrencyPrefix();
    builder.appendAmount(amountStyle);

    MoneyFormatter formatter = builder.toFormatter(Locale.getDefault());
    return format(money, formatter);
  }

  private static MoneyFormatterBuilder getDefaultBuilderWithCurrencyPrefix() {
    MoneyFormatterBuilder builder = new MoneyFormatterBuilder();
    builder.appendCurrencyCode();
    builder.appendLiteral(" ");

    return builder;
  }
}