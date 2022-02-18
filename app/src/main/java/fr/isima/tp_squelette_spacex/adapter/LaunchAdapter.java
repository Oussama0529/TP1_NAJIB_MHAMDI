package fr.isima.tp_squelette_spacex.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.ws.Launch;

public class LaunchAdapter extends ArrayAdapter<Launch> {
    private LayoutInflater inflater;

    public LaunchAdapter(Context context, int resource, @NonNull List<Launch> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            view = inflater.inflate(R.layout.launch_list_view, parent, false);
        }

        Launch currentLaunch = getItem(position);
        TextView missionName = view.findViewById(R.id.missionName);
        missionName.setText(currentLaunch.mission_name);
        TextView rocketName = view.findViewById(R.id.rocketName);
        rocketName.setText(currentLaunch.rocket.rocket_name);
        TextView launchDate = view.findViewById(R.id.launchDate);
        final DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");

        final long unixTime = currentLaunch.launch_date_unix;
        final String formattedDtm = Instant.ofEpochSecond(unixTime)
                .atZone(ZoneId.of("GMT-4"))
                .format(formatter);
        launchDate.setText(formattedDtm);

        return view;
    }
}
