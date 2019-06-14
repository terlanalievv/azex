package az.azex.util;

import az.azex.domain.Currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyUtility {
    public static final Currency AZN = new Currency(1, "AZN", 1);
    public static final Currency USD = new Currency(2, "USD", 2);
    public static final Currency EUR = new Currency(3, "EUR", 3);
    public static final Currency TRY = new Currency(4, "TRY", 4);

    public static Currency parse(String text) {
        Currency currency = USD;

        Map<String, Currency> currencyMap = new HashMap<>();
        currencyMap.put("TRY", TRY);
        currencyMap.put("try", TRY);
        currencyMap.put("tl", TRY);
        currencyMap.put("TL", TRY);
        currencyMap.put("usd", USD);
        currencyMap.put("USD", USD);
        currencyMap.put("$", USD);

        if(text != null && !text.isEmpty()) {
            currency = currencyMap.get(text);
        }

        return currency;
    }
}
