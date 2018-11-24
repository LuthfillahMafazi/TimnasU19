package co.example.lutfillahmafazi.timnasu_19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    @BindView(R.id.myRecyle)
    RecyclerView myRecyle;

    String[] namaPemainInti, profilePemainInti, detailPemainInti,biodataPemainInti,
            namaPemainCadangan, profilePemainCadangan, detailPemainCadangan,biodataPemainCadangan;
    int[] gambarPemainInti,gambarPemainCadangan;

    AdapterPemain adapterPemain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        namaPemainInti = getResources().getStringArray(R.array.nama_pemain_tim_inti);
        profilePemainInti = getResources().getStringArray(R.array.profile_pemain_tim_inti);
        detailPemainInti = getResources().getStringArray(R.array.detail_pemain_tim_inti);
        biodataPemainInti = getResources().getStringArray(R.array.profile_pemain_tim_inti);
        gambarPemainInti = new int[]{R.drawable.muhammad_riyandi, R.drawable.rifad_marahabesy, R.drawable.rachmat_irianto, R.drawable.nurhidayat_haris, R.drawable.samuel_christianson, R.drawable.asnawi_mangkualam,
                R.drawable.syahrian_abimanyu, R.drawable.feby_eka, R.drawable.muhammad_iqbal, R.drawable.hanis_saghara, R.drawable.egy_maulana_vikri};
        namaPemainCadangan = getResources().getStringArray(R.array.nama_pemain_tim_cadangan);
        profilePemainCadangan = getResources().getStringArray(R.array.profile_pemain_tim_cadangan);
        detailPemainCadangan = getResources().getStringArray(R.array.detail_pemain_tim_cadangan);
        biodataPemainCadangan = getResources().getStringArray(R.array.profile_pemain_tim_cadangan);
        gambarPemainCadangan = new int[]{R.drawable.witan_sulaiman,R.drawable.firza_andika,R.drawable.indra_mustafa,R.drawable.rafli_mursalim,R.drawable.saddil_ramdani};

        String tim = getIntent().getStringExtra("tim");
        Log.i("isi tim",tim);

        if (tim.equals("inti")){
            adapterPemain = new AdapterPemain(RecycleActivity.this,namaPemainInti,detailPemainInti,profilePemainInti,biodataPemainInti,gambarPemainInti);
        }else {
            adapterPemain = new AdapterPemain(RecycleActivity.this,namaPemainCadangan,detailPemainCadangan,profilePemainCadangan,biodataPemainCadangan,gambarPemainCadangan);
        }

        myRecyle.setHasFixedSize(true);
        myRecyle.setLayoutManager(new LinearLayoutManager(this));
        myRecyle.setAdapter(adapterPemain);



    }

}

