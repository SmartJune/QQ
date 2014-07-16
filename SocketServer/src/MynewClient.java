import java.io.*;
import java.net.*;

public class MynewClient
{
    public static void main(String[] args) throws IOException
    {
        
        InetAddress addr = InetAddress.getByName("192.168.1.103");

        Socket socket = new Socket(addr, 65529);

        System.out.println("客户端发出socket=" + socket);

        CGetMessage gm = new CGetMessage(socket);
        CSendMessage sm = new CSendMessage(socket);

        Thread gt = new Thread(gm);
        Thread st = new Thread(sm);
        
        gt.start();
        st.start();
        
        
    }
}

// 接收消息
class CGetMessage implements Runnable
{

    private Socket socket;
    BufferedReader in;

    public CGetMessage(Socket socket)
    {
        this.socket = socket;

    }

    public void run()
    {
        
            BufferedReader in;
            String str = "";
            while (true)
            {
                try
                {
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    str = in.readLine();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                System.out.println("服务器说：" + str);
            }
        
    }

}

// 发送消息
class CSendMessage implements Runnable
{
    
    PrintWriter out;
    BufferedReader is;

    public CSendMessage(Socket socket) throws IOException
    {
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        is = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run()
    {

        String input = new String();
    
            while (true)
            {
                try
                {
                    input = is.readLine().trim();
                }
                catch (IOException e)
                {
    
                    e.printStackTrace();
                }

                out.println(input);
                out.flush();
            }
    }
}