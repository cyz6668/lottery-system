import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
class SingleChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("SingleChoose", new SingleChoose());
	}
	@Override
	public int getwinLevel() {
		// TODO Auto-generated method stub
		boolean same=true;
		for(int i=0;i<3;i++) {
			if(winNum[i]!=inputNum[i]){
				same=false;
				break;
				}
		}
		if(same)
			return 1040;
		else
			return 0;
		
	}
	
}
class GroupChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("GroupChoose", new GroupChoose());
	}
	@Override
	public int getwinLevel() {
		int num=0;
		Arrays.sort(winNum);
		Arrays.sort(inputNum);
		for(int i=0;i<3;i++) {
			if(winNum[i]!=inputNum[i]) {
				return 0;
			}
			if(i!=0&&winNum[i]==winNum[i-1]) {
				num++;
			}
		}
		if(num==0) return 173;
		else return 246;
	}
}

class GuessOneDChoose extends Lottery3D {
	static {
		Lottery3D.playList.put("GuessOneDChoose", new GuessOneDChoose());
	}
	int rnum=0;
	@Override
	public boolean getInput() {
		System.out.println("请输入0-9之间的一位数字");
		Scanner s=new Scanner(System.in);
		int inputnum=s.nextInt();
		if(inputnum>=0&&inputnum<=9) {
			rnum=inputnum;
			return true;
		}
		return false;
	}
	@Override
	public int getwinLevel() {
		int num=0;
		for(int j=0;j<3;j++) {
			if(winNum[j]==rnum) {
				num++;
			}
		}
		if(num==0) return 0;
		else if(num==1) return 2;
		else if(num==2) return 12;
		else return 230;
	}
}

class GuessTwoDChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("GuessTwoDChoose",new GuessTwoDChoose());
	}
	@Override
	public boolean getInput() {
		System.out.println("请输入10-99的整数");
		Scanner s=new Scanner(System.in);
		int inputnum=s.nextInt();
		if (inputnum<100&&inputnum>=10) {
			inputNum=new int[3];
			numsplit(inputnum,inputNum);
			return true;
		}
		else
			return false;	
	}
	@Override
	public int getwinLevel() {
		int num=0;boolean flag=false;
		Arrays.sort(inputNum);
		Arrays.sort(winNum);
		for(int i=1;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(inputNum[i]==winNum[j]) {
					num++;
				}
			}
		}
		int coun=0;
		for(int i=0;i<2;i++) {
			for(int j=i+1;j<3;j++) {
				if(winNum[i]==winNum[j]) {
					coun++;
				}
			}
		}
		if(coun>=1) {flag=true;}
		if(num>=2) {
			if(flag)return 37;
			else return 19;
		}else {
			return 0;
		}
	}
}

class TwoDChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("TwoDChoose", new TwoDChoose());
	}
	char[] inputChar;
	@Override
	public boolean getInput() {
		System.out.println("请输入确定位置的两个数字，其他位输入*，例如，请输入*12");
		Scanner s=new Scanner(System.in);
		String inputnum=s.nextLine();
		inputnum=inputnum.replace(" ", "");
		if(inputnum.length()!=3)
			return false;
		inputChar = new char[3];
		int starcount=0;
		for(int i=0;i<3;i++) {
			char temp=inputnum.charAt(i);
			if((temp>='0'&&temp<='9')||temp=='*') {
				inputChar[i]=temp;
				if(temp=='*')
					starcount++;
			}
			else
				return false;
		}
		if(starcount==1)
			return true;
		else 
			return false;
	}
	@Override
	public int getwinLevel() {
		int num=0;
		for(int i=0;i<3;i++) {
			if(inputChar[i]!='*' && winNum[i]+'0'==inputChar[i])
				num++;

		}
		if(num==2)return 104;
		else return 0;
	}
}

class AllChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("AllChoose", new AllChoose());
	}
	@Override
	public int getwinLevel() {
		int num=0;
		for(int i=0;i<3;i++) {
			if(winNum[i]==inputNum[i]){
				num++;
			}
		}
		if(num==0||num==1)return 0;
		else if(num==2)return 21;
		else return 470;
	}
}

class SumChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("SumChoose", new SumChoose());
	}
	int inputnum;
	@Override
	public boolean getInput() {
		System.out.println("请输入0-27任意数值：");
		Scanner s=new Scanner(System.in);
		inputnum=s.nextInt();
		if(inputnum>=0&&inputnum<=27) return true;
		else return false;
		
	}
	@Override
	public int getwinLevel() {
		int num=0;
		for(int i=0;i<3;i++) {
			num+=winNum[i];
		}
		if(inputnum==num) {
			if(num==27||num==0) {return 1040;}
			else if(num==1||num==26) {return 345;}
			else if(num==2||num==25) {return 172;}
			else if(num==3||num==24) {return 104;}
			else if(num==5||num==22) {return 49;}
			else if(num==6||num==21) {return 37;}
			else if(num==7||num==20) {return 29;}
			else if(num==8||num==19) {return 23;}
			else if(num==9||num==18) {return 19;}
			else if(num==10||num==17) {return 16;}
			else if(num==11||num==16) {return 15;}
			else if(num==12||num==15) {return 15;}
			else  {return 14;}
			}
		else {return 0;}
	}
}

class PacketChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("PacketChoose", new PacketChoose());
	}
	@Override
	public int getwinLevel() {
		boolean flag1=true;
		for(int i=0;i<3;i++) {
			if(winNum[i]!=inputNum[i]) {
				flag1=false;
			}
		}
		boolean flag2=false;
		int coun=0;
		for(int i=0;i<2;i++) {
			for(int j=i+1;j<3;j++) {
				if(winNum[i]==winNum[j]) {
					coun++;
				}
			}
		}
		if(coun>=1) {flag2=true;}
		
		
		if(flag1) {
			if(flag2) {return 693;}
			else return 606;
		}else {
			int num=0;
			Arrays.sort(winNum);
			Arrays.sort(inputNum);
			for(int i=0;i<3;i++) {
				if(winNum[i]!=inputNum[i]) {
					return 0;
				}
			}
			if(flag2) return 173;
			else return 86;
		}
	}
}


class GuessBigSmall extends Lottery3D{
	static {
		Lottery3D.playList.put("GuessBigSmall", new GuessBigSmall());
	}
	String inputnum;
	@Override
	public boolean getInput() {
		System.out.println("请输出‘大’或‘小’");
		Scanner s=new Scanner(System.in);
		inputnum=s.nextLine();
		inputnum=inputnum.replaceAll(" ", "");
		if(inputnum.equals("大")||inputnum.equals("小")) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public int getwinLevel() {
		int sum=0;
		for(int i=0;i<3;i++) {
			sum+=winNum[i];
		}
		if(sum>=19&&sum<=27) {
			if(inputnum.equals("大")) {return 6;}
			else return 0;
		}else {
			if(inputnum.equals("小")) {return 6;}
			else return 0;
		}
	}
}

class GuessTSame extends Lottery3D{
	static {
		Lottery3D.playList.put("GuessTSame", new GuessTSame());
	}
	String inputnum;
	@Override
	public boolean getInput() {
		System.out.println("请输出‘是’或‘否’");
		Scanner s=new Scanner(System.in);
		inputnum=s.nextLine();
		inputnum=inputnum.replaceAll(" ", "");
		if(inputnum.equals("是")||inputnum.equals("否")) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public int getwinLevel() {
		int num=0;
		for(int i=1;i<3;i++) {
			if(winNum[i]==winNum[i-1]){num++;}
		}
		if(num==2&&inputnum.equals("是"))return 104;
		else return 0;
	}
}

class GuessSOChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("GuessSOChoose", new GuessSOChoose());
	}
	String inputnum;
	@Override
	public boolean getInput() {
		System.out.println("请输出‘是’或‘否’");
		Scanner s=new Scanner(System.in);
		inputnum=s.nextLine();
		inputnum=inputnum.replaceAll(" ", "");
		if(inputnum.equals("是")||inputnum.equals("否")) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public int getwinLevel() {
		boolean flags=true;
		boolean flago=true;
		for(int i=0;i<3;i++) {
			if(winNum[i]%2==0) flags=false;
			if(winNum[i]%2==1) flago=false;
		}
		if(flags==true&&inputnum.equals("是")&&flago==false||flags==false&&inputnum.equals("否")&&flago==true)
		{
			return 8;
		}else {
			return 0;
		}
		
	}
	
}

class tractorChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("tractorChoose", new tractorChoose());
	}
	String inputnum;
	@Override
	public boolean getInput() {
		System.out.println("请输出‘是’或‘否’");
		Scanner s=new Scanner(System.in);
		inputnum=s.nextLine();
		inputnum=inputnum.replaceAll(" ", "");
		if(inputnum.equals("是")||inputnum.equals("否")) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public int getwinLevel() {
		for(int i=1;i<3;i++) {
			if(winNum[i]!=winNum[i-1]+1)
				{
				if(winNum[i]!=winNum[i-1]-1)
				{
					return 0;
				}
				}
		}
		return 65;
	}
}

class OneDChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("OneDChoose", new OneDChoose());
	}
	char[] inputChar;
	@Override
	public boolean getInput() {
		System.out.println("请输入确定位置的一个数字，其他位输入*，例如，如果确定个位数为2，请输入**2");
		Scanner s=new Scanner(System.in);
		String inputnum=s.nextLine();
		inputnum =inputnum.replaceAll(" ", "");
		if (inputnum.length()!=3)
			return false;
		inputChar=new char[3];
		int starcount=0;
		for(int i=0;i<3;i++) {
	//只能输入数字或者*	
			char temp=inputnum.charAt(i);
			if((temp>='0'&&temp<='9')||temp=='*') {
				inputChar[i]=temp;
				if(temp=='*')
					starcount++;
			}
			else
				return false;
		}
		if (starcount==2)
			return true;
		else
			return false;
		
	}
	@Override
	public int getwinLevel() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<3;i++) {
			if(inputChar[i]!='*' && winNum[i]+'0'==inputChar[i])
				return 10;

		}
		return 0;
		
	}
	
}
class Lottery3DManager{
	public static boolean checkPlayList(String playName) {
		Lottery3D temp=Lottery3D.playList.get(playName);
		if (temp==null) {
			try {
			Class.forName("lottery."+playName);//注意固定的包名，也可以设置配置文件，从配置文件里面获取
			return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		return true;
	}
}
public abstract class Lottery3D {

	int [] winNum;
	int [] inputNum;
	protected static Map<String,Lottery3D> playList=new HashMap();
	public void setWinNum(int [] winNum) {
		this.winNum=winNum;
	}
	public static void numsplit(int num,int [] t) {
		t[2]=num %10 ;
		t[1]=(num/10)%10;
		t[0]=(num/100);
	}
	public void randwinNum() {
		Random rd=new Random();
		winNum=new int[3];
		numsplit(rd.nextInt(1000),winNum);
	}
	public void printWinNum() {
		System.out.print("中奖号为：");
		for(int num:winNum) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
	public boolean getInput() {
		System.out.println("请输入0-999之间的整数");
		Scanner s=new Scanner(System.in);
		int inputnum=s.nextInt();
		if (inputnum<1000&&inputnum>=0) {
			inputNum=new int[3];
			numsplit(inputnum,inputNum);
			return true;
		}
		else
			return false;	
		
	}
	public abstract int getwinLevel();
	public static void main(String[] arg) {
		Scanner sin = new Scanner(System.in);
		System.out.println("请输入投注方式");
		while(sin.hasNext()) {
			String playtype=sin.nextLine();
			if(Lottery3DManager.checkPlayList(playtype)) {
				Lottery3D temp=Lottery3D.playList.get(playtype);
				temp.randwinNum();
				temp.printWinNum();				
				while(true) {
					if(temp.getInput()) {
						System.out.println("您获得的奖金为"+temp.getwinLevel());
						break;
					}
					else{
						System.out.println("请输入正确的投注内容");
					}
				}
			}
			else {
				System.out.println("您输入的投注方式不存在，请重新输入");
			}
			System.out.println("请输入投注方式");
		}
	}
}
