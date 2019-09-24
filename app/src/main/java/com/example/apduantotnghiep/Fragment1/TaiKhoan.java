package com.example.apduantotnghiep.Fragment1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apduantotnghiep.R;

public class TaiKhoan extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Tài Khoản");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_tai_khoan, container, false);
    }
}
