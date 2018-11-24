package co.example.lutfillahmafazi.timnasu_19;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class chooseActivity extends AppCompatActivity {

    @BindView(R.id.btnTimInti)
    Button btnTimInti;
    @BindView(R.id.btnTimCadangan)
    Button btnTimCadangan;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ButterKnife.bind(this);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_profile:
                Intent intent = new Intent(this,ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.action_History:
                Intent intent1 = new Intent(this,HistoryActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.btnTimInti, R.id.btnTimCadangan})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnTimInti:
                intent = new Intent(this,RecycleActivity.class);
                intent.putExtra("tim","inti");
                startActivity(intent);
                break;
            case R.id.btnTimCadangan:
                intent = new Intent(this,RecycleActivity.class);
                intent.putExtra("tim","cadangan");
                startActivity(intent);
                break;
        }
    }
}
