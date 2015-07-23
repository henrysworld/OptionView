package com.ch.ch_optionview;

import android.os.Handler;

public class MainPresenterImpl implements MainPresenter, OnFinishListener{
	
	private MainView view;
	private int size = 0;
	private int position = 0;
	
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
				view.hideProgress();
			}
		}, 2000);
	}

	@Override
	public void onFinish() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		view.showProgress();
	}

	@Override
	public void getChooseResult(OptionView ov_content) {
		String message = ov_content.getWhichRadioButtonChecked();
		view.showMessage(String.format("选择了%s选项", message));
	}

}
