package io.github.xudaojie.scrollbehavior;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private Activity mContext;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new ListAdapter());
    }

    class ListAdapter extends RecyclerView.Adapter {

        private static final int ITEM_CONTENT = 0;
        private static final int ITEM_FOOT = 1;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if (viewType == ITEM_CONTENT) {
                view = LayoutInflater.from(mContext).inflate(R.layout.main_item, parent, false);
            } else {
                view = LayoutInflater.from(mContext).inflate(R.layout.empty_item, parent, false);
            }
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return 8 + 1;
        }

        @Override
        public int getItemViewType(int position) {
            super.getItemViewType(position);
            if (position == getItemCount() - 1) {
                return ITEM_FOOT;
            }
            return ITEM_CONTENT;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
