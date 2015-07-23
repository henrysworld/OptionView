package com.ch.ch_optionview;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;

@SuppressLint("NewApi") 
public class OptionView extends RadioGroup {

	private RadioButton[] viewList;
	private Context context;
	private ArrayList<String> dataList;

	public OptionView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	public OptionView(Context context) {
		super(context);
		this.context = context;
	}
	

	/**
	 * create view
	 * @author He Chen
	 * @param size	option size
	 */
	@SuppressWarnings("deprecation")
	public void createView(int size) {
		removeAllViews();
		dataList = new ArrayList<String>();
		for (int i = 'A'; i < 'Z'; i++) {
			dataList.add("" + (char) i);
		}
		viewList = new RadioButton[size];
		int index = 0;
		while (index < size) {
			viewList[index] = new RadioButton(context);
			viewList[index].setText(dataList.get(index));
			viewList[index].setGravity(Gravity.CENTER);
			viewList[index].setBackground(getResources().getDrawable(R.drawable.rb_selector));
			viewList[index].setLayoutParams(new RadioGroup.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f));
			viewList[index].setButtonDrawable(getResources().getDrawable(
					android.R.color.transparent));
			addView(viewList[index]);
			if (index != (size-1)) {
				View view = new View(context);
				view.setBackgroundColor(Color.WHITE);
				LayoutParams layoutParams = new LayoutParams(1,
						LayoutParams.MATCH_PARENT);
				layoutParams.setMargins(0, 10, 0, 10);
				view.setLayoutParams(layoutParams);

				addView(view);
				requestLayout();
			}
			index++;
		}
	}
	
	/**
	 * setting which option is checked
	 * @author He Chen
	 * @param position which
	 */
	public void setCheckedRadioButton(int position){
		viewList[position-1].setChecked(true);
	}

	
	/**
	 * get checked result
	 * @return Example:A,B,C,D
	 */
	public String getWhichRadioButtonChecked(){
		String result = "";
		for(int i = 0; i < viewList.length; i++){
			if(viewList[i].isChecked()){
				result = dataList.get(i);
				break;
			}
		}
		return result;
	}
}
