package com.example.memesity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.memesity.DB.MemesDBHelper;
import com.example.memesity.Models.Memes;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Post#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Post extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MemesDBHelper dbHelper;
    private SQLiteDatabase db;

    public Post() {
        // Required empty public constructor
    }

    public Post(MemesDBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper = dbHelper;
        this.db = db;
    }

    // TODO: Rename and change types and number of parameters
    public static Post newInstance(String param1, String param2) {
        Post fragment = new Post();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_post, container, false);

        EditText name = view.findViewById(R.id.post_name);
        EditText descripcio = view.findViewById(R.id.post_descripcio);

        Button button = view.findViewById(R.id.post_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String na = name.getText().toString();

                String de = descripcio.getText().toString();

                if (na.equals("") && de.equals("")) {
                    Toast.makeText(getContext(), "Need text", Toast.LENGTH_LONG).show();
                } else {
                    Memes meme = new Memes(na, de);
                    dbHelper.insertMemes(db, meme);
                    Toast.makeText(getContext(), "The meme " + na + " posted", Toast.LENGTH_LONG).show();
                    refresh();
                }
            }
        });

        return view;
    }

    public void refresh(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(Post.this).attach(Post.this).commit();
    }
}