package com.example.memesity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.memesity.DB.MemesDBHelper;
import com.example.memesity.Models.Memes;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePrincipal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePrincipal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MemesDBHelper dbHelper;
    private SQLiteDatabase db;


    public HomePrincipal() {
        // Required empty public constructor
    }

    public HomePrincipal(MemesDBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper = dbHelper;
        this.db = db;
    }


    // TODO: Rename and change types and number of parameters
    public static HomePrincipal newInstance(String param1, String param2) {
        HomePrincipal fragment = new HomePrincipal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homeprincipal, container, false);

        dbHelper = new MemesDBHelper(getContext());
        db = dbHelper.getWritableDatabase();

        ArrayList<Memes> array_memes = dbHelper.getMemes(db);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dbHelper, db, array_memes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        Button buttonDropAll = view.findViewById(R.id.btnDropAll); //button delete all
        buttonDropAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("All memes will be deleted");
                builder.setMessage("Do you want to continue?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dbHelper.dropAllMemes(db);
                                refresh();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });
        LinearLayout post = view.findViewById(R.id.roundbutton);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new Post(dbHelper, db)).commit();
            }
        });


        return view;
    }


    public void refresh() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(HomePrincipal.this).attach(HomePrincipal.this).commit();
    }


}