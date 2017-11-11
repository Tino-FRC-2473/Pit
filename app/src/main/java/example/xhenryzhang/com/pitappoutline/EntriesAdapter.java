package example.xhenryzhang.com.pitappoutline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Xhenry Zhang on 11/1/2017.
 */

public class EntriesAdapter extends BaseAdapter {

    LayoutInflater mInflater;

    String[] entries;
    String[] descriptions;

    public EntriesAdapter(Context c, String[] entryList, String[] descriptionList){
        entries = entryList;
        descriptions = descriptionList;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return entries.length;
    }

    @Override
    public Object getItem(int position) {
        return entries[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    // this method is called automatically when setAdapter() for the listView is called in the main class
    // don't worry about it :D
    public View getView(int position, View convertView, ViewGroup parent) {
        // the inflater "imports" the general layout of the list, as determined in the main_menu_details xml
        // this is stored in View object, which will be used in the menu layout.
        View v = mInflater.inflate(R.layout.main_menu_details, null);

        // assign names to the text display objects (for entry Entry and Description)
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView descriptionView = (TextView) v.findViewById(R.id.descriptionView);

        // position value automatically goes up by 1
        String header = entries[position];
        String description = descriptions[position];

        nameTextView.setText(header);
        descriptionView.setText(description);

        return v;
    }
}
