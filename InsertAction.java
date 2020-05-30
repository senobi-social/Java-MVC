package chapter23;

import bean.Members;
import dao.MembersDAO;
import tool.Action;
import javax.servlet.http.*;
import java.util.List;

public class InsertAction extends Action {

  public String execute (
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {


    // リクエストパラメータの取得
    Integer id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String gendet = request.getParameter("gender");


    // 追加の実行
    Members m = new Members();

    m.setId(id);
    m.setName(name);
    m.setGender(gender);

    // MembersDAOのinsert()メソッドを使う
    MembersDAO dao = new MembersDAO();
    dao.insert(m);

    // リクエスト属性の設定
    List<Members> list = dao.search("");
    request.setAttribute("list", list);

    return "list.jsp";

  }
}
