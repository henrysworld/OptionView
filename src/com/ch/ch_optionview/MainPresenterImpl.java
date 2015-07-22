package com.ch.ch_optionview;

import android.os.Handler;

public class MainPresenterImpl implements MainPresenter, OnFinishListener{
	
	private MainView view;
	private int size;
	private int position;
	
	public MainPresenterImpl(MainView view){
		this.view = view;
	}

	@Override
	public void createView() {
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				size = 4;
				position = 2;
				view.showItems(size, position);
			}
		}, 2000);
	}

	@Override
	public void onFinish() {
		// TODO Auto-generated method stub
		view.hideProgress();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		view.showProgress();
	}

}
