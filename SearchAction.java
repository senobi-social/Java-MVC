package chapter23;

import bean.Members;
import dao.MembersDAO;
import tool.Action;
import javax.servlet.http.*;
import java.util.List;

public class SearchAction extends Action {

  public String execute (
    HttpServletRequest request, HttpServletResponse resonse
  ) throws Exception {


    // リクエストパラメータからkeywordを取得
    String keyword = request.getParameter("keyword");

    // 検索の実行
    // MembersDAOのsearch()を使用する
    MembersDAO dao = new MembersDAO();
    List<Members> list = dao.search(keyword);

    // 検索の実行結果をリクエスト属性に設定する
    request.setAttribute("list", list);

    // 各アクションではフォワード先のURLを返す
    return "list.jsp";

  }
}
