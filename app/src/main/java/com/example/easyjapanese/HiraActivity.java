package com.example.easyjapanese;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class HiraActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiragana);

        final GridView gv = findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID = {R.drawable.a, R.drawable.i,R.drawable.u,R.drawable.e,R.drawable.o,
                R.drawable.ka,R.drawable.ki,R.drawable.ku,R.drawable.ke,R.drawable.ko,
                R.drawable.sa,R.drawable.si,R.drawable.su,R.drawable.se,R.drawable.so,
                R.drawable.ta,R.drawable.chi,R.drawable.tsu,R.drawable.te,R.drawable.to,
                R.drawable.na,R.drawable.ni,R.drawable.nu,R.drawable.ne,R.drawable.no,
                R.drawable.ha,R.drawable.hi,R.drawable.hu,R.drawable.he,R.drawable.ho,
                R.drawable.ma,R.drawable.mi,R.drawable.mu,R.drawable.me,R.drawable.mo,
                R.drawable.ya,R.drawable.blank,R.drawable.yu,R.drawable.blank,R.drawable.yo,
                R.drawable.ra,R.drawable.ri,R.drawable.ru,R.drawable.re,R.drawable.ro,
                R.drawable.wa,R.drawable.blank,R.drawable.blank,R.drawable.blank,R.drawable.wo,
                R.drawable.n,R.drawable.blank,R.drawable.blank,R.drawable.blank,R.drawable.blank};

        int[] soundID = {R.raw.a, R.raw.i, R.raw.u, R.raw.e, R.raw.o,
                R.raw.ka, R.raw.ki, R.raw.ku, R.raw.ke, R.raw.ko,
                R.raw.sa, R.raw.si, R.raw.su, R.raw.se, R.raw.so,
                R.raw.ta, R.raw.chi, R.raw.tsu, R.raw.te, R.raw.to,
                R.raw.na, R.raw.ni, R.raw.nu, R.raw.ne, R.raw.no,
                R.raw.ha, R.raw.hi, R.raw.hu, R.raw.he, R.raw.ho,
                R.raw.ma, R.raw.mi, R.raw.mu, R.raw.me, R.raw.mo,
                R.raw.ya, 0, R.raw.yu, 0, R.raw.yo,
                R.raw.ra, R.raw.ri, R.raw.ru, R.raw.re, R.raw.ro,
                R.raw.wa, 0, 0, 0, R.raw.wo,
                R.raw.n, 0, 0, 0, 0};

        public MyGridAdapter(Context c) { context = c; }

        public int getCount() { return posterID.length; }

        public Object getItem(int position) { return null; }

        public long getItemId(int position) { return 0; }

        String[] Bighira = {"아기를 안고있는 어머니의 모습","치아 모양","우산","에어로빅을 추는 사람","오리",
                "점은 카메라의 셔터(ゝ), 그립에 힘을 써야하기에 힘 력(力)","열쇠(키)","쿠션의 모서리","왼편의 둥근 케잌을 십자 모양으로 자르는 모습","코끼리의 통통한 몸통 모습",
                "사과의 모습 윗부분은 꼭지, 아래는 사과의 테투리","낚시 바늘","스프링","세면대 윗부분은 수도꼭지, 아래는 세면대","소라",
                "타조의 길쭉한 목과 몸통","치타가 속도를 내기위해 웅크리고있음","부츠의 둥근 앞부분","테이프의 모서리와 둥근 구멍 부분","토끼의 귀와 머리 부분",
                "나비(나비의 무니는 꽤 복잡하게 생겼기에)","바구니의 측면 모서리와 전면 모서리 모양","오동통한 누에의 앞의 머리 부분과 뒷부분","그네를 타는 소녀 모양","노래의 음표 모양",
                "하마(ほ와 비교 시 하마는 -가 없어 줄무늬가 없음)","히틀러의 주먹코","훌라우프를 돌리는 사람","헤엄칠 때 손을 뒤로 젖히는 모습","호랑이(이마의 3개의 줄무늬)",
                "마라톤을 뛰는 사람(달릴 주 走 와 비슷함)","미로의 모습. 미로라 오른쪽에 길이 막혀 있음","무용을 하는 사람(리본 때문에 꼬리가 김)","메기 모양(메기의 수염과 꼬리 모양)","모자 모양(털 모 毛와 비슷함)",
                "야구하는 사람(왼편 직선은 배트, 오른편 곡선은 잡은 팔, 점은 날라오는 야구 공)","","유도하는 사람 모습","","요트 모양",
                "라디오(왼편 직선은 모서리, 둥근 모양은 스피커)","리본","캥거루가 서있는 모습","벌레 모양","로울러 모양(신발 つ 인데 바퀴 달린 신발)",
                "와하고 입벌리는 사람","","","","오징어 모습(오른쪽 큰 획은 오징어의 가장 큰 다리)",
                "응가하는 사람이 앉는 좌변기","","","",""};

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);
            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = View.inflate(HiraActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(HiraActivity.this);
                    ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(Bighira[pos]);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();

                    MediaPlayer mediaPlayer = MediaPlayer.create(context,soundID[pos]);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                }
            });
            return imageview;
        }
    }
}