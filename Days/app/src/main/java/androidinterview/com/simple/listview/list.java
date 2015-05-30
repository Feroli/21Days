package androidinterview.com.simple.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.feroli.days.R;

public class list extends ListActivity {

    String[] city = {
            "Bangalore",
            "Chennai",
            "Mumbai",
            "Pune",
            "Delhi",
            "Jabalpur",
            "Indore",
            "Ranchi",
            "Hyderabad",
            "Ahmedabad",
            "Kolkata"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Listview adapter
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,city));
    }
    public void onListItemClick(ListView parent, View v,
                                int position, long id) {
        Toast.makeText(this, "You have selected city : " + city[position],
                Toast.LENGTH_LONG).show();
    }
}