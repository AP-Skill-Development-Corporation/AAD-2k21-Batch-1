package com.example.dummywhtsup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dummywhtsup.contacts.MyAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatsFragment extends Fragment {
RecyclerView rec;
int images[];
String contact_names[];
String contactNumbers[];
MyAdapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChatsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatsFragment newInstance(String param1, String param2) {
        ChatsFragment fragment = new ChatsFragment();
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
        View v= inflater.inflate(R.layout.fragment_chats, container, false);
        rec=v.findViewById(R.id.recycler);
        contact_names=getResources().getStringArray(R.array.names);
        contactNumbers=getResources().getStringArray(R.array.numbers);
        images=new int[]{
                R.drawable.apssdc_final,
                R.drawable.apssdc_logo,
                R.drawable.f,
                R.drawable.twitter,
                R.drawable.g_siginin,
                R.drawable.kotlin_vs_java,
                R.drawable.succ,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher_round,
                R.drawable.f,
                R.drawable.succ,
        };
        adapter=new MyAdapter(getActivity(),images,contact_names,contactNumbers);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        rec.setAdapter(adapter);
        return v;
    }
}