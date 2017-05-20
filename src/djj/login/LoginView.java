package djj.login;

import com.sun.istack.internal.logging.Logger;
import djj.core.Application;
import djj.core.BaseJFrame;
import djj.login.bean.Login;
import djj.login.service.LoginService;
import djj.main.MainView;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mesmers on 2017/4/16.
 */
public class LoginView extends BaseJFrame {

    private LoginService loginService;

    private static Logger loger=Logger.getLogger(Login.class);//打印日志
    private JButton esc = new JButton("取消");
    private JLabel username = new JLabel("账号");
    private JLabel password = new JLabel("密码");
    private JTextField textusername = new JTextField(20);
    private JPasswordField textpassword = new JPasswordField(20);
    private JButton ok = new JButton("确定");
    private static String userStr;
    private static String passStr;

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public static void main(String[] args){
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
            UIManager.put("RootPane.setupButtonVisible",false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ApplicationContext ac = Application.getApplicationContext();
        ac.getBean("loginView");
    }

    public LoginView() {
        super();
        initComponents();
        setTitle("登录");
        setSize(250, 150);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(getOwner()); //居中显示
    }

    /**
     * 初始化布局
     */
    private void initComponents(){
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel1.add(username);
        textusername.setBounds(20,0,100,20);
        panel1.add(textusername);
        textpassword.setEchoChar('●');
        panel2.add(password);
        textpassword.setBounds(20,0,100,20);
        panel2.add(textpassword);
        panel3.add(ok);
        panel3.add(esc);
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);


        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screeWidth = (int) screenSize.getWidth();
        int screeHeight = (int) screenSize.getHeight();
        this.setLocation(screeWidth / 3, screeHeight / 4);
        this.pack();

        addListener();
        addClosed();
    }

    private void addListener(){
        // 退出事件
        esc.addActionListener(e->{
                // 参数为1表示非正常退出，为0则表示正常退出
                System.exit(0);
        });

        // 登录事件
        ok.addActionListener(e-> {
                // TODO Auto-generated method stub
                userStr = textusername.getText();
                passStr = new String(textpassword.getPassword());
                Login login = loginService.login(new Login(userStr,passStr));
                if (login!=null){
                    dispose();
                    ApplicationContext ac = Application.getApplicationContext();
                    MainView view = (MainView) ac.getBean("mainView");
                    view.start();
                }else{
                    JOptionPane.showMessageDialog(null, "登录失败", "提示",JOptionPane.INFORMATION_MESSAGE);
                }
        });
    }
}
