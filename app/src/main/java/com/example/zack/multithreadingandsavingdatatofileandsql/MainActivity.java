package com.example.zack.multithreadingandsavingdatatofileandsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void executeAsyncTasks(View view) {
        if (view.getId() == R.id.btnAsyncTask) {
            CustomAsyncTask customAsyncTask = new CustomAsyncTask();
            CustomAsyncTask customAsyncTask1 = new CustomAsyncTask();
            CustomAsyncTask customAsyncTask2 = new CustomAsyncTask();
            customAsyncTask.executeOnExecutor(CustomAsyncTask.THREAD_POOL_EXECUTOR);
            customAsyncTask1.executeOnExecutor(CustomAsyncTask.THREAD_POOL_EXECUTOR);
            customAsyncTask2.executeOnExecutor(CustomAsyncTask.THREAD_POOL_EXECUTOR);
//            customAsyncTask.execute();
//            customAsyncTask1.execute();
//            customAsyncTask2.execute();


        }
    }

    public void executeDatabase(View view) {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        String name = "Zack";
        String phone0 = "0";
        String phone1 = "1";
        String phone2 = "2";
        String phone3 = "3";
        String address = "address";
        String social = "social";
        String license = "license";
        String newName = "Lisa";
        databaseHelper.createContact(name, phone0, social, address, license);
        databaseHelper.createContact(name, phone1, social, address, license);
        databaseHelper.createContact(name, phone2, social, address, license);
        databaseHelper.readContact(2);
        databaseHelper.updateContact(newName, phone1);
        databaseHelper.readContact(1);
        databaseHelper.deleteContact(phone1);
        databaseHelper.readContact(1);
        //databaseHelper.deleteContact();

    }
}


