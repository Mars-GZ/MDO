package djj.node;

import djj.node.application.ExcelNode;
import djj.node.application.LabViewNode;
import djj.node.application.MatlabNode;
import djj.node.cad.SolidWorksNode;
import djj.node.cae.AnsysNode;
import djj.node.cae.AutoDeskNode;
import djj.node.data.*;
import djj.node.file.*;
import djj.node.logic.*;
import djj.node.net.*;
import djj.node.script.*;
import djj.node.target.*;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/3.
 */
public class NodeFactory {

    public static NodeJPanel createNode(String name, ImageIcon icon) {
        NodeJPanel nodeJPanel = null;
        switch (name) {
            case NodeConstant.INPUT:
                nodeJPanel = new InputNode(icon);
                break;
            case NodeConstant.OUTPUT:
                nodeJPanel = new OutputNode(icon);
                break;
            case NodeConstant.BUFFER:
                nodeJPanel = new BufferNode(icon);
                break;
            case NodeConstant.EXPRESSION_BUFFER:
                nodeJPanel = new ExpressionBufferNode(icon);
                break;
            case NodeConstant.EXTRA_INPUT:
                nodeJPanel = new ExtraInputNode(icon);
                break;
            case NodeConstant.INPUT_PARAM:
                nodeJPanel = new InputParamNode(icon);
                break;
            case NodeConstant.MORE_INPUT:
                nodeJPanel = new MoreInputNode(icon);
                break;
            case NodeConstant.EXTRA_OUTPUT:
                nodeJPanel = new ExtraOutputNode(icon);
                break;
            case NodeConstant.OUTPUT_PARAM:
                nodeJPanel = new OutputParamNode(icon);
                break;
            case NodeConstant.TRANSLATE:
                nodeJPanel = new TranslateNode(icon);
                break;
            case NodeConstant.VECTOR_INPUT:
                nodeJPanel = new VectorInputNode(icon);
                break;
            case NodeConstant.VECTOR_OUTPUT:
                nodeJPanel = new VectorOutputNode(icon);
                break;
            case NodeConstant.LOGIC_IF:
                nodeJPanel = new LogicIfNode(icon);
                break;
            case NodeConstant.DOE:
                nodeJPanel = new DOENode(icon);
                break;
            case NodeConstant.LOGIC_END:
                nodeJPanel = new LogicEndNode(icon);
                break;
            case NodeConstant.LOGIC_ERROR:
                nodeJPanel = new LogicErrorNode(icon);
                break;
            case NodeConstant.LOGIC_STOP:
                nodeJPanel = new LogicStopNode(icon);
                break;
            case NodeConstant.LOGIC_SWITCH:
                nodeJPanel = new LogicSwitchNode(icon);
                break;
            case NodeConstant.START_QUEUE:
                nodeJPanel = new StartQueueNode(icon);
                break;
            case NodeConstant.SCHEDULE:
                nodeJPanel = new ScheduleNode(icon);
                break;
            case NodeConstant.SCHEDULE_PROJECT:
                nodeJPanel = new ScheduleProjectNode(icon);
                break;
            case NodeConstant.CHILd_PROCESS:
                nodeJPanel = new ChildProcessNode(icon);
                break;
            case NodeConstant.START_SYNCHRONIZER:
                nodeJPanel = new StartSynchronizerNode(icon);
                break;
            case NodeConstant.INPUT_FILE:
                nodeJPanel = new InputFileNode(icon);
                break;
            case NodeConstant.INPUT_TEMP:
                nodeJPanel = new InputFileTempNode(icon);
                break;
            case NodeConstant.OUT_FILE:
                nodeJPanel = new OutFileNode(icon);
                break;
            case NodeConstant.OUT_TEMP:
                nodeJPanel = new OutFileTempNode(icon);
                break;
            case NodeConstant.PROJECT_FILE:
                nodeJPanel = new ProjectFileNode(icon);
                break;
            case NodeConstant.SUPPORT_FILE:
                nodeJPanel = new SupportFileNode(icon);
                break;
            case NodeConstant.TRANSLATE_FILE:
                nodeJPanel = new TranslateFileNode(icon);
                break;
            case NodeConstant.EXCEL:
                nodeJPanel = new ExcelNode(icon);
                break;
            case NodeConstant.LABVIEW:
                nodeJPanel = new LabViewNode(icon);
                break;
            case NodeConstant.MATLAB:
                nodeJPanel = new MatlabNode(icon);
                break;
            case NodeConstant.SOLID_WORKS:
                nodeJPanel = new SolidWorksNode(icon);
                break;
            case NodeConstant.ANSYS:
                nodeJPanel = new AnsysNode(icon);
                break;
            case NodeConstant.AUTO_DESK:
                nodeJPanel = new AutoDeskNode(icon);
                break;
            case NodeConstant.ADD_CONVEX:
                nodeJPanel = new AddConvexNode(icon);
                break;
            case NodeConstant.DESIGN_CONSTRAINTS:
                nodeJPanel = new DesignContraintsNode(icon);
                break;
            case NodeConstant.DESIGN_CONSTRAINTS_GRADIENT:
                nodeJPanel = new DesignConstraintsGradientNode(icon);
                break;
            case NodeConstant.DESIGN_TARGET:
                nodeJPanel = new DesignTargetNode(icon);
                break;
            case NodeConstant.DESIGN_OBJECT_GRADIENT:
                nodeJPanel = new DesignObjectGradientNode(icon);
                break;
            case NodeConstant.DESIGN_TARGET_2:
                nodeJPanel = new DesignTarget2Node(icon);
                break;
            case NodeConstant.DESIGN_APPLICATION:
                nodeJPanel = new DesignApplicationNode(icon);
                break;
            case NodeConstant.VECTOR_CONSTRAINTS:
                nodeJPanel = new VectorConstraintsNode(icon);
                break;
            case NodeConstant.VECTOR_TARGET:
                nodeJPanel = new VectorTargetNode(icon);
                break;
            case NodeConstant.FTP:
                nodeJPanel = new FTPNode(icon);
                break;
            case NodeConstant.SMTP:
                nodeJPanel = new SMTPNode(icon);
                break;
            case NodeConstant.SOMO:
                nodeJPanel = new SOMONode(icon);
                break;
            case NodeConstant.SSH:
                nodeJPanel = new SSHNode(icon);
                break;
            case NodeConstant.TFTP:
                nodeJPanel = new TFTPNode(icon);
                break;
            case NodeConstant.WebService:
                nodeJPanel = new WebServiceNode(icon);
                break;
            case NodeConstant.JS_CAL:
                nodeJPanel = new JsCalNode(icon);
                break;
            case NodeConstant.DOS:
                nodeJPanel = new DOSNode(icon);
                break;
            case NodeConstant.SIMPLE_DEV:
                nodeJPanel = new SimpleDevNode(icon);
                break;
            case NodeConstant.JPYTHON:
                nodeJPanel = new JPythonNode(icon);
                break;
            case NodeConstant.JS:
                nodeJPanel = new JsNode(icon);
                break;
            case NodeConstant.PYTHON:
                nodeJPanel = new PythonNode(icon);
                break;
        }
        return nodeJPanel;
    }

}
