
public class SLogin {

	private EAccount eAccount;

	public SLogin() {
		this.eAccount = new EAccount();
	}

	public VLogin login(String id, String passward) {
		VLogin vLogin = this.eAccount.getLogin(id, passward);

		if (id.equals(vLogin.getId()) && passward.equals(vLogin.getPassword())) {
			return vLogin;
		} else {
			vLogin = null;
			return vLogin;
		}
	}

}
