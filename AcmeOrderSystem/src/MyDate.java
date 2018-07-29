
public class MyDate {
	int day;
	int month;
	int year;
	
	public MyDate() {}
	
	public MyDate(int d, int m, int y) {
		setDate(m,d,y);
	}
	
	public String toString() {
		return ""+month+"/"+day+"/"+year;
	}
	
	public void setDate(int m, int d, int y) {
		day=d;
		month=m;
		year=y;
	}
	
}
