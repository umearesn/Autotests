package task_1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Input extends Thread {

    private boolean isEncodingMode(){
        System.out.printf("\n%s\n", "Are we going to encode? Press 1 to encode, 0 to decode.");
        Scanner in = new Scanner(System.in);
        int i = 2;
        boolean res = false;
        while(i != 1 && i != 0) {
            i = in.nextInt();
            if (i == 1) {
                res = true;
                break;
            } else if (i == 0) {
                res =  false;
                break;
            } else {
                System.out.printf("%s\n", "Incorrect input. Try again!  Press 1 to encode, 0 to decode.");
            }
        }
        return res;
    }

    private String aimFileName(){
        System.out.printf("\n%s\n", "Write the name of the file where to write the modified passwords (if such directory exists it will be rewrited!). ");
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    private void getSource(String name) throws NullPointerException{
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(name);
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            String res = null;
            boolean isEncoding = isEncodingMode();
            String aimFileName = aimFileName();
            try {
                while ((res = reader.readLine()) != null) {
                    Encoder encoding = new Encoder(res, isEncoding, aimFileName);
                    encoding.start();
                }
            } catch (IOException error) {}
        } catch (NullPointerException error) {
            System.out.printf("%s\n", "Can't find file " + name + "!");
            System.out.printf("\n%s\n", "Write the name of the file that will be modified.");
            Scanner in = new Scanner(System.in);
            name = in.next();
            this.getSource(name);
        }
    }

    @Override
    public void run(){
        try{
            System.out.printf("\n%s\n", "Write the name of the file that will be modified.");
            Scanner in = new Scanner(System.in);
            String name = in.next();
            this.getSource(name);
        } catch (Exception error){}
    }
}
