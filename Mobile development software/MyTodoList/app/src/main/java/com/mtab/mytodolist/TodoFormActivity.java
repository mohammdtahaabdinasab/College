package com.mtab.mytodolist;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TodoFormActivity extends AppCompatActivity {

    public static final String EXTRA_TODO_ID = "todo_id";
    public static final String EXTRA_TODO_TITLE = "todo_title";
    public static final String EXTRA_TODO_DESCRIPTION = "todo_description";
    public static final String EXTRA_TODO_DATE = "todo_date";
    public static final int RESULT_TODO_ADDED = 101;
    public static final int RESULT_TODO_UPDATED = 102;

    private EditText titleEditText;
    private EditText descriptionEditText;
    private TextView dateTextView;
    private Button saveButton;
    private Button cancelButton;

    private DatabaseHelper dbHelper;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private int todoId = -1;
    private boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_todo_form);

            titleEditText = findViewById(R.id.edit_title);
            descriptionEditText = findViewById(R.id.edit_description);
            dateTextView = findViewById(R.id.text_date);
            saveButton = findViewById(R.id.button_save);
            cancelButton = findViewById(R.id.button_cancel);

            dbHelper = new DatabaseHelper(this);
            calendar = Calendar.getInstance();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            dateTextView.setText(dateFormat.format(calendar.getTime()));

            Intent intent = getIntent();
            if (intent.hasExtra(EXTRA_TODO_ID)) {
                isEditMode = true;
                todoId = intent.getIntExtra(EXTRA_TODO_ID, -1);
                
                titleEditText.setText(intent.getStringExtra(EXTRA_TODO_TITLE));
                descriptionEditText.setText(intent.getStringExtra(EXTRA_TODO_DESCRIPTION));
                
                String date = intent.getStringExtra(EXTRA_TODO_DATE);
                if (date != null && !date.isEmpty()) {
                    dateTextView.setText(date);
                }
                
                setTitle(R.string.edit_todo);
            } else {
                setTitle(R.string.add_todo);
            }

            dateTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDatePickerDialog();
                }
            });

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveTodo();
                }
            });

            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error initializing form", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void showDatePickerDialog() {
        try {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            calendar.set(Calendar.YEAR, year);
                            calendar.set(Calendar.MONTH, month);
                            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            dateTextView.setText(dateFormat.format(calendar.getTime()));
                        }
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            datePickerDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error showing date picker", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveTodo() {
        try {
            String title = titleEditText.getText().toString().trim();
            String description = descriptionEditText.getText().toString().trim();
            String date = dateTextView.getText().toString();

            if (title.isEmpty()) {
                titleEditText.setError(getString(R.string.empty_title_error));
                return;
            }

            Todo todo = new Todo(title, description, date);

            if (isEditMode && todoId != -1) {
                todo.setId(todoId);
                dbHelper.updateTodo(todo);
                
                Toast.makeText(this, R.string.todo_updated, Toast.LENGTH_SHORT).show();
                setResult(RESULT_TODO_UPDATED);
            } else {
                long id = dbHelper.insertTodo(todo);
                if (id != -1) {
                    Toast.makeText(this, R.string.todo_added, Toast.LENGTH_SHORT).show();
                    setResult(RESULT_TODO_ADDED);
                }
            }
            
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving todo", Toast.LENGTH_SHORT).show();
        }
    }
} 