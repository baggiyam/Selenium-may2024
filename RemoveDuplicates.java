package HomeAssignments;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
   	 String text ="We learn Java basics as part of java sessions in java week1";
   	 String[] words = text.split(" ");
   	 for (int i = 0; i < words.length; i++) {
			for (int j = i+1; j < words.length; j++) {
				if(words[i].equalsIgnoreCase(words[j])) {
					words[j]=" ";
				}
			}
   	 }
			for(int i=0;i<words.length;i++) {
				System.out.print(words[i] + " ");
			}
   	 
}
}