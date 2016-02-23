package com.fivido.sectionedexpandablegridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fivido.sectionedexpandablegridlayout.adapters.ItemClickListener;
import com.fivido.sectionedexpandablegridlayout.adapters.Section;
import com.fivido.sectionedexpandablegridlayout.adapters.SectionedExpandableLayoutHelper;
import com.fivido.sectionedexpandablegridlayout.models.Item;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements ItemClickListener {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting the recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        SectionedExpandableLayoutHelper sectionedExpandableLayoutHelper = new SectionedExpandableLayoutHelper(this,
                mRecyclerView, this, 3);

        //random data
        ArrayList<Item> arrayList = new ArrayList<>();
        arrayList.add(new Item("iPhone", 0));
        arrayList.add(new Item("iPad", 1));
        arrayList.add(new Item("iPod", 2));
        arrayList.add(new Item("iMac", 3));
        sectionedExpandableLayoutHelper.addSection("Apple Products", arrayList);
        arrayList = new ArrayList<>();
        arrayList.add(new Item("LG", 0));
        arrayList.add(new Item("Apple", 1));
        arrayList.add(new Item("Samsung", 2));
        arrayList.add(new Item("Motorola", 3));
        arrayList.add(new Item("Sony", 4));
        arrayList.add(new Item("Nokia", 5));
        sectionedExpandableLayoutHelper.addSection("Companies", arrayList);
        arrayList = new ArrayList<>();
        arrayList.add(new Item("Chocolate", 0));
        arrayList.add(new Item("Strawberry", 1));
        arrayList.add(new Item("Vanilla", 2));
        arrayList.add(new Item("Butterscotch", 3));
        arrayList.add(new Item("Grape", 4));
        sectionedExpandableLayoutHelper.addSection("Ice cream", arrayList);

        sectionedExpandableLayoutHelper.notifyDataSetChanged();

        //checking if adding single item works
        sectionedExpandableLayoutHelper.addItem("Ice cream", new Item("Tutti frutti",5));
        sectionedExpandableLayoutHelper.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void itemClicked(Item item) {
        Toast.makeText(this, "Item: " + item.getName() + " clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClicked(Section section) {
        Toast.makeText(this, "Section: " + section.getName() + " clicked", Toast.LENGTH_SHORT).show();
    }
}
