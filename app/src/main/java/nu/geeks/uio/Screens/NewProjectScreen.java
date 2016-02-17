package nu.geeks.uio.Screens;

import android.app.Activity;
import android.os.Bundle;

import nu.geeks.uio.Handlers.DataHandler;
import nu.geeks.uio.R;

/**
 * Created by Hannes on 2016-02-17.
 */
public class NewProjectScreen extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_project_screen);
    }
}
