package ntu_63134417.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Question> listQuestion = new ArrayList<>();
    private TextView textView_score, textView_time, textView_sentence, textView_question;
    Button btnOp1, btnOp2, btnOp3, btnOp4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addQuestionsToList();
    }
//    private void get
    private void addQuestionsToList() {
        // Thêm các câu hỏi vào danh sách
        listQuestion.add(new Question("Gà và trứng, cái nào có trước?", Arrays.asList("Gà", "Trứng", "Cả hai cái đều có trước", "Cả hai cái đều không có trước"), "Trứng"));
        listQuestion.add(new Question("Nhà đen ở Việt Nam, nhà vàng ở Trung Quốc. Hỏi nhà trắng ở đâu?", Arrays.asList("Mỹ", "Trung Quốc", "Cam-pu-chia", "Canada"), "Mỹ"));
        listQuestion.add(new Question("Từ Đà Nẵng đến Lào bằng đường biển mất bao lâu?", Arrays.asList("1 tiếng", "5 tiếng", "7 tiếng", "Không đi được"), "Không đi được"));
        listQuestion.add(new Question("Lan là học sinh lớp 4H. Khi đi quanh trường, Lan thấy một cái ví, khi Lan rở ví ra thì thấy có rất nhiều tiền. Hỏi Lan giỏi nhất môn gì?", Arrays.asList("Toán học", "Văn học", "Tiếng Anh", "Đạo đức"), "Đạo đức"));
        listQuestion.add(new Question("Sở thú bị cháy, con gì chạy ra đầu tiên?", Arrays.asList("Con Hổ", "Con Voi", "Con Người", "Con Chim"), "Con Người"));
        listQuestion.add(new Question("Chồng người da đen, vợ người da trắng vừa sinh một đứa bé, răng của nó màu gì?", Arrays.asList("Đỏ", "Vàng", "Đen", "Trắng"), "Trắng"));
        listQuestion.add(new Question("Nếu n=k=u=i, n+3=u+i+6:2. Hỏi n,k,u,i=?", Arrays.asList("2", "3", "4", "5"), "3"));
        listQuestion.add(new Question("Có một lần, nữ trộm cắp X người Anh bị giết, trong đó có ba người bị tình nghi: Người chồng của cô-Jasof. Chú của chồng cô- Peter ; vợ của chú ấy-Tehana: cô giúp việc Marry và chú quản gia Maicon. Những kí tự mà cô đã cố đẻ lại là một dãy số: 1;4;9;10;2. Cảnh sát đã biết ai là thủ phạm . Bạn có biết đó là ai không?", Arrays.asList("Jasof", "Peter", "Tehana", "Marry"), "Tehana"));
        listQuestion.add(new Question("Câu đố số 3: Trên nhấp dưới giật là đang làm gì?", Arrays.asList("Chơi Bóng Bàn", "Trộm Cắp", "Câu Cá", "Đang Học"), "Câu Cá"));
        listQuestion.add(new Question("Con trai và đàn ong có điểm gì khác nhau?", Arrays.asList("Số Tuổi", "Chiều Cao", "Nơi ở", "Địa Vị"), "Nơi ở"));
        listQuestion.add(new Question("Con đường dài nhất là đường nào?", Arrays.asList("Đường Đi", "Đường Đèo", "Đường Đời", "Đường Đi Nước Ngoài"), "Đường Đời"));
        listQuestion.add(new Question("2 con vịt đi trước 2 con vịt, 2 con vịt đi sau 2 con vịt, 2 con vịt đi giữa 2 con vịt. Hỏi có mấy con vịt?", Arrays.asList("12 con vịt", "6 con vịt", "4 con vịt", "7 con vịt"), "4 con vịt"));
        listQuestion.add(new Question("Con gì đầu dê mình ốc?", Arrays.asList("Con Ốc", "Con Đường", "Con Mương", "Con Dốc"), "Con Dốc"));
        listQuestion.add(new Question("Cái gì của chồng mà vợ thích cầm nhất?", Arrays.asList("Tiền", "Sách", "Tay", "Nhẫn"), "Tiền"));
        listQuestion.add(new Question("Làm thế nào để không đụng phải ngón tay khi bạn đập búa vào một cái móng tay?", Arrays.asList("Cầm búa bằng cả 2 tay", "Cầm búa bằng tay trái", "Cầm búa bằng tay phải", "Cầm báu bằng chân"), "Cầm búa bằng cả 2 tay"));
        listQuestion.add(new Question("Có bao nhiêu chữ C trong câu sau: \"Cơm, canh, cá, tất cả em đều thích\"?", Arrays.asList("1 chữ", "2 chữ", "5 chữ", "4 chữ"), "1 chữ"));
        listQuestion.add(new Question("Cái gì luôn đi đến mà không bao giờ đến nơi?", Arrays.asList("Cơn gió", "Tình Yêu", "Ngày mai", "Không biết cái gì?"), "Ngày mai"));
        listQuestion.add(new Question("Bố mẹ có 6 người con trai, mỗi người con trai có một đứa em gái. Vậy gia đình đó có mấy người?", Arrays.asList("8", "9", "10", "11"), "9"));
    }


}