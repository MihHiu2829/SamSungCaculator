package com.example.mytnh;

import static com.example.mytnh.m002_swap_text.SWAP_WORDS;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytnh.databinding.ActivityMainBinding;

public class MainActivity extends baseACT<ActivityMainBinding> {
    private String ACT = "Money change peace" ;

    private  int count = 0 ;
    private String left = "";
    private String primeer = "";
    private String  right = "";
    private String sumAll ="";
    private String sumRight ="";
    private int flag1 = 1 ,flagPrimeer = 1 ;
    private int rs = 0 ;

    @Override
    protected void initViews() {
        binding.bt0.setOnClickListener(v -> ClickNumber(v));
        binding.bt1.setOnClickListener(v -> ClickNumber(v));
        binding.bt2.setOnClickListener(v -> ClickNumber(v));
        binding.bt3.setOnClickListener(v -> ClickNumber(v));
        binding.bt4.setOnClickListener(v -> ClickNumber(v));
        binding.bt5.setOnClickListener(v -> ClickNumber(v));
        binding.bt6.setOnClickListener(v -> ClickNumber(v));
        binding.bt7.setOnClickListener(v -> ClickNumber(v));
        binding.bt8.setOnClickListener(v -> ClickNumber(v));
        binding.bt9.setOnClickListener(v -> ClickNumber(v));
        binding.btClear.setOnClickListener(v -> ClearNumber(v));
        binding.btDiv.setOnClickListener(v -> doCalcNumber(v));
        binding.btSub.setOnClickListener(v -> doCalcNumber(v));
        binding.btPlus.setOnClickListener(v -> doCalcNumber(v));
        binding.btMulti.setOnClickListener(v -> doCalcNumber(v));
        binding.btEqual.setOnClickListener(v -> calc(v));
    }

    @Override
    protected ActivityMainBinding initViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    private void calc(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        left ="";
        right ="";
        primeer ="" ;
        binding.tvLeft.setText(left);
        binding.tvRight.setText(right);
        binding.tvBetween.setText(primeer);
        binding.tvShowCalc.setText(" ");
        sumRight ="" ;
        String gs = rs+"";
        left = gs ;
        binding.tvCalc.setText(gs);
        flagPrimeer = 0 ;
    }

    private void doCalcNumber(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        String tmp = v.getContentDescription().toString() ;
        if(flagPrimeer == 0)
        {
            binding.tvCalc.setText(" ");
        }
        if(tmp.equals(binding.btPlus.getContentDescription())){

            left+="  ";
            primeer+="+" ;
            binding.tvBetween.setText(primeer);
            binding.tvLeft.setText(left);
            flag1 = 0 ;
        }
        if(tmp.equals(binding.btSub.getContentDescription())){

            left+="  ";
            primeer+="-" ;
            binding.tvBetween.setText(primeer);
            binding.tvLeft.setText(left);
            flag1 = 0 ;
        }
        if(tmp.equals(binding.btDiv.getContentDescription())){

            left+="  ";
            primeer+="÷" ;
            binding.tvBetween.setText(primeer);
            binding.tvLeft.setText(left);
            flag1 = 0 ;
        }
        if(tmp.equals(binding.btMulti.getContentDescription())){

            left+="  ";
            primeer+="x" ;
            binding.tvBetween.setText(primeer);
            binding.tvLeft.setText(left);
            flag1 = 0 ;
        }
    }

    private void ClearNumber(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));

        left ="";
        right ="";
        primeer ="" ;
        binding.tvLeft.setText(left);
        binding.tvRight.setText(right);
        binding.tvBetween.setText(primeer);
        binding.tvShowCalc.setText(" ");
        flag1 = 1 ;
        rs = 0 ;
        sumRight ="";
        binding.tvCalc.setText(" ");
        count++  ;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    count = 0  ;
            }
        }, 3000) ;

        if(count == 6 )
            Toast.makeText(this, "Click one more to open setting", Toast.LENGTH_SHORT).show();
            if(count == 7)
            {
//                gotoM002();
                gotoDialog() ;
            }
    }

    private void gotoDialog() {
        Dialog dialog = new Dialog(this)  ;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_show);

        Window window = dialog.getWindow() ;
        if(window == null) return ;

        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        WindowManager.LayoutParams windowAbbtributes = window.getAttributes() ;
        windowAbbtributes.gravity = Gravity.CENTER ;
        dialog.setCancelable(false);

        Button bt_Enter = dialog.findViewById(R.id.bt_enter2) ;
        bt_Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edt_wds = dialog.findViewById(R.id.edt_wds) ;
                String tmp = edt_wds.getText().toString() ;
                ACT = tmp ;
                dialog.dismiss();
            }
        });

        Button bt_cancel = dialog.findViewById(R.id.bt_cancel2) ;
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }



    private void gotoM002() {
            Intent intent =  new Intent() ;
            intent.setClass(this,m002_swap_text.class);
            startActivity(intent);
    }

    private void ClickNumber(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        String tmp =  v.getContentDescription().toString() ;
        if(flag1 == 1){

            left = left+tmp ;
            binding.tvLeft.setText(left);
        }else{
            left+="  " ;
            primeer+="  ";
            right+=tmp ;
            binding.tvLeft.setText(left);
            binding.tvRight.setText(right);
            binding.tvBetween.setText(primeer);
            gotoAct(tmp);
        }
    }

    private void gotoAct(String tmp) {
        sumAll = left.trim()+primeer.trim()+right.trim() ;
        if(sumAll.equals("1+1"))
        {
//             sumCalc();
            binding.tvShowCalc.setText(ACT);
            rs = 2 ;
            return ;
        }
        String a = left.trim();
        sumRight += tmp ;
        String b = sumRight ;
        int rss = 0      ;
        String calc = primeer.trim() ;
        int n1 = Integer.parseInt(a);
        int n2 = Integer.parseInt(b);
        if(calc.equals("+"))
        {
            rss = n1 + n2;
        }else if (calc.equals("-"))
        {
            rss = n1 - n2;
        }else if (calc.equals("x"))
        {
            rss =( n1 * n2) ;
        }else if (calc.equals("÷")){
            if(n2 == 0 )
            {
                Toast.makeText(this, "giống như mối quan hệ của bạn và crush bạn,không xác định", Toast.LENGTH_SHORT).show();
                return ;
            }
            rss =( n1 / n2 );
        }
        String calcc = rss+"" ;
        binding.tvShowCalc.setText(calcc);
        rs = rss ;
    }

    private void sumCalc() {
        Intent intent = getIntent() ;
        String tmp = intent.getStringExtra(SWAP_WORDS) ;
        if(tmp == null ) binding.tvShowCalc.setText("2");
       else binding.tvShowCalc.setText(tmp);
    }


}