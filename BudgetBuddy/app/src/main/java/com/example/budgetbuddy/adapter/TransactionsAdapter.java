package com.example.budgetbuddy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.budgetbuddy.R;
import com.example.budgetbuddy.model.Transaction;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder> {

    private List<Transaction> transactions;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd", Locale.getDefault());

    public TransactionsAdapter(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);
        
        holder.icon.setImageResource(transaction.getIconResId());
        holder.title.setText(transaction.getTitle());
        holder.category.setText(transaction.getCategory());
        
        // Format amount with proper color (red for expenses)
        String amountText = String.format(Locale.getDefault(), "$%.2f", Math.abs(transaction.getAmount()));
        holder.amount.setText(amountText);
        holder.amount.setTextColor(transaction.getAmount() < 0 ? 
            holder.itemView.getContext().getResources().getColor(R.color.expenseRed) :
            holder.itemView.getContext().getResources().getColor(R.color.incomeGreen));
            
        // Format date
        String dateText = dateFormat.format(transaction.getDate());
        holder.date.setText(dateText);
    }

    @Override
    public int getItemCount() {
        return transactions != null ? transactions.size() : 0;
    }

    public void updateTransactions(List<Transaction> newTransactions) {
        this.transactions = newTransactions;
        notifyDataSetChanged();
    }

    public static class TransactionViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;
        TextView category;
        TextView amount;
        TextView date;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.transaction_icon);
            title = itemView.findViewById(R.id.transaction_title);
            category = itemView.findViewById(R.id.transaction_category);
            amount = itemView.findViewById(R.id.transaction_amount);
            date = itemView.findViewById(R.id.transaction_date);
        }
    }
}