package co.com.sofka.models.pageReqRes;

public class UserModel{
	private Data data;
	private Support support;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setSupport(Support support){
		this.support = support;
	}

	public Support getSupport(){
		return support;
	}
}
