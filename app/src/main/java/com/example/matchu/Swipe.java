package com.example.matchu;









import static android.content.ContentValues.TAG;







import androidx.annotation.NonNull;


import androidx.appcompat.app.AppCompatActivity;


import androidx.recyclerview.widget.DefaultItemAnimator;


import androidx.recyclerview.widget.DiffUtil;







import android.content.Intent;


import android.os.Bundle;


import android.util.Log;


import android.view.MenuItem;


import android.view.View;


import android.view.animation.LinearInterpolator;


import android.widget.TextView;


import android.widget.Toast;







import com.google.android.material.bottomnavigation.BottomNavigationView;


import com.yuyakaido.android.cardstackview.CardStackLayoutManager;


import com.yuyakaido.android.cardstackview.CardStackListener;


import com.yuyakaido.android.cardstackview.CardStackView;


import com.yuyakaido.android.cardstackview.Direction;


import com.yuyakaido.android.cardstackview.StackFrom;


import com.yuyakaido.android.cardstackview.SwipeableMethod;







import java.util.ArrayList;


import java.util.List;







public class Swipe extends AppCompatActivity {


    private CardStackLayoutManager manager;


    private SwipeAdapter adapter;


    BottomNavigationView nav;
    private int i = 0;



    List<College> collegeDB = Questionare.getCollegeDB();
    public static List<College> likedList = new ArrayList<>();




    @Override


    protected void onCreate(Bundle savedInstanceState) {







        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_swipe);


        nav = findViewById(R.id.bottomNavigationView);


        nav.setSelectedItemId(R.id.swipe);


        nav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {


            @Override


            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {


                    case R.id.calender:


                        startActivity(new Intent(getApplicationContext(), Calendar.class));


                        overridePendingTransition(0, 0);


                        return true;







                    case R.id.favorites:


                        startActivity(new Intent(getApplicationContext(), Favorites.class));


                        overridePendingTransition(0, 0);


                        return true;


                    case R.id.swipe:


                        return true;


                    case R.id.settings:


                        startActivity(new Intent(getApplicationContext(), Settings.class));


                        overridePendingTransition(0, 0);


                        return true;


                    case R.id.search:


                        startActivity(new Intent(getApplicationContext(), Serch.class));


                        overridePendingTransition(0, 0);


                        return true;












                }


                return false;


            }


        });







        CardStackView cardStackView = findViewById(R.id.card_stack_view);


        manager = new CardStackLayoutManager(this, new CardStackListener() {


            @Override


            public void onCardDragging(Direction direction, float ratio) {


                Log.d(TAG, "onCardDragging: d=" + direction.name() + " ratio=" + ratio);


            }







            @Override


            public void onCardSwiped(Direction direction) {

                Log.d(TAG, "onCardSwiped: p=" + manager.getTopPosition() + " d=" + direction);





                if (direction == Direction.Right){


                    Toast.makeText(Swipe.this, "Direction Right", Toast.LENGTH_SHORT).show();
                   likedList.add(collegeDB.get(i));

                }


                if (direction == Direction.Top){


                    Toast.makeText(Swipe.this, "Direction Top", Toast.LENGTH_SHORT).show();


                }


                if (direction == Direction.Left){


                    Toast.makeText(Swipe.this, "Direction Left", Toast.LENGTH_SHORT).show();


                }


                if (direction == Direction.Bottom){


                    Toast.makeText(Swipe.this, "Direction Bottom", Toast.LENGTH_SHORT).show();


                }

                i++;
               Log.i("poop", "hi "+ likedList);



            }







            @Override


            public void onCardRewound() {


                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());


            }







            @Override


            public void onCardCanceled() {


                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());


            }







            @Override


            public void onCardAppeared(View view, int position) {


                TextView tv = view.findViewById(R.id.collegeName);


                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());


            }







            @Override


            public void onCardDisappeared(View view, int position) {


                TextView tv = view.findViewById(R.id.collegeName);


                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());


            }







        });


        manager.setStackFrom(StackFrom.None);


        manager.setVisibleCount(3);


        manager.setTranslationInterval(8.0f);


        manager.setScaleInterval(0.95f);


        manager.setSwipeThreshold(0.3f);


        manager.setMaxDegree(20.0f);


        manager.setDirections(Direction.FREEDOM);


        manager.setCanScrollHorizontal(true);


        manager.setSwipeableMethod(SwipeableMethod.Manual);


        manager.setOverlayInterpolator(new LinearInterpolator());


        adapter = new SwipeAdapter(addList());


        cardStackView.setLayoutManager(manager);


        cardStackView.setAdapter(adapter);


        cardStackView.setItemAnimator(new DefaultItemAnimator());




    }


    private void paginate() {


        List<College> hi = adapter.getItems();


        List<College> by = new ArrayList<>(addList());


        CallBackSwipe callback = new CallBackSwipe(hi, by);


        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);


        adapter.setItems(by);


        hasil.dispatchUpdatesTo(adapter);


    }


    private List<College> addList() {


        return collegeDB;



    }







}

