/*------------------------------------------------------------------------------
 * 演習番号：[仕様書演習]
 * クラス名：[ErrorMsgConst]
 * 作成日  ：[2019/06/21]
 * 作成者  ：[K.Ogawa/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *------------------------------------------------------------------------------
 */
package TS_Net.model.constant;

/**
 * エラーメッセージを定義する定数クラス。
 * <p>
 * エラーメッセージを定義する。
 * </p>
 * @author K.Ogawa/SYS 2019/06/21
 */
public class ErrorMsgConst {

    /** フォームに未入力項目がある場合のエラーメッセージ */
    public static final String FORM_ERROR0001 = "証券番号または事故受付番号のどちらか一方を入力してください。";
    public static final String FORM_ERROR0002 = "未入力の項目があります。入力内容をご確認ください。";
    public static final String FORM_ERROR0003 = "半角数字で入力してください。";
    public static final String FORM_ERROR0004 = "入力された印刷連番は存在しません。";
    public static final String FORM_ERROR0005 = "入力された印刷連番は計上済みです。";
    public static final String FORM_ERROR0006 = "入力された証券番号は存在しません。";
    public static final String FORM_ERROR0007 = "入力された証券番号は解約済みです。";
    public static final String FORM_ERROR0008 = "IDまたはパスワードに誤りがあります。";
    public static final String FORM_ERROR0009 = "IDまたはパスワードが未入力です。";
    public static final String FORM_ERROR0010 = "入力された事故受付番号は存在しません。";
    public static final String FORM_ERROR0011 = "入力された事故受付番号は処理済みです。";
    public static final String FORM_ERROR0012 = "入力された証券番号は処理済みです。";
    public static final String FORM_ERROR0013 = "カナと書かれたフォームには全角カナで入力してください。";
    public static final String FORM_ERROR0014 = "入力された保険期間始期日は適切ではありません。";
    public static final String FORM_ERROR0015 = "入力された保険期間満期日は適切ではありません。";
    public static final String FORM_ERROR0016 = "入力された生年月日は適切ではありません。";
    public static final String FORM_ERROR0017 = "入力した日付は保険契約期間外です。";
    public static final String FORM_ERROR0018 = "未入力の項目があります。証券番号または事故受け付け番号を入力してください。";
    public static final String FORM_ERROR0019 = "被保険者・被害者の過失割合の合計は100になるように入力してください。";
    public static final String FORM_ERROR0020 = "各損害額は1000円単位で入力して下さい。";
    public static final String FORM_ERROR0021 = "過失割合は半角数字で入力してください。";
    public static final String FORM_ERROR0022 = "損害額は半角数字で入力してください。";

    /** システムエラーが発生した場合のエラーメッセージ */
    public static final String SYSTEM_ERROR = "システムエラーが発生しました。管理者に問い合わせてください。";

    /** セッションが無効になった場合のエラーメッセージ */
    public static final String SESSION_ERROR = "セッションが無効となりました。手続きをやり直してください。";
}
