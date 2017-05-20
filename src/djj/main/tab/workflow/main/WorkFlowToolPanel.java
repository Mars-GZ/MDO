package djj.main.tab.workflow.main;

import djj.core.BaseJPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mesmers on 2017/4/16.
 */
public class WorkFlowToolPanel extends BaseJPanel {

    private BaseJPanel tool;
    private BaseJPanel toolDetail;

    public BaseJPanel getTool() {
        return tool;
    }

    public void setTool(BaseJPanel tool) {
        this.tool = tool;
    }

    public BaseJPanel getToolDetail() {
        return toolDetail;
    }

    public void setToolDetail(BaseJPanel toolDetail) {
        this.toolDetail = toolDetail;
    }

    public WorkFlowToolPanel() {
        setLayout(new GridLayout(2,1));
    }

    @Override
    public void initView() {
        add(toolDetail);
        add(tool);
        tool.initView();
        toolDetail.initView();
        addMouseListener(null);
        addMouseMotionListener(null);
    }
}

