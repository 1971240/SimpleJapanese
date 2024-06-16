package com.example.easyjapanese;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    String[] hiragana = {"あ", "い", "う", "え", "お",
            "か", "き", "く", "け", "こ",
            "さ", "し", "す", "せ", "そ",
            "た", "ち", "つ", "て", "と",
            "な", "に", "ぬ", "ね", "の",
            "は", "ひ", "ふ", "へ", "ほ",
            "ま", "み", "む", "め", "も",
            "や", "ゆ", "よ",
            "ら", "り", "る", "れ", "ろ",
            "わ", "を", "ん"};

    String[] romaji = {"아(a)", "이(i)", "우(u)", "에(e)", "오(o)",
            "카(ka)", "키(ki)", "쿠(ku)", "케(ke)", "코(ko)",
            "사(sa)", "시(shi)", "스(su)", "세(se)", "소(so)",
            "타(ta)", "치(chi)", "츠(tsu)", "테(te)", "토(to)",
            "나(na)", "니(ni)", "누(nu)", "네(ne)", "노(no)",
            "하(ha)", "히(hi)", "후(hu)", "헤(he)", "호(ho)",
            "마(ma)", "미(mi)", "무(mu)", "메(me)", "모(mo)",
            "야(ya)", "유(yu)", "요(yo)",
            "라(ra)", "리(ri)", "루(ru)", "레(re)", "로(ro)",
            "와(wa)", "우(wo)", "응(n)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        TextView tvQuestion = findViewById(R.id.tvQuestion);
        Button btnOption1 = findViewById(R.id.btnOption1);
        Button btnOption2 = findViewById(R.id.btnOption2);
        Button btnOption3 = findViewById(R.id.btnOption3);
        Button btnReturn = findViewById(R.id.btnReturn);

        generateNewQuestion(tvQuestion, btnOption1, btnOption2, btnOption3);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void generateNewQuestion(TextView tvQuestion, Button btnOption1, Button btnOption2, Button btnOption3) {
        Random random = new Random();
        int correctIndex = random.nextInt(hiragana.length);

        tvQuestion.setText(hiragana[correctIndex]);

        int correctOption = random.nextInt(3);
        int[] options = new int[3];
        options[correctOption] = correctIndex;

        for (int i = 0; i < 3; i++) {
            if (i != correctOption) {
                int randomIndex;
                do {
                    randomIndex = random.nextInt(hiragana.length);
                } while (randomIndex == correctIndex || contains(options, randomIndex));
                options[i] = randomIndex;
            }
        }

        btnOption1.setText(romaji[options[0]]);
        btnOption2.setText(romaji[options[1]]);
        btnOption3.setText(romaji[options[2]]);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                checkAnswer(clickedButton.getText().toString(), romaji[correctIndex]);
                generateNewQuestion(tvQuestion, btnOption1, btnOption2, btnOption3);
            }
        };

        btnOption1.setOnClickListener(listener);
        btnOption2.setOnClickListener(listener);
        btnOption3.setOnClickListener(listener);
    }

    private boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    private void checkAnswer(String selectedAnswer, String correctAnswer) {
        if (selectedAnswer.equals(correctAnswer)) {
            Toast.makeText(this,"정답입니다!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"틀렸습니다! 정답은 "+correctAnswer+" 입니다.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}

