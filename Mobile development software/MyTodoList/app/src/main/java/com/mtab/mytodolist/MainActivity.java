package com.mtab.mytodolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView emptyView;
    private FloatingActionButton fab;
    private List<Todo> todoList;
    private TodoAdapter adapter;
    private DatabaseHelper dbHelper;

    private static final int REQUEST_ADD_TODO = 1;
    private static final int REQUEST_EDIT_TODO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup toolbar
        try {
            Toolbar toolbar = findViewById(R.id.toolbar);
            if (toolbar != null) {
                setSupportActionBar(toolbar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize UI components
        listView = findViewById(R.id.list_view);
        fab = findViewById(R.id.fab_add);
        try {
            emptyView = findViewById(R.id.empty_view);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize data
        dbHelper = new DatabaseHelper(this);
        todoList = new ArrayList<>();
        adapter = new TodoAdapter(this, todoList);
        listView.setAdapter(adapter);

        // Set empty view if available
        if (emptyView != null) {
            listView.setEmptyView(emptyView);
        }

        // Check if first run and add sample data
        checkFirstRun();

        // Load todos from database
        loadTodos();

        // Register for context menu
        registerForContextMenu(listView);

        // FAB click listener
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TodoFormActivity.class);
                startActivityForResult(intent, REQUEST_ADD_TODO);
            }
        });

        // Item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < todoList.size()) {
                    Todo selectedTodo = todoList.get(position);

                    Intent intent = new Intent(MainActivity.this, TodoFormActivity.class);
                    intent.putExtra(TodoFormActivity.EXTRA_TODO_ID, selectedTodo.getId());
                    intent.putExtra(TodoFormActivity.EXTRA_TODO_TITLE, selectedTodo.getTitle());
                    intent.putExtra(TodoFormActivity.EXTRA_TODO_DESCRIPTION, selectedTodo.getDescription());
                    intent.putExtra(TodoFormActivity.EXTRA_TODO_DATE, selectedTodo.getDate());
                    startActivityForResult(intent, REQUEST_EDIT_TODO);
                }
            }
        });
    }

    private void checkFirstRun() {
        String PREF_NAME = "MyTodoPrefs";
        String KEY_FIRST_RUN = "isFirstRun";
        
        android.content.SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        boolean isFirstRun = prefs.getBoolean(KEY_FIRST_RUN, true);
        
        if (isFirstRun) {
            addSampleData();
            
            android.content.SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(KEY_FIRST_RUN, false);
            editor.apply();
        }
    }
    
    private void addSampleData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String today = dateFormat.format(Calendar.getInstance().getTime());
        
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_YEAR, 1);
        String tomorrowStr = dateFormat.format(tomorrow.getTime());
        
        Calendar afterTomorrow = Calendar.getInstance();
        afterTomorrow.add(Calendar.DAY_OF_YEAR, 2);
        String afterTomorrowStr = dateFormat.format(afterTomorrow.getTime());
        
        dbHelper.insertTodo(new Todo("ارائه پروژه اندروید", "آماده کردن پروژه برای دمو در کلاس", today));
        dbHelper.insertTodo(new Todo("خرید مواد غذایی", "نان، شیر، تخم مرغ، میوه", tomorrowStr));
        dbHelper.insertTodo(new Todo("مطالعه فصل 5 کتاب", "خواندن و یادداشت‌برداری از فصل 5 کتاب برنامه‌نویسی اندروید", afterTomorrowStr));
    }

    private void loadTodos() {
        try {
            todoList.clear();
            todoList.addAll(dbHelper.getAllTodos());
            adapter.notifyDataSetChanged();
            
            // Show or hide empty view
            if (emptyView != null) {
                if (todoList.isEmpty()) {
                    emptyView.setVisibility(View.VISIBLE);
                } else {
                    emptyView.setVisibility(View.GONE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error loading data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sort_title) {
            Collections.sort(todoList, new Comparator<Todo>() {
                @Override
                public int compare(Todo t1, Todo t2) {
                    return t1.getTitle().compareToIgnoreCase(t2.getTitle());
                }
            });
            adapter.notifyDataSetChanged();
            return true;
        } else if (id == R.id.action_sort_date) {
            Collections.sort(todoList, new Comparator<Todo>() {
                @Override
                public int compare(Todo t1, Todo t2) {
                    return t1.getDate().compareTo(t2.getDate());
                }
            });
            adapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        
        if (v.getId() == R.id.list_view) {
            getMenuInflater().inflate(R.menu.menu_context, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        try {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            int position = info.position;
            
            if (position < todoList.size()) {
                Todo selectedTodo = todoList.get(position);
                int id = item.getItemId();

                if (id == R.id.action_edit) {
                    Intent intent = new Intent(MainActivity.this, TodoFormActivity.class);
                    intent.putExtra(TodoFormActivity.EXTRA_TODO_ID, selectedTodo.getId());
                    intent.putExtra(TodoFormActivity.EXTRA_TODO_TITLE, selectedTodo.getTitle());
                    intent.putExtra(TodoFormActivity.EXTRA_TODO_DESCRIPTION, selectedTodo.getDescription());
                    intent.putExtra(TodoFormActivity.EXTRA_TODO_DATE, selectedTodo.getDate());
                    startActivityForResult(intent, REQUEST_EDIT_TODO);
                    return true;
                } else if (id == R.id.action_delete) {
                    dbHelper.deleteTodo(selectedTodo.getId());
                    todoList.remove(position);
                    adapter.notifyDataSetChanged();
                    
                    // Check if list is empty after deletion
                    if (emptyView != null && todoList.isEmpty()) {
                        emptyView.setVisibility(View.VISIBLE);
                    }
                    
                    Toast.makeText(this, R.string.todo_deleted, Toast.LENGTH_SHORT).show();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error performing action", Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ADD_TODO && resultCode == TodoFormActivity.RESULT_TODO_ADDED) {
            loadTodos();
        } else if (requestCode == REQUEST_EDIT_TODO && resultCode == TodoFormActivity.RESULT_TODO_UPDATED) {
            loadTodos();
        }
    }
}