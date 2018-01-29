package com.example.elfari.clearmind.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elfari.clearmind.Main2Activity;
import com.example.elfari.clearmind.Models.MySound;
import com.example.elfari.clearmind.R;

import java.util.List;

/**
 * Created by Elfari on 11/9/2017.
 */
public class MySoundAdapter extends RecyclerView.Adapter<MySoundAdapter.ViewHolder> {

    public List<MySound> mySounds;

    public MySoundAdapter(List<MySound> mySounds) {
        this.mySounds = mySounds;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final MySound sound = mySounds.get(position);

        holder.pilihan.setText(sound.getJudul());
        holder.pilihan.setTag(holder);
        holder.pilihan.setRawInputType(sound.getLagu());
        holder.pilihan.setRawInputType(sound.getSeffect());
        holder.gambar.setImageResource(sound.getGambar());

        holder.pilihan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent x = new Intent(v.getContext(), Main2Activity.class);
                x.putExtra("pilihan", sound.getJudul());
                x.putExtra("lagu", sound.getLagu());
                x.putExtra("seffect", sound.getSeffect());
                x.putExtra("bg", sound.getBackground());
                x.putExtra("gambar", sound.getGambar());

                v.getContext().startActivity(x);

                /*ViewHolder vholder = (ViewHolder) v.getTag();
                int position = vholder.getPosition();

                if (position == 0 && position<getItemCount()){
                    Intent x = new Intent(v.getContext(), Main2Activity.class);
                    MediaPlayer mPlayer = MediaPlayer.create(null, R.raw.sw);
                    try {
                        mPlayer.prepare();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    mPlayer.start();
                    v.getContext().startActivity(x);
                }
                if (position == 1 && position<getItemCount()){
                    Intent x = new Intent(v.getContext(), Main2Activity.class);
                    MediaPlayer mPlayer = MediaPlayer.create(null, R.raw.hujan);
                    try {
                        mPlayer.prepare();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    mPlayer.start();
                    v.getContext().startActivity(x);
                }
                /*if (position == 2 && position<getItemCount()){
                    Intent x = new Intent(v.getContext(), Main4Activity.class);
                    v.getContext().startActivity(x);
                }
                if (position == 3 && position<getItemCount()){
                    Intent x = new Intent(v.getContext(), Main5Activity.class);
                    v.getContext().startActivity(x);
                }*/

            }
        });
    }

    @Override
    public int getItemCount() {
        return mySounds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView pilihan;
        public ImageView gambar;
        public ViewHolder(View itemView) {
            super(itemView);
            pilihan = (TextView) itemView.findViewById(R.id.pilihan);
            gambar = (ImageView) itemView.findViewById(R.id.gambar);
        }
    }
}
