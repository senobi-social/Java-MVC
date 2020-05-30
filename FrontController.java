package tool;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

// Search.actionのようなURLを開くと、フロントコントローラが実行される
@WebServlet(urlPatterns={"*.action"})
public class FrontController extends HttpServlet {

  public void doPost (
    HttpServletRequest request, HttpServletResponse response
  ) throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    try {

      // パスの取得
      // フロントコントローラが呼び出されたパスを取得する
      // subStringで先頭の１文字を消す
      String path = request.getServletPath().substring(1);

      // パスの加工をする
      // .aをAに/を.にそれぞれ変換する
      String name = path.replace(".a", "A").replace('/', '.');

      // ここまでの処理によってパスをパッケージ名.クラス名に加工できる

      // アクションの生成
      Action action = (Action)Class.forName(name).newInstance();


      // アクションの実行
      // 各アクションはフォワード先のURLを返すので、戻り値をurlに取得する
      String url = action.execute(request, response);

      // フォワードの実行
      // urlで取得したフォーワード先を設定
      // 指定されたフォワード先にフォワードする
      request.getRequestDispatcher(url).
        forward(request, response);


    } catch (Exception e) {

      e.printStackTrace(out);

    }
  }

  public void doGet (
    HttpServletRequest request, HttpServletResponse response
  ) throws ServletException, IOException {

    doPost(request, response);

  }
}
