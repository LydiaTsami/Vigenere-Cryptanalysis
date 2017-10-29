import java.util.ArrayList;
import java.util.List;

public class Vigenere {
	
	int tries=0;
	String key;
	String plaintext;
	String ciphertext;
	String enc;
	String finaltext;
	List<Integer> keylist = new ArrayList<Integer>();
	 
	public Vigenere(String ciphertext, String plaintext) {
		this.ciphertext = ciphertext;
		this.plaintext = plaintext;
	}
	
	static String encrypt(String key,String text) {
		String res = "";
		key = key.toUpperCase();
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
	
	
	static String decrypt( String key,String text) {
        String res = "";
        key = key.toUpperCase();
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
	
	
	public String Decode() {
		
	Keyfinder kf = new Keyfinder();
	key=kf.chartokey();
	 do{
		 int ret;
		 ret =kf.Findkeys();
		 if(ret!=1) {
			 key = kf.chartokey();
			 System.out.println(key);
			 finaltext =decrypt(key,ciphertext);
		 	if(key=="TURING") {
		 		System.out.println("found");
		 	}
		 }
		 
		tries++;
	 }while(!finaltext.equals(plaintext));
	 System.out.println("tries :" + tries);
		
		return null;
		
	}
	
	
	
}
