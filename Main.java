import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        ArrayList<Entries> phonebook = new ArrayList<>();

        System.out.println("Please enter a string");
        Scanner input = new Scanner(System.in);
        String inString = input.next();

        Path p = Paths.get("phonebook_test.txt");

        BufferedReader br = Files.newBufferedReader(p);

        String line;
        while ((line = br.readLine()) != null){
            String[] splitString = line.split("[ ,]+");
            Entries e = new Entries (splitString[0], splitString[1], splitString[2]);
            phonebook.add(e);
        }
        br.close();

        containsInput(phonebook, inString);
        selectionSort(phonebook);

    }
    public static void containsInput (ArrayList<Entries> phonebook, String s) throws IOException {
        Path p = Paths.get("output.txt");
        BufferedWriter bw = Files.newBufferedWriter(p);

        for (int i = 0; i < phonebook.size(); i++)
        {
            String firstString = phonebook.get(i).getFirstName();
            String lastString = phonebook.get(i).getLastName();

            if (firstString.contains(s))
            {
                bw.write(phonebook.get(i).getPhoneNumber() + " " + phonebook.get(i).getLastName() + ", " + phonebook.get(i).getFirstName() + "\n");
            }
            if (lastString.contains(s))
            {
                bw.write(phonebook.get(i).getPhoneNumber() + " " + phonebook.get(i).getLastName() + ", " + phonebook.get(i).getFirstName() + "\n");
            }
        }
        bw.close();
    }

    public static void selectionSort (ArrayList<Entries> phonebook){
        ArrayList<Entries> phoneCopy = new ArrayList<>();

        for (int i = 0; i < phonebook.size(); i++)
        {
            int index = 0;
            int k = i;
            for (int j = i + 1; j < phonebook.size(); j++)
            {
                /*
                if (phonebook.get(j).getFirstName().charAt(index) == phonebook.get(k).getFirstName().charAt(index))
                {
                    index++;
                }
                */
                if (phonebook.get(j).getFirstName().charAt(index) < phonebook.get(k).getFirstName().charAt(index))
                {
                    k = j;
                }
            }

            if (k != i)
            {
                //swap a[i], a[k]
                Collections.swap(phonebook, i, k);
                //How do I swap in the ArrayList? Think about this more
               // phoneCopy.add(i, phonebook.get(k));
               // phoneCopy.add(k, phonebook.get(i));
            }
        }

        for (int a = 0; a < phonebook.size(); a++)
        {
            System.out.println(phonebook.get(a).getFirstName());
        }


    }

}
