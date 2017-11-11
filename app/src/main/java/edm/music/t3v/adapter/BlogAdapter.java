package edm.music.t3v.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import edm.music.t3v.R;
import edm.music.t3v.app.AppController;
import edm.music.t3v.model.BlogRadio;

/**
 * Created by Hoàng Thông on 7/11/2017.
 */
public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.MyViewHolder> {
    private List<BlogRadio> radiolist;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvCat, tvComment, tvView, tvLike;
        NetworkImageView thumbNail;
        public MyViewHolder(View view){
            super(view);
            if (imageLoader == null)
                imageLoader = AppController.getInstance().getImageLoader();
            thumbNail = (NetworkImageView) view.findViewById(R.id.thumbnail);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvCat = (TextView)view.findViewById(R.id.tvCat);
            tvComment = (TextView)view.findViewById(R.id.tvComment);
            tvView = (TextView)view.findViewById(R.id.tvView);
            tvLike = (TextView)view.findViewById(R.id.tvLike);
        }
    }

    public BlogAdapter(List<BlogRadio> radiolist){
        this.radiolist = radiolist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.radio_list_row,parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BlogRadio blgr = radiolist.get(position);
        holder.thumbNail.setImageUrl(blgr.getThumb_radio(), imageLoader);
        holder.tvTitle.setText(blgr.getName_radio());
        holder.tvCat.setText(blgr.getCategory_radio());
        holder.tvView.setText(blgr.getView_radio());
        holder.tvComment.setText(blgr.getComment_radio());
        holder.tvLike.setText(blgr.getLike_radio());
    }

    @Override
    public int getItemCount() {
        return radiolist.size();
    }


}
