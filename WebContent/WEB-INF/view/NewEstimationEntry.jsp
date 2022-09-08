<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>

		<style type="text/css">

            /* タブ領域全体 */
            #tabcontrol {
                margin: 0;
            }

            /* タブ */
            #tabcontrol a {
                display: inline-block;                /* インラインブロック化 */
                border-width: 1px 1px 0px 1px;        /* 下以外の枠線を引く */
                border-style: solid;                  /* 枠線の種類：実線 */
                border-color: black;                  /* 枠線の色：黒色 */
                border-radius: 0.75em 0.75em 0px 0px; /* 枠線の左上角と右上角だけを丸く */
                padding: 0.75em 1em;                  /* 内側の余白 */
                text-decoration: none;                /* リンクの下線を消す */
                color: black;                         /* 文字色：黒色 */
                background-color: white;              /* 背景色：白色 */
                font-weight: bold;                    /* 太字 */
                position: relative;                   /* JavaScriptでz-indexを調整するために必要 */
            }

            /* タブにマウスポインタが載った際（任意） */
            #tabcontrol a:hover {
                text-decoration: underline;   /* リンクの下線を引く */
            }

            /* タブの中身 */
            #tabbody div {
                border: 1px solid black; /* 黒色の実線を1pxの太さで引く */
                margin-top: -1px;        /* 上側にあるタブと1pxだけ重ねるために「-1px」を指定 */
                padding: 1em;            /* 内側の余白 */
                background-color: white; /* 背景色：白色 */
                position: relative;      /* z-indexを調整するために必要 */
                z-index: 0;              /* 重なり順序を「最も背面」にするため */
                min-height: 5em;         /* 最低の高さが必要なら指定(不要なら省略可) */
            }

            /* タブの配色 */
            #tabcontrol a:nth-child(1), #tabbody div:nth-child(1) { background-color: #ffffdd; }	/* 1つ目のタブとその中身用の配色 */
            #tabcontrol a:nth-child(2), #tabbody div:nth-child(2) { background-color: #ddffdd; }	/* 2つ目のタブとその中身用の配色 */

        </style>

        <script type="text/javascript">
            function entryChange1(){
                radio = document.getElementsByName('entryPlan')
                if(radio[0].checked) {
                    document.getElementById('firstBox').style.display = "";
                    document.getElementById('secondBox').style.display = "none";
                }else if(radio[1].checked) {
                    document.getElementById('firstBox').style.display = "none";
                    document.getElementById('secondBox').style.display = "";
                }
            }
            window.onload = entryChange1;
        </script>
	</head>
	<body>
		<header>
            <table>
                <tr>
                    <td>
                        <h1>契約管理・事故受付システム　ハンディー</h1>
                    </td>
                </tr>
            </table>
        </header>
        <main>
            <div class="sample-area">

                <p id="tabcontrol">
                    <a href="#tabpage1">契約条件</a>
                    <a href="#tabpage2">補償</a>
                </p>
                <div id="tabbody">
                    <div id="tabpage1">
                        <form id="mailformpro" action="mailformpro/mailformpro.cgi" method="POST">
                            <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td align="center">
                                <h1>新規試算入力（契約条件タブ）</h1>
                                <h2>
                                  被保険者の個人・法人区分&emsp;&emsp;
                                  <label>
                                    <input type="radio" name="entryPlan" value="hoge1" onclick="entryChange1();" checked="checked" />
                                    個人</label>
                                  <label>
                                    <input type="radio" name="entryPlan" value="hoge2" onclick="entryChange1();" />
                                    法人</label>
                                </h2>
                                </td>
                            </tr>
                            </table>
                              <!-- 表示切り替えfirstBox -->
                            <table border="0">
                            <dl id="firstBox">
                                <dl class="mailform" align="center">
                                    <h3>
                                        印刷連番
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        保険期間始期日
                                        <input type="date" placeholder="YYYY/MM/DD">
                                    </h3>
                                    <h3>
                                        保険期間始期時刻
                                    </h3>
                                    <h3>
                                        保険期間満期日
                                        <input type="date" placeholder="YYYY/MM/DD">
                                    </h3>
                                    <h3>
                                        保険期間満期時刻
                                    </h3>
                                    <h3>
                                        支払方法
                                        <select>
                                            <option>直接集金</option>
                                            <option>口座振替</option>
                                            <option>クレジットカード</option>
                                        </select>
                                    </h3>
                                    <h3>
                                        払込回数
                                        <select>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>6</option>
                                            <option>12</option>
                                        </select>
                                    </h3>
                                    <h3>
                                        氏名カナ１
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        氏名カナ２
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        氏名漢字１
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        氏名漢字２
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        郵便番号
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        住所カナ１
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        住所カナ２
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        住所漢字１
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        住所漢字２
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        生年月日
                                        <input type="date" placeholder="YYYY/MM/DD">
                                    </h3>
                                    <h3>
                                        性別
                                        <label>
                                            <input type="radio"/>男
                                            <input type="radio"/>女
                                        </label>
                                    </h3>
                                    <h3>
                                        電話番号
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        携帯電話番号
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                    <h3>
                                        FAX番号
                                        <input type="text" placeholder="A0000001">
                                    </h3>
                                </dl>
                            </dl>

                              <!-- 表示切り替えsecondBox -->
                            <dl id="secondBox">
                                <dl class="mailform" align="center">
                                    <h3>
                                        印刷連番
                                    </h3>
                                    <h3>
                                        保険期間始期日
                                    </h3>
                                    <h3>
                                        保険期間始期時刻
                                    </h3>
                                    <h3>
                                        保険期間満期日
                                    </h3>
                                    <h3>
                                        保険期間満期時刻
                                    </h3>
                                    <h3>
                                        支払方法
                                    </h3>
                                    <h3>
                                        払込回数
                                    </h3>
                                    <h3>
                                        会社名カナ１
                                    </h3>
                                    <h3>
                                        会社名カナ２
                                    </h3>
                                    <h3>
                                        会社名漢字１
                                    </h3>
                                    <h3>
                                        会社名漢字２
                                    </h3>
                                    <h3>
                                        郵便番号
                                    </h3>
                                    <h3>
                                        住所カナ１
                                    </h3>
                                    <h3>
                                        住所カナ２
                                    </h3>
                                    <h3>
                                        住所漢字１
                                    </h3>
                                    <h3>
                                        住所漢字２
                                    </h3>
                                    <h3>
                                        電話番号
                                    </h3>
                                    <h3>
                                        携帯電話番号
                                    </h3>
                                    <h3>
                                        FAX番号
                                    </h3>
                                </dl>
                            </dl>
                            </table>
                          </form>
                    </div>
                    <div id="tabpage2">
                        <h1>新規試算入力（補償タブ）</h1>
                        <table border="1" width="80%">
                            <tr>
                                <td colspan="2">自動車保険料試算結果</td>
                            </tr>
                            <tr>
                                <td>保険料</td>
                                <td>○○円</td>
                            </tr>
                        </table>
                        <table border="0">
                            <tr>
                                <td align="center">
                                <h3>
                                    メーカー
                                </h3>
                                <h3>
                                    車名
                                </h3>
                                <h3>
                                    車のナンバー
                                </h3>
                                <h3>
                                    一回分保険料
                                </h3>
                                <h3>
                                    車両保険金額
                                </h3>
                                <h3>
                                    免許証の色
                                </h3>
                                <h3>
                                    車両料率
                                </h3>
                                <h3>
                                    対人料率
                                </h3>
                                <h3>
                                    対物料率
                                </h3>
                                <h3>
                                    傷害料率
                                </h3>
                                <h3>
                                    年齢条件
                                </h3>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>

            </div>

            <script type="text/javascript">

                // 対象の要素を得る
                var tabs = document.getElementById('tabcontrol').getElementsByTagName('a');
                var pages = document.getElementById('tabbody').getElementsByTagName('div');

                function changeTab() {
                    // href属性値から対象のid名を抜き出す
                    var targetid = this.href.substring(this.href.indexOf('#')+1,this.href.length);

                    // 指定のページだけを表示する
                    for(var i=0; i<pages.length; i++) {
                        if( pages[i].id != targetid ) {
                            pages[i].style.display = "none";
                        }
                        else {
                            pages[i].style.display = "block";
                        }
                    }

                    // クリックされたタブを前面に表示する
                    for(var i=0; i<tabs.length; i++) {
                        tabs[i].style.zIndex = "0";
                    }
                    this.style.zIndex = "10";

                    // ページ遷移しないようにfalseを返す
                    return false;
                }

                // すべてのタブに対して、クリック時にchangeTab関数が実行されるよう指定する
                for(var i=0; i<tabs.length; i++) {
                    tabs[i].onclick = changeTab;
                }

                // 最初は先頭のタブを選択
                tabs[0].onclick();

            </script>
        </main>
	</body>
</html>