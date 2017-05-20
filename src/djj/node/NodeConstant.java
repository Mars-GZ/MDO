package djj.node;

/**
 * Created by mesmers on 2017/5/3.
 */
public class NodeConstant {

    public static final int INPUT_VAR = 1;

    public static final String DATA_TYPE = "数据节点";

    public static final String INPUT = "输入变量",OUTPUT = "输出变量",BUFFER="缓冲节点",
            EXPRESSION_BUFFER="表达式缓冲节点",EXTRA_INPUT="输入文件附加",
            INPUT_PARAM="输入参数",MORE_INPUT="多输入变量",EXTRA_OUTPUT="输出文件附加",
            OUTPUT_PARAM="输出参数",TRANSLATE="传输变量",VECTOR_INPUT="向量输入变量",
            VECTOR_OUTPUT="向量输出变量";

    public static final String LOGIC_TYPE = "逻辑节点";

    public static final String LOGIC_IF = "逻辑判断点",DOE="doe设计节点",LOGIC_END="逻辑结束点",
            LOGIC_ERROR="逻辑失败点",LOGIC_STOP="逻辑停止点",LOGIC_SWITCH="逻辑分发点",
            START_QUEUE="启动队列",SCHEDULE="定时器",SCHEDULE_PROJECT="定时器项目",
            CHILd_PROCESS="子进程节点",START_SYNCHRONIZER="启动同步器";

    public static final String FILE_TYPE="文件节点";

    public static final String INPUT_FILE="输入文件",INPUT_TEMP="输入模板",OUT_FILE="输出文件",
            OUT_TEMP="输出模板",PROJECT_FILE="项目文件",SUPPORT_FILE="支持文件",TRANSLATE_FILE="传输文件";

    public static final String APP_TYPE="应用程序节点";

    public static final String EXCEL="Excel",LABVIEW="LabView",MATLAB="Matlab";

    public static final String CAD_TYPE="CAD节点";

    public static final String SOLID_WORKS="SolidWorks";

    public static final String CAE_TYPE="CAE节点";

    public static final String ANSYS="Ansys",AUTO_DESK="AutoDesk";

    public static final String TARGET_TYPE="目标节点";

    public static final String ADD_CONVEX="添加凸包约束",DESIGN_CONSTRAINTS="设计约束",
             DESIGN_CONSTRAINTS_GRADIENT="设计约束梯度",DESIGN_TARGET="设计目标",
             DESIGN_OBJECT_GRADIENT="设计客观梯度",DESIGN_TARGET_2="设计目标2",DESIGN_APPLICATION="设计实用程序",
             VECTOR_CONSTRAINTS="向量约束",VECTOR_TARGET="矢量目标";

    public static final String NET_TYPE="网络节点";

    public static final String FTP="FTP",SMTP="SMTP",SOMO="SOMO",SSH="SSH",
              TFTP="TFTP",WebService="WebService";

    public static final String SCRIPT_TYPE="脚本节点";

    public static final String JS_CAL="js计算",DOS="DOS",SIMPLE_DEV="简易驱动",JPYTHON="JPython",JS="JS",PYTHON="Python";
}
