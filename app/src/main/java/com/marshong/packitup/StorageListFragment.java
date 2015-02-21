package com.marshong.packitup;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.marshong.packitup.stuff.Container;
import com.marshong.packitup.stuff.Globals;
import com.marshong.packitup.stuff.Item;

import java.util.ArrayList;

/**
 * Created by martin on 2/19/2015.
 */
public class StorageListFragment extends Fragment {

    public final static String TAG = StorageListFragment.class.getSimpleName();

    public StorageListFragment() {
        //required empty constructor
        //Log.d(TAG, "constructor");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView StorageListFragment");

        //inflate the view first so you can use the view objects.
        View view = inflater.inflate(R.layout.fragment_storage_list, container, false);

        ArrayList<Container> containers = populateBoxes();
        final ListView listView = (ListView) view.findViewById(R.id.listViewStorageList);
        final StorageListAdapter adapter = new StorageListAdapter(getActivity(), R.layout.storage_list_item, containers);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Container selContainer = (Container) parent.getItemAtPosition(position);
                Toast.makeText(getActivity(), "clicked on " + selContainer.getName(), Toast.LENGTH_SHORT).show();
            }
        });


        if (null != listView) {
            listView.setAdapter(adapter);
        }

        return view;
    }

    private ArrayList<Container> populateBoxes() {
        Log.d(TAG, "populating boxes");
        ArrayList<Container> containers = new ArrayList<>();


        Container container = new Container("box1", Globals.Rooms.Bathroom);
        container.addItem(new Item("medicine"));
        container.addItem(new Item("soap"));
        containers.add(container);

        container = new Container("box2", Globals.Rooms.Bedroom);
        container.addItem(new Item("guns"));
        container.addItem(new Item("blurays"));
        container.addItem(new Item("humidifier"));
        containers.add(container);

        container = new Container("box3", Globals.Rooms.Kitchen);
        container.addItem(new Item("pots"));
        container.addItem(new Item("cups"));
        containers.add(container);

        container = new Container("box4", Globals.Rooms.Garage);
        container.addItem(new Item("tools"));
        container.addItem(new Item("saw"));
        container.addItem(new Item("car equipment"));
        containers.add(container);

        container = new Container("box5", Globals.Rooms.Outside);
        container.addItem(new Item("tools"));
        container.addItem(new Item("pavers"));
        containers.add(container);

        container = new Container("box6", Globals.Rooms.Bedroom);
        container.addItem(new Item("clothes"));
        container.addItem(new Item("sweaters"));
        container.addItem(new Item("costumes"));
        containers.add(container);

        container = new Container("box7", Globals.Rooms.Bathroom);
        container.addItem(new Item("hats"));
        container.addItem(new Item("presents"));
        container.addItem(new Item("books"));
        container.addItem(new Item("computer"));
        container.addItem(new Item("piano"));
        containers.add(container);

        container = new Container("box8", Globals.Rooms.Bedroom);
        container.addItem(new Item("baby clothes"));
        container.addItem(new Item("baby socks"));
        containers.add(container);

        container = new Container("box9", Globals.Rooms.Bedroom);
        container.addItem(new Item("diapers"));
        container.addItem(new Item("baby medicine"));
        containers.add(container);

        container = new Container("box10", Globals.Rooms.Bedroom);
        container.addItem(new Item("toys"));
        container.addItem(new Item("legos"));
        containers.add(container);

        container = new Container("box11", Globals.Rooms.Bathroom);
        container.addItem(new Item("glasses"));
        container.addItem(new Item("tables"));
        containers.add(container);

        container = new Container("box12", Globals.Rooms.Garage);
        container.addItem(new Item("chemicals"));
        container.addItem(new Item("car stuff"));
        containers.add(container);

        container = new Container("box13", Globals.Rooms.Garage);
        container.addItem(new Item("fishing stuff"));
        container.addItem(new Item("car stuff"));
        containers.add(container);

        container = new Container("box14", Globals.Rooms.Bedroom);
        container.addItem(new Item("books"));
        container.addItem(new Item("music"));
        containers.add(container);

        return containers;
    }


/*    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate, creating test boxes");
        ArrayList<Box> boxes = populateBoxes();
        ListView listView = (ListView) findViewById(R.id.listViewStorageList);
        StorageListAdapter adapter = new StorageListAdapter(getActivity(), R.layout.storage_list_item, boxes);
        listView.setAdapter(adapter);
    }*/

    private class StorageListAdapter extends ArrayAdapter<Container> {
        private ArrayList<Container> containers;

        private StorageListAdapter(Context context, int resource, ArrayList<Container> containers) {
            super(context, resource, containers);
            this.containers = containers;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;

            if (null == view) {
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.storage_list_item, null);
            }

            Container container = containers.get(position);

            if (null != container) {
                TextView textViewRoom = (TextView) view.findViewById(R.id.textViewRoomName);
                TextView textViewBox = (TextView) view.findViewById(R.id.textViewBoxName);
                TextView textViewItem = (TextView) view.findViewById(R.id.textViewItemName);

                textViewBox.setText(container.getName());
                textViewItem.setText(container.getAllItemNames());
                textViewRoom.setText(container.getRoom().toString());
            }
            return view;
        }
    }
}
