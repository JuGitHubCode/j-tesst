package parts;

import java.text.DecimalFormat;
import java.util.Vector;

public class PartsVo {
	String code;
	String codeName;
	String spec;
	int price;
	
	DecimalFormat df=new DecimalFormat("###,###");
	
	public PartsVo( String code, String codeName, String spec, int price) {
		this.code=code;
		this.codeName=codeName;
		this.spec=spec;
		this.price=price;
		
	}
	
	public PartsVo(){}
	
	public Vector<String> getVector(){
		Vector<String> v=new Vector<String>();
		v.add(code);
		v.add(codeName);
		v.add(spec);
		v.add(df.format(price));
		return v;
	}
	


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getcodeName() {
		return codeName;
	}

	public void setcodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	};
	
	

}
