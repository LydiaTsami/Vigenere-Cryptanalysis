import java.util.ArrayList;
import java.util.List;

public class Keyfinder {
	
	String currkey;
	int subkey1,subkey2,subkey3,subkey4,subkey5,subkey6;
	
	public Keyfinder() {
		this.subkey1=1;
		this.subkey2=1;
		this.subkey3=1;
		this.subkey4=1;
		this.subkey5=1;
		this.subkey6=1;
		
	}
	
	//Ksekinaei apo to AAAAAA mexri na ftasei sto swsto kleidi , alliws termatizei sto ZZZZZZ kai epistrefei me timi 1 kai to currkey me timi null
	public int Findkeys() {
		
		subkey6++;		
		if(subkey6>26) {
			subkey6=1;
			subkey5++;
			if(subkey5>26) {
				subkey5=1;
				subkey4++;
				if(subkey4>26) {
					subkey4=1;
					subkey3++;
					if(subkey3>26) {
						subkey3=1;
						subkey2++;
						if(subkey2>26) {
							subkey2=1;
							subkey1++;
							if(subkey1>26) {
								currkey= null;
								return 1;
							}
						}
					}
				}
			}
		}
		return 0;
	}

	//Metatrepei enan int arithmo se char
	public String IntToChar(int i) {
		return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
	}
	
	//Prosthetei sto currkey kai ta 6 grammata afou ta metatrepsei apo int se char
	public String chartokey() {
			currkey = IntToChar(subkey1);
			currkey += IntToChar(subkey2);
			currkey += IntToChar(subkey3);
			currkey += IntToChar(subkey4);
			currkey += IntToChar(subkey5);
			currkey += IntToChar(subkey6);
		return currkey;
	}
}
