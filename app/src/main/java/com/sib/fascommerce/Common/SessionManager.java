package com.sib.fascommerce.Common;

import android.content.Context;
import android.content.SharedPreferences;


import java.util.HashMap;

public class SessionManager {
 //   private UserDataModel userDataModel;
    SharedPreferences sh;
    SharedPreferences.Editor ed;
    Context c;
    public static final String USERSESSION = "userLogIn";
    public static final String REMEMBERME = "userRemember";


    public static final String ISLOGGED = "ISLOGGEDIN";

    public static final String FULLNAME = "FULLNAME";
    public static final String EMAIL = "EMAIL";
    public static final String PHONE = "PHONE";
    public static final String URL = "URL";
    public static final String TOKEN = "TOKEN";
    public static final String POINTS = "POINTS";
    public static final String UID = "UID";
    public static final String WHAT = "WHAT";



    public static final String ISREMEMBERME = "REMEMBERME";
    public static final String REMEMBERMEPHONE = "PHONE";
    public static final String REMEMBERMEPASS = "PASS";


    public SessionManager(Context c, String session) {
        this.c = c;
        sh = c.getSharedPreferences(session, Context.MODE_PRIVATE);
        ed = sh.edit();
    }



    public void loginSession(String fullname, String email, String phone,String url,String token,String what) {

        ed.putBoolean(ISLOGGED, true);
        ed.putString(FULLNAME, fullname);
        ed.putString(EMAIL, email);
        ed.putString(PHONE, phone);
        ed.putString(URL, url);
        ed.putString(TOKEN, token);
        ed.putString(WHAT, what);
        ed.commit();
    }

    public HashMap<String, String> returnData() {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put(FULLNAME, sh.getString(FULLNAME, null));
        hm.put(EMAIL, sh.getString(EMAIL, null));
        hm.put(PHONE, sh.getString(PHONE, null));
        hm.put(URL, sh.getString(URL, null));
        hm.put(TOKEN, sh.getString(TOKEN, null));
        hm.put(POINTS, sh.getString(POINTS, null));
        hm.put(UID, sh.getString(UID, null));
        hm.put(WHAT, sh.getString(WHAT, null));

        return hm;
    }

    public boolean checkLogin() {
        if (sh.getBoolean(ISLOGGED, true)) {
            return true;
        } else
            return false;
    }

    public void logOut() {
        ed.clear();
        ed.commit();
    }

    public void rememberMeSession(String phone, String pass) {

        ed.putBoolean(ISREMEMBERME, true);


        ed.putString(REMEMBERMEPHONE, phone);
        ed.putString(REMEMBERMEPASS, pass);

        ed.commit();
    }

    public HashMap<String, String> returnDataRememberMe() {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put(REMEMBERMEPHONE, sh.getString(REMEMBERMEPHONE, null));

        hm.put(REMEMBERMEPASS, sh.getString(REMEMBERMEPASS, null));

        return hm;
    }

    public boolean checkRememberMe() {
        if (sh.getBoolean(ISREMEMBERME, true)) {
            return true;
        } else
            return false;
    }


}
