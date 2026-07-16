package forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmServlet extends HttpServlet {
    // POSTメソッドのリクエスト受信時に実行されるメソッド
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // リクエスト・レスポンスの設定
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // JSPからのリクエストデータ取得
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone_number = request.getParameter("phone_number");

        // リクエストスコープにデータ保存
        request.setAttribute( "name", name );
        request.setAttribute( "email", email );
        request.setAttribute( "address", address );
        request.setAttribute( "phone_number", phone_number );

        // データが存在しない場合は空文字に置き換え
        name = Objects.toString(name, "");
        email = Objects.toString(email, "");
        address = Objects.toString(address, "");
        phone_number = Objects.toString(phone_number, "");

        // バリデーションNG時のメッセージを格納するリスト
        ArrayList<String> errorList = new ArrayList<String>();

        // お名前のバリデーション
        if( "".equals(name.trim()) ) { // 未入力
            // お名前が未入力の場合
            errorList.add("氏名を入力してください。");
        }

        // メールアドレスのバリデーション
        if( "".equals(email.trim()) ) { // 未入力
            errorList.add("メールアドレスを入力してください。");
        } 

        // お問い合わせ内容のバリデーション
        if( "".equals(address.trim()) ) { // 未入力
            errorList.add("住所を入力してください。");
        } 
        
        // お問い合わせ内容のバリデーション
        if( "".equals(phone_number.trim()) ) { // 未入力
            errorList.add("電話番号を入力してください。");
        } 

        // エラーリストが空かどうか
        if( !errorList.isEmpty() ) {
            // エラーがある場合はリストをリクエストスコープに登録
            request.setAttribute("errorList", errorList);
            
        } else {
       
      
        }

        // フォワードによる画面遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/confirmPage.jsp");
        dispatcher.forward(request, response);
    }
    

}