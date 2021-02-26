package com.eoayem.basketballscoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int scoreTeam1 = 0, scoreTeam2 = 0;
    TextView txtScoreTeam1, txtScoreTeam2;
    Button btnPlus1Team1, btnPlus2Team1, btnPlus3Team1, btnPlus1Team2, btnPlus2Team2, btnPlus3Team2, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapIdView();
        setupView();
    }

    private void setupView() {
        btnPlus1Team1.setOnClickListener(this);
        btnPlus2Team1.setOnClickListener(this);
        btnPlus3Team1.setOnClickListener(this);
        btnPlus1Team2.setOnClickListener(this);
        btnPlus2Team2.setOnClickListener(this);
        btnPlus3Team2.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    private void mapIdView() {
        txtScoreTeam1 = findViewById(R.id.txtScoreTeam1);
        txtScoreTeam2 = findViewById(R.id.txtScoreTeam2);
        btnPlus1Team1 = findViewById(R.id.btnPlus1Team1);
        btnPlus2Team1 = findViewById(R.id.btnPlus2Team1);
        btnPlus3Team1 = findViewById(R.id.btnPlus3Team1);
        btnPlus1Team2 = findViewById(R.id.btnPlus1Team2);
        btnPlus2Team2 = findViewById(R.id.btnPlus2Team2);
        btnPlus3Team2 = findViewById(R.id.btnPlus3Team2);
        btnReset = findViewById(R.id.btnReset);
    }

    private void updateScoreView(int id) {
        if (getResources().getResourceEntryName(id).contains("Reset")) {
            txtScoreTeam1.setText(String.valueOf(scoreTeam1));
            txtScoreTeam2.setText(String.valueOf(scoreTeam2));
        } else if (getResources().getResourceEntryName(id).contains("Team1"))
            txtScoreTeam1.setText(String.valueOf(scoreTeam1));
        else
            txtScoreTeam2.setText(String.valueOf(scoreTeam2));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlus1Team1:
                scoreTeam1++;
                break;

            case R.id.btnPlus2Team1:
                scoreTeam1 += 2;
                break;

            case R.id.btnPlus3Team1:
                scoreTeam1 += 3;
                break;

            case R.id.btnPlus1Team2:
                scoreTeam2++;
                break;

            case R.id.btnPlus2Team2:
                scoreTeam2 += 2;
                break;

            case R.id.btnPlus3Team2:
                scoreTeam2 += 3;
                break;

            case R.id.btnReset: {
                scoreTeam1 = 0;
                scoreTeam2 = 0;
                break;
            }
        }
        updateScoreView(v.getId());
    }
}