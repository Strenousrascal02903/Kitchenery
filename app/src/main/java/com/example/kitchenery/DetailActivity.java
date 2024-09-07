package com.example.kitchenery;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.kitchenery.databinding.ActivityDetailBinding;
import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        if (intent != null) {
            String id = intent.getStringExtra("makanan_id");
            getDetailMakanan(id);
        }
    }

    public void getDetailMakanan(String id) {
        progressDialog = new ProgressDialog(DetailActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<Makanan> call = service.getDetailMakanan(id);
        call.enqueue(new Callback<Makanan>() {
            @Override
            public void onResponse(Call<Makanan> call, Response<Makanan> response) {
                progressDialog.dismiss();
                Makanan makanan = response.body();
                setDataUI(makanan);
            }

            @Override
            public void onFailure(Call<Makanan> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(DetailActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setDataUI(Makanan makanan ) {




        binding.jdlDetail.setText(makanan.getStrMeal());
        binding.category.setText(makanan.getStrCategory());
        binding.area.setText(makanan.getStrArea());
        binding.mea1.setText(makanan.getStrMeasure1());
        binding.mea2.setText(makanan.getStrMeasure2());
        binding.mea3.setText(makanan.getStrMeasure3());
        binding.mea4.setText(makanan.getStrMeasure4());
        binding.mea5.setText(makanan.getStrMeasure5());
        binding.mea6.setText(makanan.getStrMeasure6());
        binding.mea7.setText(makanan.getStrMeasure7());
        binding.mea8.setText(makanan.getStrMeasure8());
        binding.mea9.setText(makanan.getStrMeasure9());
        binding.mea10.setText(makanan.getStrMeasure10());
        binding.mea11.setText(makanan.getStrMeasure11());
        binding.mea12.setText(makanan.getStrMeasure12());
        binding.mea13.setText(makanan.getStrMeasure13());
        binding.mea14.setText(makanan.getStrMeasure14());
        binding.mea15.setText(makanan.getStrMeasure15());
        binding.mea16.setText(makanan.getStrMeasure16());
        binding.mea17.setText(makanan.getStrMeasure17());
        binding.mea18.setText(makanan.getStrMeasure18());
        binding.mea19.setText(makanan.getStrMeasure19());
        binding.mea20.setText(makanan.getStrMeasure20());
        binding.ingr1.setText(makanan.getStrIngredient1());
        binding.ingr2.setText(makanan.getStrIngredient2());
        binding.ingr3.setText(makanan.getStrIngredient3());
        binding.ingr4.setText(makanan.getStrIngredient4());
        binding.ingr5.setText(makanan.getStrIngredient5());
        binding.ingr6.setText(makanan.getStrIngredient6());
        binding.ingr7.setText(makanan.getStrIngredient7());
        binding.ingr8.setText(makanan.getStrIngredient8());
        binding.ingr9.setText(makanan.getStrIngredient9());
        binding.ingr10.setText(makanan.getStrIngredient10());
        binding.ingr11.setText(makanan.getStrIngredient11());
        binding.ingr12.setText(makanan.getStrIngredient12());
        binding.ingr13.setText(makanan.getStrIngredient13());
        binding.ingr14.setText(makanan.getStrIngredient14());
        binding.ingr15.setText(makanan.getStrIngredient15());
        binding.ingr16.setText(makanan.getStrIngredient16());
        binding.ingr17.setText(makanan.getStrIngredient17());
        binding.ingr18.setText(makanan.getStrIngredient18());
        binding.ingr19.setText(makanan.getStrIngredient19());
        binding.ingr20.setText(makanan.getStrIngredient20());
        binding.instructionn.setText(makanan.getStrInstructions());

        String urlPoster = makanan.getStrMealThumb();
        Picasso.get()
                .load(urlPoster)
                .placeholder(R.drawable.image_placeholder)
                .error(R.drawable.image_placeholder_error)
                .into(binding.imgDetail);
    }
}
