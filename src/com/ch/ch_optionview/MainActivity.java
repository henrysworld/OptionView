package com.ch.ch_optionview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements MainView, OnClickListener{
	
	private OptionView ov_content;
	private ProgressBar pb_content;
	private Button btn_content;
	private MainPresenterImpl presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initUI();
        
        setListeners();
        
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	presenter.onResume();
    	presenter.createView();
    	presenter.onFinish();
    }
    
    private void initUI(){
    	ov_content = (OptionView) findViewById(R.id.ov_content);
    	pb_content = (ProgressBar) findViewById(R.id.pb_content);
    	btn_content = (Button) findViewById(R.id.btn_content);
    	presenter = new MainPresenterImpl(this);
    }
    
    private void setListeners(){
    	btn_content.setOnClickListener(this);
    }

	@Override
	public void showItems(int size, int position) {
		// TODO Auto-generated method stub
		ov_content.createView(size);
		ov_content.setCheckedRadioButton(position);
	}

	@Override
	public void showProgress() {
		pb_content.setVisibility(View.VISIBLE);
		ov_content.setVisibility(View.GONE);
	}

	@Override
	public void hideProgress() {
		pb_content.setVisibility(View.GONE);
		ov_content.setVisibility(View.VISIBLE);
	}

	@Override
	public void showMessage(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		presenter.getChooseResult(ov_content);
	}
}
