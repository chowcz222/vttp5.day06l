package workshop4;

import java.io.*;
import java.net.*;

public class Server {
    
    public static void main(String[] args) throws IOException {

        String portNumber = "";
        String dirPath = "";
        String fileName = "";
        if (args.length > 0) {
            portNumber = args[0];
            dirPath = args[1];
            fileName = args[2];
        } else {
            System.err.println("Invalid number of arguments expected");
            System.exit(0);
        }
        // java -cp classes workshop4.Server 3000 src\workshop4 cookie.txt // 3000 = portnumber // src\workshop4 = dirpath // cookie.txt = file name

        File newDirectory = new File(dirPath);
        if(!newDirectory.exists()) {
            newDirectory.mkdir();
        }

        //read and print cookie
        Cookie c = new Cookie();
        c.readCookieFile(dirPath + File.separator + fileName);
        c.printCookies();

        //day 4 slide 8
        ServerSocket ss = new ServerSocket(Integer.parseInt(portNumber));
        Socket s = ss.accept();
        System.out.printf("Websocket server started on port... %s", portNumber);

        //day 4 slide   9
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
