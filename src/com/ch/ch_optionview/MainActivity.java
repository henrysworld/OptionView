package com.ch.ch_optionview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity implements MainView{
	
	private OptionView ov_content;
	private ProgressBar pb_content;
	private MainPresenterImpl presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initUI();
        
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
    	presenter = new MainPresenterImpl(this);
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
}
