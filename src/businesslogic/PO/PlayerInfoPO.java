package businesslogic.PO;

public class PlayerInfoPO {
	/*
	 * 
	 * ��Ա�Ļ�����Ϣ���ļ���
	 * ��ȡ��㲻���ܷ����ı�  
	 * ֻ�ɶ������޸�
	 * 
	 * */
	private String name;			
	private String number;
	private String position;				//��Ա�ڳ��ϵ�λ��
	private String height;					//��Ա���  
	private double weight;					//��Ա����
	private String birth;					//����
	private int age;						
	private int exp;						//���䣬experience����˼
	private String school;					//��ҵѧУ
	
	public PlayerInfoPO(String name,String num,String p,String height,
			double weight,String birth,int age ,int exp
			,String school){
		this.name=name;
		this.number=num;
		this.position=p;
		this.height=height;
		this.weight=weight;
		this.age=age;
		this.exp=exp;
		this.birth=birth;
		this.school=school;
		
	}
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	public String getPosition() {
		return position;
	}
	public String getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public String getBirth() {
		return birth;
	}
	public int getAge() {
		return age;
	}
	public int getExp() {
		return exp;
	}
	public String getSchool() {
		return school;
	}
	/*������Ϣһ�����������㲻�����ı�*/
}
