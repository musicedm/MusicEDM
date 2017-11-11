package edm.music.t3v.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import edm.music.t3v.R;
import edm.music.t3v.model.Category;

/**
 * Created by Hoàng Thông on 7/11/2017.
 */
public class CatAdapter extends RecyclerView.Adapter<CatAdapter.MyViewHolder> {
    private List<Category> catlist;


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        public MyViewHolder(View view){
            super(view);

            tvTitle = (TextView) view.findViewById(R.id.title);

        }
    }

    public CatAdapter(List<Category> catlist){
        this.catlist = catlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_row,parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category blgr = catlist.get(position);

        holder.tvTitle.setText(blgr.getTitle());

    }

    @Override
    public int getItemCount() {
        return catlist.size();
    }


}
