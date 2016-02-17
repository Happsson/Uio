package nu.geeks.uio.Screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import nu.geeks.uio.Handlers.DataHandler;
import nu.geeks.uio.Data.Project;
import nu.geeks.uio.R;

public class MainActivity extends Activity {

    DataHandler dataHandler;
    ArrayList<Project> projects;
    TextView currentProjects;
    ListView projectList;
    Button addButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataHandler = new DataHandler();
        projects = dataHandler.getProjects();

        setUpView();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setUpView(){
        currentProjects = (TextView) findViewById(R.id.tvCurrentProjects);
        projectList = (ListView) findViewById(R.id.lvProjectList);
        addButton = (Button) findViewById(R.id.buttonAdd);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newRecipeButtonPressed();
            }
        });

    }

    private void newRecipeButtonPressed() {
        Intent intent = new Intent(this, NewProjectScreen.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
