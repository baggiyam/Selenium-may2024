package HomeAssignments;

public class ReverseOddWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "I am a software tester";
	
		String[] words = test.split(" ");
	//i[0]=I;I[1]=am;i[2]=a ;i[3]=software;i[4]=tester;
	
		for (int i = 0; i < words.length; i++) {
			if(i%2!=0) {
				String rev=" ";
		
				for (int j = 0; j < words[i].length(); j++) {
					rev=words[i].charAt(j)+rev;
				}
				words[i]=rev;
			}
		}
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i]+" ");
		}
	}
	

}
