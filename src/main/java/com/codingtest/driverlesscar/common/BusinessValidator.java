package com.codingtest.driverlesscar.common;

import com.codingtest.driverlesscar.constants.CommonConst;
import com.codingtest.driverlesscar.exceptions.BusinessException;

/**
 * 业务校验器，内含各种业务校验方法
 */
public class BusinessValidator {

    /**
     * 校验传入的命令是否为空
     * @param command
     * @return
     * @throws BusinessException
     */
    public static boolean validateCommandNotNull(String command) throws BusinessException {
        if (command == null || "".equals(command.trim())) {
            throw new BusinessException("This is empty command!");
        }
        return true;
    }

    /**
     * 校验传入的命令是否有规定的分隔符
     * @param command
     * @param delimiter
     * @return
     * @throws BusinessException
     */
    public static boolean validateCommandContainDelimiter(String command, String delimiter) throws BusinessException {
        if (command == null || "".equals(command.trim())) {
            throw new BusinessException("Illegal command: there is no " + delimiter);
        }
        return true;
    }

    /**
     * 校验车辆移动后有无越界
     * @param position
     * @param positionMark
     * @return
     * @throws BusinessException
     */
    public static boolean validateCarPosition(int position, String positionMark) throws BusinessException {
        if (CommonConst.POSITION_X_MARK.equals(positionMark.toUpperCase())) {
            if (position > CommonConst.COUNT_X_MAX_SIZE || position < CommonConst.COUNT_X_MIN_SIZE) {
                throw new BusinessException("car is out of the count! ");
            }
        }

        if (CommonConst.POSITION_Y_MARK.equals(positionMark.toUpperCase())) {
            if (position > CommonConst.COUNT_Y_MAX_SIZE || position < CommonConst.COUNT_Y_MIN_SIZE) {
                throw new BusinessException("car is out of the count! ");
            }
        }

        return true;
    }
}
