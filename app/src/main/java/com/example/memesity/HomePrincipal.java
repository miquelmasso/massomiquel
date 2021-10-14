package com.example.memesity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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

    public HomePrincipal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
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

        ArrayList<String> array_noms = new ArrayList<String>();
        array_noms.add("Luke Skywalker");
        array_noms.add("Leia Organa");
        array_noms.add("Chewbacca");
        array_noms.add("C3P0");
        array_noms.add("R2D2");
        array_noms.add("Darth Vader");
        array_noms.add("Han Solo");
        array_noms.add("Luke Skywalker");
        array_noms.add("Leia Organa");
        array_noms.add("Chewbacca");
        array_noms.add("C3P0");
        array_noms.add("R2D2");
        array_noms.add("Darth Vader");
        array_noms.add("Han Solo");
        array_noms.add("Luke Skywalker");
        array_noms.add("Leia Organa");
        array_noms.add("Chewbacca");
        array_noms.add("C3P0");
        array_noms.add("R2D2");
        array_noms.add("Darth Vader");
        array_noms.add("Han Solo");



        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(array_noms);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        return view;
    }
}