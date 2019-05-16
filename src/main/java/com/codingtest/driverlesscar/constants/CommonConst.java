package com.codingtest.driverlesscar.constants;

/**
 * 公共常量
 */
public class CommonConst {
    public static final String COMMAND_DELIMITER = ","; //命令组分隔符
    public static final String KEY_VALUE_DELIMITER = ":"; //命令键值隔符

    public static final String POSITION_X_MARK = "X"; //X轴标记
    public static final String POSITION_Y_MARK = "Y"; //Y轴标记
    public static final String ORIENTATION_MARK = "face"; //车辆朝向标记

    public static final String ORIENTATION_NORTH = "N"; //车辆朝向北
    public static final String ORIENTATION_EAST = "E"; //车辆朝向东
    public static final String ORIENTATION_SOUTH = "S"; //车辆朝向南
    public static final String ORIENTATION_WEST = "W"; //车辆朝向西

    public static final int COUNT_X_MIN_SIZE = 1; //场地X轴最小位置
    public static final int COUNT_X_MAX_SIZE = 4; //场地X轴最大位置
    public static final int COUNT_Y_MIN_SIZE = 1; //场地Y轴最小位置
    public static final int COUNT_Y_MAX_SIZE = 4; //场地Y轴最大位置
}
