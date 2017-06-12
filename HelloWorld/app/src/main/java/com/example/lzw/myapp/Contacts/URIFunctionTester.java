package com.example.lzw.myapp.Contacts;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.example.lzw.myapp.BaseTester;
import com.example.lzw.myapp.IReportBack;
import com.example.lzw.myapp.Utils;

/**
 * Created by Administrator on 2017/6/11.
 */

public class URIFunctionTester extends BaseTester {

    protected static String tag="tc>";

    public URIFunctionTester(Context ctx, IReportBack target) {
        super(ctx, target);
    }

    protected Cursor getACursor(String uri,String clause)
    {
        Activity a=(Activity)this.mContext;
        return getACursor(Uri.parse(uri),clause);
    }

    protected Cursor getACursor(Uri uri, String clause)
    {
        Activity a=(Activity)this.mContext;
        return a.getContentResolver().query(uri,null,clause,null,null);
    }

    protected void printCursorColumnNames(Cursor c)
    {
        this.mReportTo.reportBack(tag, Utils.getCursorColumnNames(c));
    }
}
