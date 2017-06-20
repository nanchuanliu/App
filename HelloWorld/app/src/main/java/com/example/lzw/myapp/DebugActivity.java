package com.example.lzw.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lzw.myapp.IReportBack;
import com.example.lzw.myapp.R;

/**
 * Created by Administrator on 2017/6/11.
 */

public abstract class DebugActivity extends Activity implements IReportBack {

    protected abstract boolean onMenuItemSelected(MenuItem item);

    private static String tag=null;
    private int menuId=0;

    public DebugActivity(int inMenuId,String inTag)
    {
        tag=inTag;
        menuId=inMenuId;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug_layout);
        TextView tv=this.getTextView();
        tv.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(menuId,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        appendMenuItemText(item);
        if(item.getItemId()==R.id.menu_da_clear)
        {
            this.emptyText();
            return true;
        }

        return onMenuItemSelected(item);
    }

    private void appendMenuItemText(MenuItem menuItem)
    {
        String title=menuItem.getTitle().toString();
        TextView tv=getTextView();
        tv.setText(tv.getText()+"\n"+title);
    }

    private void emptyText()
    {
        TextView tv=getTextView();
        tv.setText("");
    }

    private void appendText(String s)
    {
        TextView tv=getTextView();
        tv.setText(tv.getText()+"\n"+s);
        Log.d(tag,s);
    }

    @Override
    public void reportBack(String tag, String message) {
        this.appendText(tag+":"+message);
        Log.d(tag,message);
    }

    @Override
    public void reportTransient(String tag, String message) {
        String s=tag+":"+message;
        Toast mToast= Toast.makeText(this,s,Toast.LENGTH_SHORT);
        mToast.show();
        reportBack(tag,message);
        Log.d(tag,message);
    }

    public TextView getTextView() {
        return (TextView)this.findViewById(R.id.text1);
    }
}