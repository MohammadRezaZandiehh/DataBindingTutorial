package com.example.databindingtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.databindingtutorial.databinding.ActivityMainBinding;
import com.example.databindingtutorial.models.Product;
import com.example.databindingtutorial.util.Products;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    //data binding
    ActivityMainBinding mBinding;

    //vars
    private Product mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Products products = new Products();
        mProduct = products.PRODUCTS[2];

        mBinding.setProduct(mProduct);
        mBinding.setQuantity(1);
        mBinding.setIMainActivity((IMainActivity) this);
        mBinding.setTestUrl("https://i.redd.it/g5acbfi5hkm01.jpg");
    }

    @Override
    public void inflateQuantityDialog() {
        ChooseQuantityDialog dialog = new ChooseQuantityDialog();
        dialog.show(getSupportFragmentManager(), getString(R.string.dialog_choose_quantity));
    }

    @Override
    public void setQuantity(int quantity) {
        mBinding.setQuantity(quantity);
    }
}