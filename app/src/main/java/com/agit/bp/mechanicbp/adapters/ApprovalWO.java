package com.agit.bp.mechanicbp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.agit.bp.mechanicbp.R;
import com.agit.bp.mechanicbp.database.DatabaseHelper;
import com.agit.bp.mechanicbp.models.ModelStatusWO;
import com.agit.bp.mechanicbp.models.ModelWOHeader;

import java.util.List;

/**
 * Created by erwin on 6/14/16.
 */
public class ApprovalWO extends RecyclerView.Adapter<ApprovalWO.MyViewHolder> {

    private Context mContext;
    private List<ModelWOHeader> mOrderList;
    private List<ModelStatusWO> mStatus;
    private DatabaseHelper db;

    public ApprovalWO(Context mContext, List<ModelWOHeader> mOrderList) {
        this.mContext = mContext;
        this.mOrderList = mOrderList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.adapter_approval_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {

        holder.tv_WOId.setText(mOrderList.get(i).getSoNumber());
        holder.tv_ordertype.setText(mOrderList.get(i).getOrderType());
        holder.tv_custname.setText(mOrderList.get(i).getCustomerName());
        holder.tv_address.setText(mOrderList.get(i).getAddress());
        holder.tv_status.setText(mOrderList.get(i).getOrderStatusName());

    }

    @Override
    public int getItemCount() {
        return mOrderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_WOId;
        TextView tv_ordertype;
        TextView tv_custname;
        TextView tv_address;
        TextView tv_status;

        public MyViewHolder(View v) {
            super(v);
            tv_WOId = (TextView) v.findViewById(R.id.tv_WOId);
            tv_ordertype = (TextView) v.findViewById(R.id.tv_ordertype);
            tv_custname = (TextView) v.findViewById(R.id.tv_custname);
            tv_address = (TextView) v.findViewById(R.id.tv_address);
            tv_status = (TextView) v.findViewById(R.id.tv_wostatus);
        }
    }
}