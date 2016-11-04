package com.example.gigabyte.seconddayfirstapp.Fragment;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gigabyte.seconddayfirstapp.R;

import org.w3c.dom.Text;


/**
 * Created by margo on 02/11/16.
 */

public class ContactContentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);

        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView b;
        public TextView txt;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_about, parent, false));
            b = (ImageView) itemView.findViewById(R.id.contact_pic);
            txt = (TextView) itemView.findViewById(R.id.contact_text);
        }

    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final int LENGTH = 18;

        private final String[] mPlaces;
        private final Drawable[] mPlacePic;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mPlaces = resources.getStringArray(R.array.places);
            TypedArray typedArray = resources.obtainTypedArray(R.array.places_pic);
            mPlacePic = new Drawable[typedArray.length()];

            for (int i = 0; i < mPlacePic.length; i++) {
                mPlacePic[i] = typedArray.getDrawable(i);
            }
            typedArray.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.b.setImageDrawable(mPlacePic[position % mPlacePic.length]);
            holder.txt.setText(mPlaces[position % mPlaces.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }


}
