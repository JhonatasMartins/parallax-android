package br.com.jhonatasmartins.parallax;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    CollapsingToolbarLayout collapsing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collapsing = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new Teste());
        recycler.setHasFixedSize(true);

        collapsing.setTitle("MV Agusta Brutale");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class Teste extends RecyclerView.Adapter<Teste.ViewHolder>{

        @Override
        public int getItemCount() {
            return 3;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            TextView view = (TextView) getLayoutInflater().inflate(android.R.layout.simple_list_item_1, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(Teste.ViewHolder viewHolder, int i) {
            viewHolder.view.setText("Kabuuuum "+i);
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            TextView view;

            public ViewHolder(TextView view){
                super(view);
                this.view = view;
            }

        }
    }
}
