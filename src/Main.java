import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        fileRead("text.txt");
    }

    static void fileRead(String fileName) {

        try {
            FileReader fr = new FileReader(fileName);
            Scanner text = new Scanner(fr);
            int strNum = 0;
            String biggestWord = "a";
            while (text.hasNextLine()) {
                ArrayList<String> arrayList = new ArrayList<>();
                Scanner str = new Scanner(text.nextLine());
                while (str.hasNext()) {
                    arrayList.add(str.next());
                }
                for (int i = 0; i < arrayList.size(); i ++){
                    if (arrayList.get(i).length() >= biggestWord.length()){
                        biggestWord = arrayList.get(i);
                    }
                }
                System.out.println("Самое длинное последнее слово в строке №" + ++strNum + " слово " + biggestWord +
                        ", которое является " + (arrayList.indexOf(biggestWord)+1) + " по счёту в строке");
                arrayList.clear();
                biggestWord = "a";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}