package online.digital.wallet.eWallet.Model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SigninDto {
    private String email;
    private String password;

    @Override
    public String toString() {
        return "SigninDto [email=" + email + ", password=" + password + "]";
    }

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
    public void setEmail(String email) {
        this.email=email;
    }
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
    public void setPassword(String password) {
        this.password = password;
    }
}

