package name.sotirova.marketapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    //1- Adapter View
    RecyclerView recyclerView;
    //2- Data source
    List<Item> itemList;
    //3- Adapter
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();
        Item item1 = new Item(R.drawable.fruit, "Fruit", "Fresh fruits from the garden");
        Item item2 = new Item(R.drawable.vegetables, "Vegetables", "Delicious vegetables");
        Item item3 = new Item(R.drawable.bread, "Bread", "Bread, Wheat and Beans");
        Item item4 = new Item(R.drawable.beverage, "Beverage", "Juice, Tea, Coffee and Soda");
        Item item5 = new Item(R.drawable.milk, "Milk", "Milk, Shakes and Yoghurt");
        Item item6 = new Item(R.drawable.popcorn, "Snacks", "Popcorn, Donuts and Drinks");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setClickListener(this);
    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You chose: " + itemList.get(pos).getItemName(),
                Toast.LENGTH_SHORT).show();
    }
}