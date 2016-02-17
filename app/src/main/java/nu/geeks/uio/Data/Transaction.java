package nu.geeks.uio.Data;

import java.util.ArrayList;

/**
 * A transaction.
 *
 * Created by Hannes on 2016-02-17.
 */
public class Transaction {

    private float amount;
    private String currency;
    private String boughtBy;
    private String transactionType;

    /**
     * @param amount  cost of transaction
     * @param currency
     * @param boughtBy
     * @param transactionType what was bought?
     */
    public Transaction(float amount, String currency, String boughtBy, String transactionType){
        this.amount = amount;
        this.boughtBy = boughtBy;
        this.currency = currency;
        this.transactionType = transactionType;
    }

    /**
     * Create transaction from parcelable string.
     *
     * @param transactionString
     */
    public Transaction(String transactionString){
        parceString(transactionString);
    }

    private void parceString(String transactionString) {

        char[] chars = transactionString.toCharArray();
        int index = 0;
        String tAmount = "";
        String tCurrency = "";
        String tBoughtBy = "";
        String tTransactType = "";

        while(chars[index] != '¤') tAmount += chars[index++];
        index++;
        while(chars[index] != '¤') tCurrency += chars[index++];
        index++;
        while(chars[index] != '¤') tBoughtBy += chars[index++];
        index++;
        while(chars[index] != '¤') tTransactType += chars[index++];
        amount = Float.parseFloat(tAmount);
        currency = tCurrency;
        boughtBy = tBoughtBy;
        transactionString = tTransactType;
    }

    public String getParcelableString(){
        return amount+"¤"+currency+"¤"+boughtBy+"¤"+transactionType+"¤";
    }

    public float getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getBoughtBy() {
        return boughtBy;
    }

    public String getTransactionType() {
        return transactionType;
    }
}
