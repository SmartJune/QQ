import java.io.*;
import java.net.*;

public class MynewServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(65529);
        //每个端口测试一次就不能用了的样子
        System.out.println("正在等待客户端上线");
        Socket socket = serverSocket.accept();
        //接受到客户端发送的信息
        System.out.println("开始：" + socket);

        GetMessage gm = new GetMessage(socket);
        SendMessage sm = new SendMessage(socket);

        Thread gt = new Thread(gm);
        Thread st = new Thread(sm);

        gt.start();
        st.start();
    }
}


// 接收消息
class GetMessage implements Runnable
{
    BufferedReader in;

    public GetMessage(Socket socket)
    {
        try
        {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
    }

    public void run()
    {

        String str = "";
        
            while (true)
            {
                try
                {
                    str = in.readLine();
                }
                catch (IOException e)
                {

                    e.printStackTrace();
                }
                if (str.equals("q"))
                {
                    break;
                }

                System.out.print("小马哥说:" + str);
            }
    }

}

// 发送消息
class SendMessage implements Runnable
{
    PrintWriter out;
    BufferedReader is;

    public SendMessage(Socket socket) throws IOException
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
                out.flush();//清空缓冲数据
            }
    
    }

}









