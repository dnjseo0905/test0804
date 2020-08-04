package Main.DTO;

//html로부터 form 으로 부터 받아오는 값
public class RegisterRequest {
	private String name,password,email, confrimPassword;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfrimPassword() {
		return confrimPassword;
	}

	public void setConfrimPassword(String confrimPassword) {
		this.confrimPassword = confrimPassword;
	}
	public boolean isPasswordEqualConfirmPassword() {//같다면 true 다르다면 false반환
		return password.equals(confrimPassword);
	}
	
}
