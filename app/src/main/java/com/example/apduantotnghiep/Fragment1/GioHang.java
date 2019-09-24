package com.example.apduantotnghiep.Fragment1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apduantotnghiep.R;

public class GioHang extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Giỏ hàng");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v=inflater.inflate(R.layout.activity_gio_hang, container, false);
        return v;
    }
}
