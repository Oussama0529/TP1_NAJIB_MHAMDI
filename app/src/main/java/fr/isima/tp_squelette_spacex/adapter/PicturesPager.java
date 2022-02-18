package fr.isima.tp_squelette_spacex.adapter;
/*
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.viewpager.widget.PagerAdapter;
import fr.isima.spacex.R;
*/

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// Supprimez la classe vide et décommentez la vraie classe et les imports lorsque vous en aurez besoin
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class PicturesPager {}

/*
public class PicturesPager extends PagerAdapter {
    private Context context;

    private List<String> pictureUrls;


    public PicturesPager(Context context, List<String> pictureUrls) {
        this.context = context;
        this.pictureUrls = pictureUrls;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.rocket_image, null);
        container.addView(view);

        ImageView imageView = view.findViewById(R.id.image);
        Picasso.get()
                .load(pictureUrls.get(position))
                .into(imageView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }

    @Override
    public int getCount() {
        return pictureUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }
}
*/