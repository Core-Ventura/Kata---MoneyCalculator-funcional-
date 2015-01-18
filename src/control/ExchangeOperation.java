package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.CurrencySet;
import model.ExchangeRateSet;
import view.persistence.CurrencySetFetcher;
import view.persistence.ExchangeRateLoader;
import view.ui.Frame;

public class ExchangeOperation {

    private Frame frame;
    private final CurrencySet currencySet;
    private final ExchangeRateSet rateSet;

    public ExchangeOperation() {
        currencySet = new CurrencySetFetcher().load();
        rateSet = new ExchangeRateLoader().load(currencySet);
    }

    public void execute() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            frame = new Frame(currencySet.toArray(), rateSet);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ExchangeOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
