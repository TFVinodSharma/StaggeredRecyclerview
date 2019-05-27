package com.kashmiriguruji.staggeredrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class StraggeredRecyclerviewAdapter extends RecyclerView.Adapter<StraggeredRecyclerviewAdapter.ViewHolder> {
    private static final String TAG = "StraggeredRecyclerviewA";

    private ArrayList<String>mNames;
    private ArrayList<String>mImageUrls;
    private Context mcontext;

    public StraggeredRecyclerviewAdapter(Context mcontext,ArrayList<String> mNames, ArrayList<String> mImageUrls) {
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid,parent,false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,  final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        RequestOptions requestOptions=new RequestOptions()
        .placeholder(R.drawable.ic_launcher_background);

        Glide.with(mcontext)
                .load(mImageUrls.get(position))
                .apply(requestOptions)
        .into(viewHolder.imageView);

        viewHolder.textView.setText(mNames.get(position));

        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: "+mNames.get(position));
                Toast.makeText(mcontext, mNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView=itemView.findViewById(R.id.image);
            this.textView=itemView.findViewById(R.id.name);

        }
    }
}
