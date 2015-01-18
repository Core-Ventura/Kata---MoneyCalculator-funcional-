package view.persistence;

import model.CurrencySet;
import model.ExchangeRate;
import model.ExchangeRateSet;

public class ExchangeRateLoader {

    public ExchangeRateSet loader(CurrencySet c) {
        ExchangeRateSet set = new ExchangeRateSet();
        set.add(new ExchangeRate(c.get(0), c.get(0), 1));
        for (int i = 1; i < c.size(); i++) {
            set.add(new ExchangeRate(c.get(0), c.get(i), randomNumber(0, 2)));
        }

        return set;
    }

    public ExchangeRateSet load(CurrencySet c) {
        ExchangeRateSet set = new ExchangeRateSet();
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < c.size(); j++) {
                if (c.get(i).equals(c.get(j))) {
                    set.add(new ExchangeRate(c.get(i), c.get(i), 1));
                } else {
                    set.add(new ExchangeRate(c.get(j), c.get(i), randomNumber(0, 2)));
                }
            }
        }

        return set;
    }

    private float randomNumber(float max, float min) {
        return (float) (Math.random() < 0.5 ? ((1 - Math.random()) * (max - min) + min) : (Math.random() * (max - min) + min));
    }

}
