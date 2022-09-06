package TS_Net.model.data;

import java.io.Serializable;

public class LoginState implements Serializable{

	/** ログイン状態 */
	private boolean loginState;

	/** 引数なしコンストラクタ */
	public LoginState() {}

	/** 以下、ゲッターとセッター */
	public boolean isLoginState() {
		return loginState;
	}

	public void setLoginState(boolean loginState) {
		this.loginState = loginState;
	}

}
