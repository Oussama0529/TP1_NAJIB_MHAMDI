package fr.isima.tp_squelette_spacex.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.adapter.LaunchAdapter;
import fr.isima.tp_squelette_spacex.ws.Launch;
import fr.isima.tp_squelette_spacex.ws.WsManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaunchesActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener, Callback<List<Launch>> {

    private ProgressBar progressBar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launches);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        loadLaunches();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Launch currentItem = (Launch) adapterView.getItemAtPosition(position);

        String articleLink = currentItem.links.article_link;
        if (articleLink.equals("")) {
            Context context = getApplicationContext();

            CharSequence text = "No article Link!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            Intent intent;
            if (articleLink.startsWith("https")) {
                intent = new Intent(this, LaunchActivity.class);
                intent.putExtra("myLaunch", currentItem);

            } else {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(articleLink));
            }
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {

    }

    public void loadLaunches() {
        progressBar.setVisibility(View.VISIBLE);
        WsManager.getSpaceXService().listLaunches().enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
        progressBar.setVisibility(View.INVISIBLE);
        ListAdapter adapter = new LaunchAdapter(this, R.layout.launch_list_view, response.body());
        listView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<List<Launch>> call, Throwable t) {
        progressBar.setVisibility(View.INVISIBLE);
        Context context = getApplicationContext();

        CharSequence text = "An error has occurred, please retry\n"+ t.getMessage();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}