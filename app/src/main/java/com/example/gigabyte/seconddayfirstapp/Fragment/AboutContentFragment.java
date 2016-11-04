package com.example.gigabyte.seconddayfirstapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gigabyte.seconddayfirstapp.R;

/**
 * Created by margo on 02/11/16.
 */

public class AboutContentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_about, null);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_about, parent, false));
        }

    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final int LENGTH = 18;


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

    public static class TileContentFragment extends android.app.Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);

            ContentAdapter adapter = new ContentAdapter();
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);

            //set padding

            int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
            recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

            return recyclerView;
        }
    }
}
