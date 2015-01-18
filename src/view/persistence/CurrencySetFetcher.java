package view.persistence;

import model.Currency;
import model.CurrencySet;

public class CurrencySetFetcher implements CurrencySetLoader {

    @Override
    public CurrencySet load() {
        CurrencySet set = new CurrencySet();
        set.add(new Currency("EUR", "Euro", "€"));
        set.add(new Currency("USD", "American Dolar", "$"));
        set.add(new Currency("HKD", "Hong Kong Dolar", "$"));
        return set;
    }
    
}
