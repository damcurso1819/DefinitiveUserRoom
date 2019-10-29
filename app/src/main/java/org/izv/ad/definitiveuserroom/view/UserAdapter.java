package org.izv.ad.definitiveuserroom.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.izv.ad.definitiveuserroom.R;
import org.izv.ad.definitiveuserroom.entity.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private LayoutInflater inflater;
    private List<User> userList;
    private int contador = 0;

    public UserAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v("xyzyx", "onCreateViewHolder: " + contador);
        contador++;
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        Log.v("xyzyx", "onBindViewHolder: " + contador);
        if (userList != null) {
            User current = userList.get(position);
            holder.tvItem.setText(current.toString());
        } else {
            holder.tvItem.setText("No user available");
        }
    }

    @Override
    public int getItemCount() {
        Log.v("xyzyx", "getItemCount: " + contador);
        int elementos = 0;
        if(userList != null) {
            elementos = userList.size();
        }
        return elementos;
    }

    public void setUsers(List<User> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvItem;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
        }
    }
}
