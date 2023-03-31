package com.example.kwako.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.kwako.HouseBooking;
import com.example.kwako.MainActivity;
import com.example.kwako.R;

import java.util.List;

public class AllHousesAdapter extends RecyclerView.Adapter<AllHousesAdapter.MyViewHolder> {
    private Context context;
    private List<SlideModel> imageList;

    public AllHousesAdapter(Context context, List<SlideModel> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.house_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // bind data to view in order to be rendered to the user
        holder.imageSlider.setImageList(imageList);
        holder.tvLocation.setText("L: Nyeri");
        holder.tvPrice.setText("Ksh. 9,000");
        holder.tvPhone.setText("saf: 07565545454");
        holder.tvHouseType.setText("One BedRoom");
        holder.btnBook.setOnClickListener(holder.onBookListener);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // declare views
        ImageSlider imageSlider;
        TextView tvLocation, tvPrice, tvPhone, tvHouseType;
        Button btnBook;
        View.OnClickListener onBookListener;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // initialize views
            imageSlider = itemView.findViewById(R.id.imageSlider);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvHouseType = itemView.findViewById(R.id.tvHouseType);
            btnBook = itemView.findViewById(R.id.btnBook);
            // House Booked Listener
            onBookListener = view -> {
                Context context = itemView.getContext();
                Toast.makeText(context, "Booking coming soon", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,HouseBooking.class);
                context.startActivity(intent);
           };

        }
    }
}
