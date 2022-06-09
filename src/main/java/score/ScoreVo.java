package score;

import java.util.Vector;

public class ScoreVo {
	int sno;
	String id;
	String nal;
	String subject;
	int score;
	
	String mName;
	String phone;
	String email;
	
	public ScoreVo(){};
	public ScoreVo(int sno, String id, String nal, String subject, int score) {
		this.sno=sno;
		this.id=id;
		this.nal=nal;
		this.subject=subject;
		this.score=score;
	}
	
	
	public ScoreVo(int sno, String id, String nal, String subject, int score, String mName, String phone, String email) {
		this.sno=sno;
		this.id=id;
		this.nal=nal;
		this.subject=subject;
		this.score=score;
		
		this.mName=mName;
		this.phone=phone;
		this.email=email;
	}
	
	
	public Vector<String> getVector(){
		Vector v=new Vector();
		v.add(id);
		v.add(nal);
		v.add(subject);
		v.add(score);
		return v;
	}
	
	
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getNal() {
		return nal;
	}
	public void setNal(String nal) {
		this.nal = nal;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
