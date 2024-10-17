package workshop4;

import java.io.*;
import java.net.*;

public class CookieClientHandler implements Runnable {

    private Socket s;
    private Cookie c;

    public CookieClientHandler(Socket sock, Cookie c) {

        this.s = sock;
        this.c = c;
    }

    @Override
    public void run() {
        
        String threadName = Thread.currentThread().getName();

        try{

            InputStream is = s.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            String messageReceived = "";

            try{
                OutputStream os = s.getOutputStream();
                BufferedOutputStream bos = new BufferedOutputStream(os);
                DataOutputStream dos = new DataOutputStream(bos);

                while (!messageReceived.toLowerCase().equals("quit")) {
                    messageReceived = dis.readUTF(dis);

                    //pick a random cookie
                    String retrieveCookie = c.getRandomCookie();
                    dos.writeUTF(retrieveCookie);
                    dos.flush();

                }

                dos.close();
                bos.close();
                os.close();

                dis.close();
                bis.close();
                is.close();


            } catch (Exception ex2) {

            } finally {

            }

        } catch(Exception ex) {



        } finally {

        }
    }
    
}
