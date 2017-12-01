package com.example.gauravgoyal.memoryleaksexample;

import android.content.Context;

/**
 * Created by gauravgoyal on 30/11/17.
 */

public class StaticClassWithActivityReference {

    private static StaticClassWithActivityReference a;
    private Context context;

    private StaticClassWithActivityReference(Context context){
        this.context = context;
    }

    public static StaticClassWithActivityReference getInstance(Context context){
        if(a==null)
            a = new StaticClassWithActivityReference(context);

        return a;
    }
}
