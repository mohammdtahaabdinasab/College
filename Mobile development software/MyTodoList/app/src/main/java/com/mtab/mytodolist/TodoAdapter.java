package com.mtab.mytodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TodoAdapter extends ArrayAdapter<Todo> {

    private Context mContext;
    private List<Todo> mTodos;

    public TodoAdapter(Context context, List<Todo> todos) {
        super(context, R.layout.todo_item, todos);
        this.mContext = context;
        this.mTodos = todos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            // Get the todo item for this position
            Todo todo = getItem(position);
            if (todo == null) {
                return convertView;
            }

            // Check if an existing view is being reused, otherwise inflate the view
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(R.layout.todo_item, parent, false);
                
                viewHolder.titleTextView = convertView.findViewById(R.id.text_title);
                viewHolder.dateTextView = convertView.findViewById(R.id.text_date);
                viewHolder.checkBox = convertView.findViewById(R.id.checkbox_completed);
                
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            // Populate the data into the template view using the data object
            viewHolder.titleTextView.setText(todo.getTitle());
            viewHolder.dateTextView.setText(todo.getDate());
            viewHolder.checkBox.setChecked(todo.isCompleted());
            
            // Set up checkbox click listener
            final Todo finalTodo = todo;
            viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        boolean isChecked = viewHolder.checkBox.isChecked();
                        finalTodo.setCompleted(isChecked);
                        
                        DatabaseHelper db = new DatabaseHelper(mContext);
                        db.updateTodo(finalTodo);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(mContext, "Error updating todo status", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return convertView;
        } catch (Exception e) {
            e.printStackTrace();
            return convertView != null ? convertView : new View(mContext);
        }
    }

    private static class ViewHolder {
        TextView titleTextView;
        TextView dateTextView;
        CheckBox checkBox;
    }
} 