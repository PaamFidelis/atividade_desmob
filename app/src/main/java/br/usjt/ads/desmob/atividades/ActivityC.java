package br.usjt.ads.desmob.atividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.usjt.ads.desmob.atividades.util.StatusTracker;
import br.usjt.ads.desmob.atividades.util.Utils;


public class ActivityC extends Activity {

    private String activity_nome;

    private TextView status_activity;
    private TextView status_all;

    private StatusTracker mStatusTracker = StatusTracker.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        activity_nome = getString(R.string.activity_c);

        status_activity = (TextView)findViewById(R.id.status_view_c);
        status_all = (TextView)findViewById(R.id.status_view_all_c);

        mStatusTracker.setStatus(activity_nome, getString(R.string.on_create));
        Utils.printStatus(status_activity, status_all);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mStatusTracker.setStatus(activity_nome, getString(R.string.on_start));
        Utils.printStatus(status_activity, status_all);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mStatusTracker.setStatus(activity_nome, getString(R.string.on_restart));
        Utils.printStatus(status_activity, status_all);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mStatusTracker.setStatus(activity_nome, getString(R.string.on_resume));
        Utils.printStatus(status_activity, status_all);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mStatusTracker.setStatus(activity_nome, getString(R.string.on_pause));
        Utils.printStatus(status_activity, status_all);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mStatusTracker.setStatus(activity_nome, getString(R.string.on_stop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStatusTracker.setStatus(activity_nome, getString(R.string.on_destroy));
        mStatusTracker.clear();
    }

    public void startActivityA(View v) {
        Intent intent = new Intent(ActivityC.this, ActivityA.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityC.this, ActivityB.class);
        startActivity(intent);
    }

    public void finishActivityC(View v) {
        ActivityC.this.finish();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityC.this, DialogActivity.class);
        startActivity(intent);
    }

}
