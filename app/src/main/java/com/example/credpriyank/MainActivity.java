
package com.example.credpriyank;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    LinearLayout txt_help_gest0, txt_help_gest1,txt_help_gest2;
    String correct_answers[] ={"Tiger", "Lotus", "New Delhi"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_help_gest0 = (LinearLayout) findViewById(R.id.txt_help_gest0);
        txt_help_gest1 = (LinearLayout) findViewById(R.id.txt_help_gest1);
        txt_help_gest2 = (LinearLayout) findViewById(R.id.txt_help_gest2);

        txt_help_gest0.setVisibility(View.GONE);
        txt_help_gest1.setVisibility(View.GONE);
        txt_help_gest2.setVisibility(View.GONE);

    }

    /**
     * onClick handler
     */

    public void toggle_contents(View v) {
        TextView t = (TextView)findViewById(R.id.bottom_bar);
        if (v.getId() == R.id.help_title_gest0) {
            if (!txt_help_gest0.isShown()) {
                t.setText(R.string.bottom_bar_val_1);
            }
            change_visibility_of_clicked_view(txt_help_gest0);
            change_visibility_of_other_views(txt_help_gest1,txt_help_gest2);
        } else if (v.getId() == R.id.help_title_gest1) {
            if (!txt_help_gest1.isShown()) {
                t.setText(R.string.bottom_bar_val_2);
            }
            change_visibility_of_clicked_view(txt_help_gest1);
            change_visibility_of_other_views(txt_help_gest0,txt_help_gest2);
        } else if (v.getId() == R.id.help_title_gest2) {
            if (!txt_help_gest2.isShown()) {
                t.setText(R.string.bottom_bar_val_3);
            }
            change_visibility_of_clicked_view(txt_help_gest2);
            change_visibility_of_other_views(txt_help_gest0,txt_help_gest1);
        }
        check_if_all_closed(t);


    }
    private void check_if_all_closed(TextView t){
        if (!txt_help_gest0.isShown() && !txt_help_gest1.isShown() && !txt_help_gest2.isShown()){
            t.setText(R.string.bottom_panel_default_info);
        }
    }
    private void change_visibility_of_clicked_view(View v){
        if (v.isShown()) {
            Fx.slide_up(this, v);
        }
        else{
            Fx.slide_down(this, v);
        }
    }

    private void change_visibility_of_other_views(View v1, View v2) {
        View v[] = {v1,v2};
        for (int i=0;i<v.length;i++){
            if (v[i].isShown()) {
                Fx.slide_up(this, v[i]);
            }
        }
    }

    public void check_answer(View v){
        TextView t = (TextView)findViewById(R.id.bottom_bar);
        Button b = (Button)v;
        String answer = b.getText().toString();
        boolean correct = false;
        for (int i=0;i<correct_answers.length;i++){
            if(correct_answers[i].equalsIgnoreCase(answer)){
                correct = true;
                break;
            }
        }
        if (correct){
            t.setText("Correct Answer");
        }
        else{
            t.setText("Incorrect Answer");
        }
    }
}
