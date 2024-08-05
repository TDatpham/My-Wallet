package online.digital.wallet.eWallet.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import net.bytebuddy.utility.nullability.NeverNull;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;
    
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "mobileNo")
    private String mobileNo;

    @Column(name="password")
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Wallet wallet;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + ", password="
                + password + "]";
    }
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo=mobileNo;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	
	public void setPassword(String password) {
        this.password=password;
    }
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(int id2) {
		// TODO Auto-generated method stub
		this.id=id2;
	}

	public void setWallet(Wallet wallet2) {
		// TODO Auto-generated method stub
		this.wallet=wallet2;
	}
	
    public Wallet getWallet() {
        return wallet;
    }
}

