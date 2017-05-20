package djj.main;

import djj.core.BaseJFrame;
import djj.core.BaseJPanel;
import djj.core.GBC;
import djj.main.service.ProjectService;
import djj.menu.JMenuFactory;
import djj.menu.MenuConstant;

import javax.swing.*;
import java.awt.*;

public class MainView extends BaseJFrame {

    private ProjectService projectService;

    private GridBagLayout layout = new GridBagLayout();//Main的布局

    private BaseJPanel tabView;//标签中间件

    public BaseJPanel getTabView() {
        return tabView;
    }

    public void setTabView(BaseJPanel tabView) {
        this.tabView = tabView;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public MainView() {
        super();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initMenuBar();
        addClosed();
    }

    /**
     * 初始化菜单栏
     */
    public void initMenuBar() {
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(JMenuFactory.createJMenu(MenuConstant.FILE));
        bar.add(JMenuFactory.createJMenu(MenuConstant.EDIT));
        bar.add(JMenuFactory.createJMenu(MenuConstant.PROJECT));
        bar.add(JMenuFactory.createJMenu(MenuConstant.WINDOW));
        bar.add(JMenuFactory.createJMenu(MenuConstant.TOOLS));
        bar.add(JMenuFactory.createJMenu(MenuConstant.HELP));
    }

    /**
     * 启动主界面
     */
    public void start() {
        setVisible(true);
        setTitle("多学科设计优化软件" + "------" + projectService.getLast().getName());
        setLayout(layout);
        ContentJPane contentJPane = new ContentJPane();
        setContentPane(contentJPane);
        contentJPane.initView();
        //用来设置窗口随屏幕大小改变
        sizeWindowOnScreen(this, 1, 1);
    }

    /**
     * @param mainView
     * @param widthRate  宽度比例
     * @param heightRate 高度比例
     */
    private void sizeWindowOnScreen(MainView mainView, double widthRate,
                                    double heightRate) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        mainView.setSize(new Dimension((int) (screenSize.width * widthRate),
                (int) (screenSize.height * heightRate)));
    }

    private class ContentJPane extends BaseJPanel {

        public ContentJPane() {
            setLayout(new GridBagLayout());
        }

        @Override
        public void initView() {
            add(tabView, new GBC(0, 0).setFill(GBC.BOTH).setWeight(1,2));
            tabView.initView();
        }
    }
}
