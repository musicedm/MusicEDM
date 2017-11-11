package edm.music.t3v.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import edm.music.t3v.R;
import edm.music.t3v.model.Downloaded;

/**
 * Created by Hoàng Thông on 7/11/2017.
 */
public class DownloadedAdapter extends RecyclerView.Adapter<DownloadedAdapter.MyViewHolder> {
    private List<Downloaded> downloadlist;


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        public MyViewHolder(View view){
            super(view);

            tvTitle = (TextView) view.findViewById(R.id.title);

        }
    }

    public DownloadedAdapter(List<Downloaded> downloadlist){
        this.downloadlist = downloadlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.file_download_row,parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Downloaded blgr = downloadlist.get(position);

        holder.tvTitle.setText(blgr.getFileName());

    }

    @Override
    public int getItemCount() {
        return downloadlist.size();
    }


}
