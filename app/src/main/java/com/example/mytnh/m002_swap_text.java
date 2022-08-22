package com.example.mytnh;

import android.content.Intent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.mytnh.databinding.M002SwapTextBinding;

public class m002_swap_text extends baseACT<M002SwapTextBinding> {
    public static final String SWAP_WORDS = "SWAP_WORDS";
        int flag = 0 ;
    @Override
    protected void initViews() {
        binding.btEnter.setOnClickListener(v -> gotoMain(v));
        binding.btCancel.setOnClickListener(v -> gotoMain01(v));
    }

    private void gotoMain01(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(this,androidx.appcompat.R.anim.abc_fade_in));
                onBackPressed();
    }


    private void gotoMain(View v) {

                v.startAnimation(AnimationUtils.loadAnimation(this,androidx.appcompat.R.anim.abc_fade_in));
        String words = binding.edtWords.getText().toString()  ;
        if(words.equals(""))
        {
            Toast.makeText(this, "Type words then click enter", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent() ;
            intent.setClass(this, MainActivity.class) ;
            intent.putExtra(SWAP_WORDS,words) ;
            startActivity(intent);
            onBackPressed();
        }}

    @Override
    protected M002SwapTextBinding initViewBinding() {
        return M002SwapTextBinding.inflate(getLayoutInflater());
    }
}
