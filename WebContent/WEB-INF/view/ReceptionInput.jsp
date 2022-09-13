<!-- ---------------------------------------------------------------------------------------
演習番号		：総合演習
プログラム名	：事故受付入力画面
作成日			：2022/09/07
作成者			：SYS KEINA NOGUCHI
--------------------------------------------------------------------------------------------
修正履歴（修正日：担当者：修正内容）
-------------------------------------------------------------------------------------------->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<style type="text/css">

/* タブ領域全体 */
#tabcontrol {
	margin: 0;
}

/* タブ */
#tabcontrol a {
	display: inline-block; /* インラインブロック化 */
	border-width: 1px 1px 0px 1px; /* 下以外の枠線を引く */
	border-style: solid; /* 枠線の種類：実線 */
	border-color: black; /* 枠線の色：黒色 */
	border-radius: 0.75em 0.75em 0px 0px; /* 枠線の左上角と右上角だけを丸く */
	padding: 0.75em 1em; /* 内側の余白 */
	text-decoration: none; /* リンクの下線を消す */
	color: black; /* 文字色：黒色 */
	background-color: white; /* 背景色：白色 */
	font-weight: bold; /* 太字 */
	position: relative; /* JavaScriptでz-indexを調整するために必要 */
}

/* タブにマウスポインタが載った際（任意） */
#tabcontrol a:hover {
	text-decoration: underline; /* リンクの下線を引く */
}

/* タブの中身 */
#tabbody div {
	border: 1px solid black; /* 黒色の実線を1pxの太さで引く */
	margin-top: -1px; /* 上側にあるタブと1pxだけ重ねるために「-1px」を指定 */
	padding: 1em; /* 内側の余白 */
	background-color: white; /* 背景色：白色 */
	position: relative; /* z-indexを調整するために必要 */
	z-index: 0; /* 重なり順序を「最も背面」にするため */
	min-height: 5em; /* 最低の高さが必要なら指定(不要なら省略可) */
}

/* タブの配色 */
#tabcontrol a:nth-child(1), #tabbody div:nth-child(1) {
	background-color: #ffffdd;
} /* 1つ目のタブとその中身用の配色 */
#tabcontrol a:nth-child(2), #tabbody div:nth-child(2) {
	background-color: #ddffdd;
} /* 2つ目のタブとその中身用の配色 */
#tabcontrol a:nth-child(3), #tabbody div:nth-child(3) {
background-color: #ddffdd;
} /* 3つ目のタブとその中身用の配色 */

</style>
<script type="text/javascript" src="./static/js/transition.js"></script>
</head>
<body>
	<header>
		<table>
			<tr>
				<td>
					<h1>契約管理・事故受付システム ハンディー</h1>
				</td>
			</tr>
		</table>
	</header>
	<main>
		<form action="" id="@@@@@@@@@" method="post">
			<table class="button_table">
				<tr>
					<!-- 入力フォーム（お名前） -->
					<th><button type="button" onclick="＠＠＠＠＠＠＠JSの関数名を入れる＠＠＠＠＠;"
							class="button_design">トップへ戻る</button></th>
				</tr>
			</table>
		</form>
		<div class="sample-area">
			<p id="tabcontrol">
				<a href="#tabpage1">事故受付</a> <a href="#tabpage2">契約条件</a> <a
					href="#tabpage3">補償</a>
			</p>
			<div id="tabbody">
				<div id="tabpage1">
					<div class="subTitle">事故受付入力(事故受付タブ)</div>
					<table border="1" style="border-collapse: collapse">
						<tr>
							<td colspan="2">お客様情報</td>
						</tr>
						<tr>
							<td>事故受付番号</td>
							<td>11111</td>
						</tr>
						<tr>
							<td>証券番号</td>
							<td>11111</td>
						</tr>
						<tr>
							<td>契約者名</td>
							<td>東海 太郎</td>
						</tr>
					</table>
					<!-- 表示切り替えfirstBox -->
					<table border="0">
						<dl id="firstBox">
							<dl class="mailform" align="center">
								<h3>
									事故日 <input type="date" placeholder="YYYY/MM/DD">
								</h3>
								<h3>
									事故現場住所1-漢字 <input type="text" placeholder="東京都多摩市">
								</h3>
								<h3>
									事故現場住所1-カナ <input type="text" placeholder="トウキョウトタマシ">
								</h3>
								<h3>
									事故現場住所2-漢字 <input type="text" placeholder="○○町○○番地">
								</h3>
								<h3>
									事故現場住所2-カナ <input type="text" placeholder="○○チョウ○○バンチ">
								</h3>
								<h3>
									相手の状況（被害者側） <input type="text" placeholder="相手にケガはなし">
								</h3>
								<h3>
									過失割合（相手方） <input type="text" placeholder="8割">
								</h3>
								<h3>
									損害額・車両 <input type="text" placeholder="A0000001">
								</h3>
								<h3>
									損害状況・車両 <input type="text" placeholder="一部あり">
								</h3>
								<h3>
									損害額・対人 <input type="text" placeholder="A0000001">
								</h3>
								<h3>
									損害状況・対人 <input type="text" placeholder="なし">
								</h3>
								<h3>
									損害額・対物 <input type="text" placeholder="A0000001">
								</h3>
								<h3>
									損害状況・対物 <input type="text" placeholder="あり">
								</h3>
								<h3>
									損害額・傷害 <input type="text" placeholder="A0000001">
								</h3>
								<h3>
									損害状況・傷害 <input type="text" placeholder="なし">
								</h3>

							</dl>
						</dl>
					</table>
					</div>
				</div>
					<div id="tabpage2">
					<div class="subTitle">事故受付入力(契約情報タブ)</div>
					<table border="1" style="border-collapse: collapse">
							<tr>
								<td colspan="2">事故受付入力</td>
							</tr>
							<tr>
								<td>保険期間</td>
								<td><c:out
										value="${requestScope.contractInfo.getInsureanceIntervalForLabel()}" /></td>
							</tr>
							<tr>
								<td>証券番号</td>
								<td><c:out value="${requestScope.contractInfo.polNo}" /></td>
							</tr>
							<tr>
								<td>印刷連番</td>
								<td><c:out
										value="${requestScope.contractInfo.insatsuRenban}" /></td>
							</tr>
							<tr>
								<td>契約状態</td>
								<td><c:out
										value="${requestScope.contractInfo.getStatusFlgForLabel()}" /></td>
							</tr>
							<tr>
								<td>被保険者の個人法人区分</td>
								<td><c:out
										value="${requestScope.contractInfo.getInsuredKbnForLabel()}" /></td>
							</tr>
							<tr>
								<td>払込方法</td>
								<td><c:out
										value="${requestScope.contractInfo.getPaymentMethodForLabel()}" /></td>
							</tr>
							<tr>
								<td>会社名-カナ</td>
								<td><c:out
										value="${requestScope.contractInfo.getkanaNameForLabel()}" /></td>
							</tr>
							<tr>
								<td>会社名-漢字</td>
								<td><c:out
										value="${requestScope.contractInfo.getNameForLabel()}" /></td>
							</tr>
							<tr>
								<td>住所-カナ</td>
								<td><c:out
										value="${requestScope.contractInfo.getKanaAddressForLabel()}" /></td>
							</tr>
							<tr>
								<td>郵便番号</td>
								<td><c:out
										value="${requestScope.contractInfo.getPostcodeForLabel()}" /></td>
							</tr>
							<tr>
								<td>住所-漢字</td>
								<td><c:out
										value="${requestScope.contractInfo.getKanjiAddressForLabel()}" /></td>
							</tr>
							<tr>
								<td>電話番号</td>
								<td><c:out
										value="${requestScope.contractInfo.getTelephoneNoForLabel()}" /></td>
							</tr>
							<tr>
								<td>携帯電話番号</td>
								<td><c:out
										value="${requestScope.contractInfo.getMobilePhoneNoForLabel()}" /></td>
							</tr>
							<tr>
								<td>FAX番号</td>
								<td><c:out
										value="${requestScope.contractInfo.getFaxNoForLabel()}" /></td>
							</tr>
						</table>
					</div>
					<div id="tabpage2">
					<div class="subTitle">事故受付入力(契約情報タブ)</div>
					<table border="1" style="border-collapse: collapse">
							<tr>
								<td colspan="2">事故受付入力</td>
							</tr>
							<tr>
								<td>保険料</td>
								<td><c:out
										value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
							</tr>
							<tr>
								<td>メーカー</td>
								<td><c:out
										value="${requestScope.compensation.getCarName()}" /></td>
							</tr>
							<tr>
								<td>車名</td>
								<td><c:out
										value="${requestScope.compensation.getCarName()}" /></td>
							</tr>
							<tr>
								<td>車のナンバー</td>
								<td><c:out
										value="${requestScope.compensation.getCarNameForLabel()}" /></td>
							</tr>
							<tr>
								<td>車両保険金額</td>
								<td><c:out
										value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
							</tr>
							<tr>
								<td>免許証の色</td>
								<td><c:out
										value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
							</tr>
							<tr>
								<td>車両料率</td>
								<td><c:out
										value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
							</tr>
							<tr>
								<td>退陣料率</td>
								<td><c:out
										value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
							</tr>
							<tr>
								<td>対物料率</td>
								<td><c:out
										value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
							</tr>
							<tr>
								<td>障害料率</td>
								<td><c:out
										value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
							</tr>
							<tr>
								<td>年齢条件</td>
								<td><c:out
										value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
							</tr>
							<tr>
								<td>１回分保険料</td>
								<td><c:out
										value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
							</tr>
						</table>
					</div>
				</div>
				<table class="button_table">
						<tr>
							<!-- 入力フォーム（お名前） -->
							<th><button type="button" onclick="＠＠＠＠＠＠＠JSの関数名を入れる＠＠＠＠＠;"
									class="button_design">更新完了</button></th>
						</tr>
					</table>
					<table class="button_table">
						<tr>
							<!-- 入力フォーム（お名前） -->
							<th><button type="button" onclick="＠＠＠＠＠＠＠JSの関数名を入れる＠＠＠＠＠;"
									class="button_design">事故受付完了</button></th>
						</tr>
					</table>

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
				</table>
			</div>
		</div>
		<table class="button_table">
						<tr>
							<!-- 入力フォーム（お名前） -->
							<th><button type="button" onclick="＠＠＠＠＠＠＠JSの関数名を入れる＠＠＠＠＠;"
									class="button_design">前の画面へ戻る</button></th>
						</tr>
					</table>
	</main>
</body>
</html>