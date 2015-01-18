package view.ui;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Currency;

public class CurrencyComboModel extends AbstractListModel implements ComboBoxModel {

    String[] currenciesString;
    String selection = null;

    public CurrencyComboModel(Currency[] currencies) {
        currenciesString = new String[currencies.length];
        
        for (int i = 0; i < currencies.length; i++) {
            currenciesString[i] = currencies[i].getName() + " - (" + currencies[i].getCode() + ")";
        }
    }

    @Override
    public int getSize() {
        return currenciesString.length;
    }

    @Override
    public Object getElementAt(int index) {
        return currenciesString[index];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

}
