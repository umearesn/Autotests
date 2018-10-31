package task_1;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Input extends Thread {
    private File file;
    private boolean isEncoding;
    private File aim;

    Input(File file, boolean isEncoding, File aim) throws Exception{
       this.file = file;
       this.isEncoding = isEncoding;
       this.aim = aim;
    }
    @Override
    public void run(){
        try{
            FileReader parser = new FileReader(this.file);
            Scanner scan = new Scanner(parser);
            while (scan.hasNextLine()) {
                Encoder encoding = new Encoder(scan.nextLine(), this.isEncoding, aim);
                encoding.start();
            }
            scan.close();
            parser.close();
        } catch (Exception error){}
    }
}
