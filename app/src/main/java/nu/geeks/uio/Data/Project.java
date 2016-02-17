package nu.geeks.uio.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Project holds a current project. That is the current users in the project, and the current
 * debts within the project.
 *
 * Implements Parcelable, a Android thing, makes it possible to pass this object between activities.
 *
 *
 * Created by Hannes on 2016-02-17.
 */
public class Project implements Parcelable {

    public String projectName;
    public String projectPassword;
    public ArrayList<String> people;
    public ArrayList<Transaction> transactions;
    private ArrayList<String> transactionStrings; //Had to do a funny solution here..
    public String projectIcon;

    public Project(String projectName, String projectPassword, String projectIcon){
        this.projectName = projectName;
        this.projectPassword = projectPassword;
        this.projectIcon = projectIcon;
        people = new ArrayList<>();
        transactions = new ArrayList<>();
        transactionStrings = new ArrayList<>();
    }


    protected Project(Parcel in) {
        projectName = in.readString();
        projectPassword = in.readString();
        people = in.createStringArrayList();
        transactionStrings = in.createStringArrayList();
        projectIcon = in.readString();
        createTransactionsFromStrings();
    }

    private void createTransactionsFromStrings(){
        transactions.clear();
        for(String transactionString : transactionStrings){
            transactions.add(new Transaction(transactionString));
        }
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(projectName);
        dest.writeString(projectPassword);
        dest.writeStringList(people);
        createTransactionStrings();
        dest.writeStringList(transactionStrings);
        dest.writeString(projectIcon);
    }

    private void createTransactionStrings(){
        transactionStrings.clear();
        for(Transaction t : transactions){
            transactionStrings.add(t.getParcelableString());
        }
    }
}
