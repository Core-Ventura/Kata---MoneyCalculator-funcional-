package view.ui;

import model.Currency;
import model.ExchangeRateSet;

public class Frame extends javax.swing.JFrame {

    private final Currency[] currencies;
    private final ExchangeRateSet rates;

    public Frame(Currency[] currencies, ExchangeRateSet rates) {        
        this.currencies = currencies;
        this.rates = rates;
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        panelContents = new javax.swing.JPanel();
        panelSource = new javax.swing.JPanel();
        txtSource = new javax.swing.JTextField();
        comboSource = new javax.swing.JComboBox();
        label1 = new java.awt.Label();
        panelOutcome = new javax.swing.JPanel();
        txtOutcome = new javax.swing.JTextField();
        comboOutcome = new javax.swing.JComboBox();
        label2 = new java.awt.Label();
        panelEquals = new javax.swing.JPanel();
        butCalculate = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Money Calculator");
        setBackground(new java.awt.Color(102, 204, 255));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        panelContents.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelContents.setLayout(new javax.swing.BoxLayout(panelContents, javax.swing.BoxLayout.Y_AXIS));

        panelSource.setLayout(new java.awt.GridBagLayout());

        txtSource.setColumns(15);
        panelSource.add(txtSource, new java.awt.GridBagConstraints());

        comboSource.setModel(new CurrencyComboModel(currencies));
        comboSource.setSelectedIndex(0);
        panelSource.add(comboSource, new java.awt.GridBagConstraints());

        label1.setText("From");
        panelSource.add(label1, new java.awt.GridBagConstraints());

        panelContents.add(panelSource);

        panelOutcome.setLayout(new java.awt.GridBagLayout());

        txtOutcome.setEditable(false);
        txtOutcome.setColumns(15);
        panelOutcome.add(txtOutcome, new java.awt.GridBagConstraints());

        comboOutcome.setModel(new CurrencyComboModel(currencies));
        comboOutcome.setSelectedIndex(0);
        panelOutcome.add(comboOutcome, new java.awt.GridBagConstraints());

        label2.setText("To    ");
        panelOutcome.add(label2, new java.awt.GridBagConstraints());
        label2.getAccessibleContext().setAccessibleName("To     ");

        panelContents.add(panelOutcome);

        butCalculate.setText("CALCULATE");
        butCalculate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butCalculateMouseClicked(evt);
            }
        });
        panelEquals.add(butCalculate);

        panelContents.add(panelEquals);

        getContentPane().add(panelContents);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butCalculateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butCalculateMouseClicked
        if (!"".equals(txtSource.getText())) {
            convertToSecondAmount();
        }
    }//GEN-LAST:event_butCalculateMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCalculate;
    private javax.swing.JComboBox comboOutcome;
    private javax.swing.JComboBox comboSource;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JPanel panelContents;
    private javax.swing.JPanel panelEquals;
    private javax.swing.JPanel panelOutcome;
    private javax.swing.JPanel panelSource;
    private javax.swing.JTextField txtOutcome;
    private javax.swing.JTextField txtSource;
    // End of variables declaration//GEN-END:variables

    private void convertToSecondAmount() {
        double firstAmount = Double.parseDouble(txtSource.getText());
        double rate = rates.getRate(currencies[comboSource.getSelectedIndex()],
                currencies[comboOutcome.getSelectedIndex()]);
        txtOutcome.setText(String.valueOf(firstAmount * rate));
    }
}
