package co.example.lutfillahmafazi.timnasu_19;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterPemain extends RecyclerView.Adapter<AdapterPemain.ViewHolder> {

    Context context;
    String[] namaPemain,detailPemain,profilePemain,biodataPemain;
    int[] gambarPemain;

    public AdapterPemain(Context context, String[] namaPemain, String[] detailPemain, String[] profilePemain, String[] biodataPemain, int[] gambarPemain) {
        this.context = context;
        this.namaPemain = namaPemain;
        this.detailPemain = detailPemain;
        this.profilePemain = profilePemain;
        this.gambarPemain = gambarPemain;
        this.biodataPemain = biodataPemain;
    }

    @NonNull
    @Override
    public AdapterPemain.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_pemain,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterPemain.ViewHolder viewHolder,final int i) {
        viewHolder.txtPemain.setText(namaPemain[i]);
        viewHolder.biodataPemain.setText(biodataPemain[i]);
        Glide.with(context).load(gambarPemain[i]).into(viewHolder.imgPemain);


        viewHolder.btnDetailPemain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPemainActivity.class);

                intent.putExtra("np",namaPemain[i]);
                intent.putExtra("dp",detailPemain[i]);
                intent.putExtra("gp",gambarPemain[i]);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarPemain.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtPemain, biodataPemain;
        ImageView imgPemain;
        Button btnDetailPemain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPemain = itemView.findViewById(R.id.txtPemain);
            imgPemain = itemView.findViewById(R.id.imgPemain);
            btnDetailPemain = itemView.findViewById(R.id.btnDetailPemain);
            biodataPemain = itemView.findViewById(R.id.txtBiodataPemain);
        }
    }
}
