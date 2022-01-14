package com.cursoandroid11.dominospizza;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;

//Creo esta clase para conectar en un array de productos los producto que se inserten y los concatena para depsues el listView
public class ProductAdapter extends ArrayAdapter<Product> {
    private Context context;
    public ProductAdapter(@NonNull Context context, List<Product> products) {
        super(context, R.layout.product_item,products);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View v=layoutInflater.inflate(R.layout.product_item,null);

        TextView txtTitle=v.findViewById(R.id.txt_title);
        TextView txtDescription=v.findViewById(R.id.txt_description);
        TextView txtPrice=v.findViewById(R.id.txt_price);
        RelativeLayout layoutBg=v.findViewById(R.id.layout_background);

        Product product=getItem(position);

        txtTitle.setText(product.getProductoTitle());
        txtDescription.setText(product.getProductDescription());
        txtPrice.setText(product.getProductPrice());
        Glide.with(context).load(product.getProductImg()).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                layoutBg.setBackground(resource);
            }
        });

        //Pone las opciones en un arreglo de string para su seleccion
        String[] sizeData=new String[]{"Regular","Medium","Large"};
        String[] crustData=new String[]{"Classic Hand Tossed","Wheat Thin Crust","Cheese Burst","Cheese Float"};

        //Machear el spinner con sus variables por medio de ID
        Spinner spinnerSize=v.findViewById(R.id.spinner_size);
        Spinner spinnerCrust=v.findViewById(R.id.spinner_crust);

        //Array adapter para meter las opciones dentro de los spinner
        ArrayAdapter<String> sizesAdapter=new ArrayAdapter<>(context, R.layout.spinner_item,sizeData);
        ArrayAdapter<String> crustAdapter=new ArrayAdapter<>(context, R.layout.spinner_item,crustData);


        spinnerSize.setAdapter(sizesAdapter);
        spinnerCrust.setAdapter(crustAdapter);

        return v;

    }
}
