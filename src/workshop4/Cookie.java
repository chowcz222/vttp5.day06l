package workshop4;

import java.io.*;
import java.util.*;

public class Cookie {

    List<String> cookies = new ArrayList<String>();

    public void readCookieFile(String dirPathFileName) throws IOException{

        FileReader fr = new FileReader(dirPathFileName);
        BufferedReader br = new BufferedReader(fr);

        String cookie = "";
        while ((cookie = br.readLine()) != null) {
            cookies.add(cookie);
        }
        br.close();
        fr.close();
    }

    public String getRandomCookie() {
        Random rand = new Random();

        if (cookies != null) {
            if (cookies.size() >0) {

                return cookies.get(rand.nextInt(cookies.size()));

            } else {
                return "No cookie found!!!";
            }
        }

        return "No cookie found!!!";
    }
    
    public void printCookies() {
        if (cookies.size() > 0) {
            cookies.forEach(System.out::println);
        }
    }
    
}
