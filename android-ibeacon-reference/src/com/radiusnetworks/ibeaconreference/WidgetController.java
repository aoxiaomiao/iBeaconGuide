package com.radiusnetworks.ibeaconreference;
import android.view.View;  
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RadioButton;
import android.widget.RelativeLayout;  
  
/* 
 * ��ȡ�����ÿؼ���Ϣ 
 */  
public class WidgetController {  
  
    /* 
     * ��ȡ�ؼ��� 
     */  
    public static int getWidth(View view)  
    {  
        int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);  
        int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);  
        view.measure(w, h);  
        return (view.getMeasuredWidth());         
    }  
    /* 
     * ��ȡ�ؼ��� 
     */  
    public static int getHeight(View view)  
    {  
        int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);  
        int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);  
        view.measure(w, h);  
        return (view.getMeasuredHeight());         
    }  
      
    /* 
     * ���ÿؼ����ڵ�λ��X�����Ҳ��ı���ߣ� 
     * XΪ����λ�ã���ʱY���ܹ�0 
     */  
    public static void setLayoutX(View view,int x)  
    {  
        MarginLayoutParams margin=new MarginLayoutParams(view.getLayoutParams());  
        margin.setMargins(x,margin.topMargin, x+margin.width, margin.bottomMargin);  
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);  
        view.setLayoutParams(layoutParams);  
    }  
    /* 
     * ���ÿؼ����ڵ�λ��Y�����Ҳ��ı���ߣ� 
     * YΪ����λ�ã���ʱX���ܹ�0 
     */  
    public static void setLayoutY(View view,int y)  
    {  
        MarginLayoutParams margin=new MarginLayoutParams(view.getLayoutParams());  
        margin.setMargins(margin.leftMargin,y, margin.rightMargin, y+margin.height);  
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);  
        view.setLayoutParams(layoutParams);  
    }  
    /* 
     * ���ÿؼ����ڵ�λ��YY�����Ҳ��ı���ߣ� 
     * XYΪ����λ�� 
     */  
    public static void setLayout(RadioButton view,int x,int y)  
    {  
        MarginLayoutParams margin=new MarginLayoutParams(view.getLayoutParams());  
        margin.setMargins(x,y, x+margin.width, y+margin.height);  
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);  
        view.setLayoutParams(layoutParams);  
    }  
}  