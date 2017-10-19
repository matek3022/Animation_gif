package company.matek3022.animation_gif;

import android.support.transition.Scene;
import android.support.transition.TransitionManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.InputStream;

import company.matek3022.animation_gif.transition.RotateTransition;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager ll = new LinearLayoutManager(this);
        rv.setLayoutManager(ll);
        rv.setAdapter(new RVAdapter());
//        MovieGifView movieGifView = (MovieGifView) findViewById(R.id.gif);
//        movieGifView.setGifResource(R.drawable.gif);
//        findViewById(R.id.resize).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    class RVAdapter extends RecyclerView.Adapter<RVAdapter.Holder> {


        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            return new Holder(v);
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.text.setText("Position " + position);
        }

        @Override
        public int getItemCount() {
            return 40;
        }

        @Override
        public void onViewAttachedToWindow(Holder holder) {
            super.onViewAttachedToWindow(holder);
            ViewGroup sceneRoot = holder.sceneContainer;

            // You can also inflate a generate a Scene from a layout resource file.
            final Scene scene = Scene.getSceneForLayout(sceneRoot, R.layout.scene_second, MainActivity.this);

            RotateTransition rotateTransition = new RotateTransition();

            // уставим свою длительность анимации
            rotateTransition.setDuration(1000);
            TransitionManager.go(scene, rotateTransition);
        }

        @Override
        public void onViewDetachedFromWindow(Holder holder) {
            super.onViewDetachedFromWindow(holder);
            ViewGroup sceneRoot = holder.sceneContainer;

            // You can also inflate a generate a Scene from a layout resource file.
            final Scene scene = Scene.getSceneForLayout(sceneRoot, R.layout.scene_first, MainActivity.this);

            RotateTransition rotateTransition = new RotateTransition();

            // уставим свою длительность анимации
            rotateTransition.setDuration(1000);
            TransitionManager.go(scene, rotateTransition);
        }

        class Holder extends RecyclerView.ViewHolder {

            TextView text;
            RelativeLayout sceneContainer;

            public Holder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.text);
                sceneContainer = (RelativeLayout) itemView.findViewById(R.id.sceneContainer);
            }
        }
    }
}
