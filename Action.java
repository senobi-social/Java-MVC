package tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 抽象メソッドを含むので抽象クラスになる
public abstract class Action {

  // 抽象メソッドのexecute
  // サブクラスでオーバーライドして機能を実装するので
  // 戻り値はString型にしてフォワード先のURLを返す
  public abstract String execute (
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception;

}
