package nu.geeks.uio;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

/**
 * Created by Hannes on 2016-02-17.
 */
public class CustomListView extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] listText;
    private final int[] imageId;


    public CustomListView(Activity context, String[] listtext, int[] imageId){
        super(context, R.layout.custom_list, listtext);
        this.context = context;
        this.listText = listtext;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_list, null, true);

        TextView listItem = (TextView) rowView.findViewById(R.id.customListText);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.customListImg);

        listItem.setText(listText[position]);
        imageView.setImageResource(imageId[position]);

        return super.getView(position, convertView, parent);
    }
}
