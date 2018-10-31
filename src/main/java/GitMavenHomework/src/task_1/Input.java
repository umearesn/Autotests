package task_1;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Input extends Thread {
    private File file;

    Input(File file) throws Exception{
       this.file = file;
    }
    @Override
    public void run(){
        try{
            FileReader parser = new FileReader(this.file);
            Scanner scan = new Scanner(parser);
            while(scan.hasNextLine()){
                Encoder encoding = new Encoder(scan.nextLine());
                encoding.start();
            }
            scan.close();
            parser.close();
        } catch (Exception error){}
    }
}
