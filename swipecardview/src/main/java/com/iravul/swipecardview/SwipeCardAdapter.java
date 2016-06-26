package com.iravul.swipecardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.koushikdutta.ion.Ion;
import java.util.List;

public class SwipeCardAdapter extends RecyclerView.Adapter<SwipeCardAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private List<SwipeCardModel> data;
    private Context context;
    private static RecyclerViewClickListener itemListener;


    public SwipeCardAdapter(Context context, List<SwipeCardModel> data, RecyclerViewClickListener itemListener) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
        this.itemListener = itemListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SwipeCardModel chosen;
        TextView txtProductName;
        TextView txtProductDesc;
        TextView txtPrice;
        ImageView imgProduct;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgProduct = (ImageView)itemView.findViewById(R.id.img_product);
            txtProductName = (TextView)itemView.findViewById(R.id.txt_product_name);
            txtProductDesc = (TextView)itemView.findViewById(R.id.txt_product_desc);
            txtPrice = (TextView)itemView.findViewById(R.id.txt_price);
        }

        public void setItem(SwipeCardModel productItem) {
            chosen = productItem;
            txtProductName.setText(chosen.getDescription());
            txtProductDesc.setText(chosen.getId());
            txtPrice.setText(chosen.getPrice());
            if(chosen.getPhotoUrl()!=null && !chosen.getPhotoUrl().equals("")) {
                Ion.with(context).load(chosen.getPhotoUrl()).intoImageView(imgProduct);
            }
        }

        @Override
        public void onClick(View view) {
            itemListener.recyclerViewListClicked(view, getAdapterPosition());
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_card_item, parent, false);
        //set row view height and margins

        int ROW_MARGIN = 200;
        ViewGroup.MarginLayoutParams marginParams;
        view.setLayoutParams(new RecyclerView.LayoutParams(UIHelper.getScreenWidth(context) - ROW_MARGIN, UIHelper.getContainerHeight(context) - ROW_MARGIN));
        marginParams = new ViewGroup.MarginLayoutParams(view.getLayoutParams());
        ImageView imageView = (ImageView)view.findViewById(R.id.img_product);
        imageView.getLayoutParams().height = UIHelper.getContainerHeight(context)/2;
        //if first row
        if (viewType == 0) {
            marginParams.setMargins(ROW_MARGIN / 4, 0, 0, 0);
        } else if (viewType == 1)  //for last row
        {
            marginParams.setMargins(ROW_MARGIN / 4, 0, ROW_MARGIN / 4, 0);
        } else //for the others
        {
            marginParams.setMargins(ROW_MARGIN / 4, 0, 0, 0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginParams);
        view.setLayoutParams(layoutParams);


        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SwipeCardModel current = data.get(position);
        holder.setItem(current);
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) {return 0;}
        else if(position+1==data.size()) {return 1;}
        else {return 2;}
    }

    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                    int center = UIHelper.getScreenWidth(context) / 2;
                    int padding = 0; //Assuming both left and right padding needed are the same
                    recyclerView.setPadding(padding, 0, padding, 0);
                    recyclerView.setOnScrollListener(new CenterLockListener(center));
            }
        });
    }
}