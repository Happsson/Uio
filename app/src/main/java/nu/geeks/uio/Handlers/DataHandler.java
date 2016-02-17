package nu.geeks.uio.Handlers;

import java.util.ArrayList;

import nu.geeks.uio.Data.Project;

/**
 * The data-handler is meant to keep track of all the data in the app.
 *
 * Created by Hannes on 2016-02-17.
 */
public class DataHandler{


    private ArrayList<Project> projects;
    private BackendCommunicator backendCommunicator;

    public DataHandler(){
        backendCommunicator = new BackendCommunicator();
        projects = backendCommunicator.getProjects();
    }

    public ArrayList<Project> getProjects(){return projects;}
}
