package TS_Net.model.datacheck;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.data.ContractInfo;

/**
 * チェックメソッド。
 * <p>
 * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
 * チェック結果がOKであれば、null値を返却する。
 * </p>
 * @param ci 契約情報
 * @return ErrorMsgConst.FORM_ERROR0002 フォームに未入力項目がある場合のエラーメッセージ
 * @return null null値
 */
public class TextTypeCheker {

    /*
     * 半角数字のはずが、全角で入力されている（各データクラス）
     * 全角カナ→半角になっている（契約情報）
     * 半角英数→全角（契約情報）
     */

    /**
     * 半角英数字チェックメソッド（契約情報）。
     * <p>
     * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
     * チェック結果がOKであれば、null値を返却する。
     * </p>
     * @param contractInfo 契約情報オブジェクト
     * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
     * @return null null値
     */
    public String textHalfwidthCheck(ContractInfo ci) {
        //正規表現(半角英数字)
        final String HAS_HALF_ALPHANUMERIC = "^[0-9a-zA-Z]+$";

        if(!(ci.getPostcode().matches(HAS_HALF_ALPHANUMERIC))) {
            return ErrorMsgConst.FORM_ERROR0003;
        }else if(!(ci.getTelephoneNo().matches(HAS_HALF_ALPHANUMERIC))) {
            return ErrorMsgConst.FORM_ERROR0003;
        }else if(!(ci.getMobilephoneNo().matches(HAS_HALF_ALPHANUMERIC))) {
            return ErrorMsgConst.FORM_ERROR0003;
        }else if(!(ci.getFaxNo().matches(HAS_HALF_ALPHANUMERIC))) {
            return ErrorMsgConst.FORM_ERROR0003;
        }else {
            return null;
        }
    }

    /**
     * 半角英数字チェックメソッド（補償情報）。
     * <p>
     * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
     * チェック結果がOKであれば、null値を返却する。
     * </p>
     * @param compensation 補償情報オブジェクト
     * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
     * @return null null値
     */
    public String textHalfwidthCheck(Integer vehiclePrice) {

        String value = String.valueOf(vehiclePrice);

        int len = value.length();
        byte[] bytes = value.getBytes();

        if( len != bytes.length) {
            return ErrorMsgConst.FORM_ERROR0014;
        }else {
            return null;
        }
    }

    /**
     * 半角英数字チェックメソッド（事故受付情報）。
     * <p>
     * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
     * チェック結果がOKであれば、null値を返却する。
     * </p>
     * @param accidentReception 事故受付情報オブジェクト
     * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
     * @return null null値
     */
    public String digitCheck(String str) {


          //検証結果を格納する変数
          boolean result = true;

          //一文字ずつ先頭から確認する。for文は文字数分繰り返す
          for(int i = 0; i < str.length(); i++) {

            //i文字めの文字についてCharacter.isDigitメソッドで判定する
            if(Character.isDigit(str.charAt(i))) {

              //数字の場合は次の文字の判定へ
              continue;

            }else {

              //数字でない場合は検証結果をfalseに上書きする
              result =false;
              break;
            }
          }


        if(result == false) {
            return ErrorMsgConst.FORM_ERROR0003;
        }else {
            return null;
        }
    }

    /**
     * 全角カナチェックメソッド（契約情報）。
     * <p>
     * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
     * チェック結果がOKであれば、null値を返却する。
     * </p>
     * @param contractInfo 契約情報オブジェクト
     * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
     * @return null null値
     */
    public String textFullwidthCheck(ContractInfo ci) {
        //全て全角カナかどうか
        final String IS_FULL_KANA = "^[\\u30A0-\\u30FF]+$";

        if(!(ci.getNameKana1().matches(IS_FULL_KANA))) {
            return ErrorMsgConst.FORM_ERROR0013;
        }else if(!(ci.getNameKana2().matches(IS_FULL_KANA))) {
            return ErrorMsgConst.FORM_ERROR0013;
        }else if(!(ci.getAddressKana1().matches(IS_FULL_KANA))) {
            return ErrorMsgConst.FORM_ERROR0013;
        }else if(!(ci.getAddressKana2().matches(IS_FULL_KANA))) {
            return ErrorMsgConst.FORM_ERROR0013;
        }else {
            return null;
        }
    }


       /**
     * 全角カナチェックメソッド（契約情報）。
     * <p>
     * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
     * チェック結果がOKであれば、null値を返却する。
     * </p>
     * @param contractInfo 契約情報オブジェクト
     * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
     * @return null null値
     */
    public String textFullwidthCheck(String str) {
        //全て全角カナかどうか
        final String IS_FULL_KANA = "^[\\u30A0-\\u30FF]+$";

        if(!(str.matches(IS_FULL_KANA))) {
            return ErrorMsgConst.FORM_ERROR0013;

        }else {
            return null;
        }
    }

//    /**
//     * 半角英数字チェックメソッド（番号系）。
//     * <p>
//     * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
//     * チェック結果がOKであれば、null値を返却する。
//     * </p>
//     * @param contractInfo 契約情報オブジェクト
//     * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
//     * @return null null値
//     */
//    public String textHalfwidthCheck(String str) {
//        final String HAS_HALF_ALPHANUMERIC = "^[0-9a-zA-Z]+$";
//
//        if(!(str.matches(HAS_HALF_ALPHANUMERIC))) {
//            return ErrorMsgConst.FORM_ERROR0003;
//        }else {
//            return null;
//        }
 //   }
}
