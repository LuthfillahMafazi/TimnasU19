package co.example.lutfillahmafazi.timnasu_19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPemainActivity extends AppCompatActivity {

    @BindView(R.id.imgDetailPemain)
    ImageView imgDetailPemain;
    @BindView(R.id.txtNamaPemain)
    TextView txtNamaPemain;
    @BindView(R.id.txtDetailPemain)
    TextView txtDetailPemain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemain);
        ButterKnife.bind(this);

        txtNamaPemain.setText(getIntent().getStringExtra("np"));
        txtDetailPemain.setText(getIntent().getStringExtra("dp"));
        Glide.with(this).load(getIntent().getIntExtra("gp",0)).into(imgDetailPemain);
    }
}
