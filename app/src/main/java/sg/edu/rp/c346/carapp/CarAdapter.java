package sg.edu.rp.c346.carapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends ArrayAdapter<Car> {
    private ArrayList<Car> cars;

    private Context context;
    private TextView tvID;
    private TextView tvBrand;
    private TextView tvLitre;

    public CarAdapter(Context context, int resource, ArrayList<Car> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        cars = objects;

        // Store Context object as we would need to use it later
        this.context = context;
    }



    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvID =         rowView.findViewById(R.id.tvID);
        // Get the ImageView object
        tvBrand =             rowView.findViewById(R.id.tvbrand);

        tvLitre = rowView.findViewById(R.id.tvlitre);



        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Car    currenttasks = cars.get(position);
        // Set the TextView to show the food

        String litre = Double.toString(currenttasks.getLitre());
        String id = Integer.toString(currenttasks.getId());
        tvID.setText(id);
        tvBrand.setText(currenttasks.getBrand());
        tvLitre.setText(litre);


        return rowView;
    }
}
