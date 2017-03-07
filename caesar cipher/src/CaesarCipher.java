import java.util.Scanner;

public class CaesarCipher{
public static void main(String[] args) 
{
    String message, offset, output;
    Scanner input = new Scanner(System.in);
    int offset_length;

    System.out.println("Type string to encrypt");
    message = input.nextLine();
    System.out.println("How many letters to shift by?");
    offset = input.next();
    System.out.println(offset);
    
    offset_length = Integer.parseInt(offset);	//get actual integer value of offset
    output = encrypt(message, offset_length);
    
    for(;;){
        System.out.println("1.Encrypt");
        System.out.println("2.Decrypt");
        System.out.println("3.Exit");
        int choice = input.nextInt();
       
        switch(choice){
            case 1:	//encrypt
            	output = encrypt(message, offset_length);
                System.out.println("Encrypted: " + output.toUpperCase());
                break;
            case 2:	//decrypt
            	//output = encrypt(message, offset_length);
                System.out.println("Decrypted: " + decrypt(output, offset_length));
                break;
            case 3:	//quit
                System.exit(0);
                break;
            default:
            System.out.println("Please choose 1-3");
        }
    }
}

public static String encrypt(String message, int offset_length)
{
    String encrypted = "";	//initialize an empty string to populate with encrypted characters
    for(int i = 0; i < message.length(); i++){
        int c = message.charAt(i);
        if(Character.isUpperCase(c))	//if character is uppercase
        {								//then calculate ascii value accordingly looping around if necessary
            c = c + (offset_length % 26);
            if(c > 'Z')
                c = c - 26;
        }
        else if(Character.isLowerCase(c))//if character is lowercase
        {								//then calculate ascii value accordingly looping around if necessary
            c = c + (offset_length % 26);
            if(c > 'z')
                c = c - 26;
        }
        encrypted = encrypted + (char) c;
        System.out.println(encrypted);	//print the process, one character at a time
        try {
            Thread.sleep(250);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    return encrypted;
}

public static String decrypt(String message, int offset_length)
{
    String decrypted = "";	//initialize an empty string to populate with decrypted characters
    for(int i = 0; i < message.length(); i++){
        int c = message.charAt(i);
        if(Character.isUpperCase(c))	//reverse logic to encryption function
        {
            c = c - (offset_length % 26);
            if(c < 'A')
                c = c + 26;
        }
        else if(Character.isLowerCase(c))
        {
            c = c - (offset_length % 26);
            if(c < 'a')
                c = c + 26;
        }
        decrypted = decrypted + (char) c;
        System.out.println(decrypted);
        try {
            Thread.sleep(250);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    return decrypted;
}
}