package com.example.shop.category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.shop.BaseActivity;
import com.example.shop.R;
import com.example.shop.dto.category.CategoryItemDTO;
import com.example.shop.service.ApplicationNetwork;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryEditActivity extends BaseActivity {

    TextInputEditText txtCategoryNameEdit;
    TextInputEditText txtCategoryPriorityEdit;
    TextInputEditText txtCategoryDescriptionEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_edit);
        txtCategoryNameEdit = findViewById(R.id.txtCategoryNameEdit);
        txtCategoryPriorityEdit = findViewById(R.id.txtCategoryPriorityEdit);
        txtCategoryDescriptionEdit = findViewById(R.id.txtCategoryDescriptionEdit);

        Bundle b = getIntent().getExtras();
        int value = 0; // or other values
        if(b != null)
            value = b.getInt("id");
        Toast.makeText(this, "ID Edit "+ value, Toast.LENGTH_SHORT).show();
        serverRequestById(value);
    }
    private void serverRequestById(int id) {

        ApplicationNetwork.getInstance()
                .getCategoriesApi()
                .getById(id)
                .enqueue(new Callback<CategoryItemDTO>() {
                    @Override
                    public void onResponse(Call<CategoryItemDTO> call, Response<CategoryItemDTO> response) {
                        //Toast.makeText(CategoryEditActivity.this, "", Toast.LENGTH_SHORT).show();
                        CategoryItemDTO dto=response.body();
                        txtCategoryNameEdit.setText(dto.getName());
                    }

                    @Override
                    public void onFailure(Call<CategoryItemDTO> call, Throwable t) {

                    }
                });
    }
}