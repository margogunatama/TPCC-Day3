package com.example.gigabyte.seconddayfirstapp.Fragment;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gigabyte.seconddayfirstapp.R;

/**
 * Created by margo on 02/11/16.
 */

public class HomeContentFragment extends Fragment {


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public TextView txt;


        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_home, parent, false));
            img = (ImageView) itemView.findViewById(R.id.home_pic);
            txt = (TextView) itemView.findViewById(R.id.home_text);
        }

    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final int LENGTH = 18;
        public final String[] inPlace;
        public final Drawable[] inPlacePic;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            inPlace = resources.getStringArray(R.array.places);
            TypedArray typedArray = resources.obtainTypedArray(R.array.places_pic);
            inPlacePic = new Drawable[typedArray.length()];

            for (int i = 0; i < inPlacePic.length; i++) {
                inPlacePic[i] = typedArray.getDrawable(i);
            }
            typedArray.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //nope
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);

        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        //set padding

        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return recyclerView;
    }
}



