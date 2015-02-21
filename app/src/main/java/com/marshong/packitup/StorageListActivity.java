package com.marshong.packitup;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class StorageListActivity extends ActionBarActivity {

    public final static String TAG = StorageListFragment.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_list);

        Log.d(TAG, "onCreate StorageListActivity");

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.storage_list_activity_container);

        if (null == fragment) {
            fragment = new StorageListFragment();
            fm.beginTransaction().add(R.id.storage_list_activity_container, fragment).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_storage, menu);
        Log.d(TAG, "onCreateOptionsMenu StorageListActivity");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected StorageListActivity " + item.toString());

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.addStorageItem) {
            Toast.makeText(StorageListActivity.this, "Selected to Add a Container", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(StorageListActivity.this, AddContainerActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(TAG, "placeHolderFragment, inflating fragment");
            View rootView = inflater.inflate(R.layout.fragment_storage_list, container, false);
            return rootView;
        }
    }
}
