package ntu_63134417.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Question> listQuestion = new ArrayList<>();
    private TextView textView_score, textView_time, textView_sentence, textView_question, textView_state;
    private Button btnOp1, btnOp2, btnOp3, btnOp4, btnNext;
    private int totalQuestions;
    private String correctAnser;
    private int scrore = 0;
    private CountDownTimer countDownTimer;
    private long time_60s = 60000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getID();

        addQuestionsToList();
        totalQuestions = listQuestion.size();
        randomQuestion();
        StartCountDown();

        btnOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btnOp1.getText().toString(), btnOp1);
            }
        });

        btnOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btnOp2.getText().toString(), btnOp2);
            }
        });

        btnOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btnOp3.getText().toString(), btnOp3);
            }
        });

        btnOp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btnOp4.getText().toString(), btnOp4);
            }
        });

//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                randomQuestion();
//            }
//        });
    }
    @SuppressLint("ResourceAsColor")
    private void checkAnswer(String selected, Button btn) {
        if(selected.equals(correctAnser)) {
            textView_state.setText("Chính xác !!!");
            textView_state.setTextColor(ContextCompat.getColor(this, R.color.green));
            scrore +=10;
            btn.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
            textView_score.setText(String.valueOf(scrore));

            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    textView_state.setText("");
                    randomQuestion();
                }
            }, 500);
        }
        else {
            textView_state.setText("Sai rồi !!!");
            textView_state.setTextColor(ContextCompat.getColor(this, R.color.red));
            btn.setBackgroundColor(ContextCompat.getColor(this, R.color.red));

            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    textView_state.setText("");
                    randomQuestion();
                }
            }, 500);
        }
    }

    private void randomQuestion() {
        if (listQuestion.isEmpty()) {
            return;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(listQuestion.size());

        Question randomQuestion = listQuestion.get(randomIndex);

        textView_sentence.setText(String.valueOf(totalQuestions - listQuestion.size() + 1));
        textView_question.setText(randomQuestion.getQuestion());
        btnOp1.setText(randomQuestion.getOptions().get(0));
        btnOp2.setText(randomQuestion.getOptions().get(1));
        btnOp3.setText(randomQuestion.getOptions().get(2));
        btnOp4.setText(randomQuestion.getOptions().get(3));
        correctAnser = randomQuestion.getCorrectAnswer();

        btnOp1.setBackgroundColor(ContextCompat.getColor(this, R.color.default_button_background));
        btnOp2.setBackgroundColor(ContextCompat.getColor(this, R.color.default_button_background));
        btnOp3.setBackgroundColor(ContextCompat.getColor(this, R.color.default_button_background));
        btnOp4.setBackgroundColor(ContextCompat.getColor(this, R.color.default_button_background));


        listQuestion.remove(randomIndex);
    }
    private void StartCountDown() {
        countDownTimer = new CountDownTimer(time_60s, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_60s = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                time_60s = 0;
                updateCountDownText();
            }
        }.start();
    }
    private void updateCountDownText() {
        int minutes = (int) (time_60s / 1000) / 60;
        int seconds = (int) (time_60s / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        textView_time.setText(timeLeftFormatted);
    }
    private void getID() {
        textView_state = findViewById(R.id.textView_state);
        textView_score = findViewById(R.id.textView_score);
        textView_time = findViewById(R.id.textView_time);
        textView_sentence = findViewById(R.id.textView_sentence);
        textView_question = findViewById(R.id.textView_question);
        btnOp1 = findViewById(R.id.btnOp1);
        btnOp2 = findViewById(R.id.btnOp2);
        btnOp3 = findViewById(R.id.btnOp3);
        btnOp4 = findViewById(R.id.btnOp4);
//        btnNext = findViewById(R.id.btnNext);
    }
    private void addQuestionsToList() {
        // Thêm các câu hỏi vào danh sách
        listQuestion.add(new Question("Gà và trứng, cái nào có trước?", Arrays.asList("Gà", "Trứng", "Cả hai cái đều có trước", "Cả hai cái đều không có trước"), "Trứng"));
        listQuestion.add(new Question("Nhà đen ở Việt Nam, nhà vàng ở Trung Quốc. Hỏi nhà trắng ở đâu?", Arrays.asList("Mỹ", "Trung Quốc", "Cam-pu-chia", "Canada"), "Mỹ"));
        listQuestion.add(new Question("Từ Đà Nẵng đến Lào bằng đường biển mất bao lâu?", Arrays.asList("1 tiếng", "5 tiếng", "7 tiếng", "Không đi được"), "Không đi được"));
        listQuestion.add(new Question("Lan là học sinh lớp 4H. Khi đi quanh trường, Lan thấy một cái ví, khi Lan rở ví ra thì thấy có rất nhiều tiền. Hỏi Lan giỏi nhất môn gì?", Arrays.asList("Toán học", "Văn học", "Tiếng Anh", "Đạo đức"), "Đạo đức"));
        listQuestion.add(new Question("Sở thú bị cháy, con gì chạy ra đầu tiên?", Arrays.asList("Con Hổ", "Con Voi", "Con Người", "Con Chim"), "Con Người"));
        listQuestion.add(new Question("Chồng người da đen, vợ người da trắng vừa sinh một đứa bé, răng của nó màu gì?", Arrays.asList("Đỏ", "Vàng", "Đen", "Trắng"), "Trắng"));
        listQuestion.add(new Question("Nếu n=k=u=i, n+3=u+i+6:2. Hỏi n,k,u,i=?", Arrays.asList("2", "3", "4", "5"), "3"));
        listQuestion.add(new Question("Cái gì của người con gái lúc nào cũng ẩm ướt?", Arrays.asList("Mắt", "Tay", "Chân", "Râu"), "Mắt"));
        listQuestion.add(new Question("Trên nhấp dưới giật là đang làm gì?", Arrays.asList("Chơi Bóng Bàn", "Trộm Cắp", "Câu Cá", "Đang Học"), "Câu Cá"));
        listQuestion.add(new Question("Con trai và đàn ong có điểm gì khác nhau?", Arrays.asList("Số Tuổi", "Chiều Cao", "Nơi ở", "Địa Vị"), "Nơi ở"));
        listQuestion.add(new Question("Con đường dài nhất là đường nào?", Arrays.asList("Đường Đi", "Đường Đèo", "Đường Đời", "Đường Đi Nước Ngoài"), "Đường Đời"));
        listQuestion.add(new Question("2 con vịt đi trước 2 con vịt, 2 con vịt đi sau 2 con vịt, 2 con vịt đi giữa 2 con vịt. Hỏi có mấy con vịt?", Arrays.asList("12 con vịt", "6 con vịt", "4 con vịt", "7 con vịt"), "4 con vịt"));
        listQuestion.add(new Question("Con gì đầu dê mình ốc?", Arrays.asList("Con Ốc", "Con Đường", "Con Mương", "Con Dốc"), "Con Dốc"));
        listQuestion.add(new Question("Cái gì của chồng mà vợ thích cầm nhất?", Arrays.asList("Tiền", "Sách", "Tay", "Nhẫn"), "Tiền"));
        listQuestion.add(new Question("Làm thế nào để không đụng phải ngón tay khi bạn đập búa vào một cái móng tay?", Arrays.asList("Cầm búa bằng cả 2 tay", "Cầm búa bằng tay trái", "Cầm búa bằng tay phải", "Cầm báu bằng chân"), "Cầm búa bằng cả 2 tay"));
        listQuestion.add(new Question("Có bao nhiêu chữ C trong câu sau: \"Cơm, canh, cá, tất cả em đều thích\"?", Arrays.asList("1 chữ", "2 chữ", "5 chữ", "4 chữ"), "1 chữ"));
        listQuestion.add(new Question("Cái gì luôn đi đến mà không bao giờ đến nơi?", Arrays.asList("Cơn gió", "Tình Yêu", "Ngày mai", "Không biết cái gì?"), "Ngày mai"));
        listQuestion.add(new Question("Bố mẹ có 6 người con trai, mỗi người con trai có một đứa em gái. Vậy gia đình đó có mấy người?", Arrays.asList("8", "9", "10", "11"), "9"));
        listQuestion.add(new Question("Một bức ảnh có ba thế hệ của một gia đình, trong đó có hai người cha, hai người con. Hỏi tấm ảnh này có ít nhất mấy người?", Arrays.asList("4 người", "3 người", "2 người", "1 người"),"3 người"));
        listQuestion.add(new Question("Con cua đỏ dài 7 cm chạy đua với con cua xanh dài 4 cm. Con nào về đích trước?", Arrays.asList("Cua đỏ", "Cua xanh", "Cả 2 con", "Không con nào"),"Cua xanh"));
    }


}